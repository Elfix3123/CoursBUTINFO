#include <stdlib.h>	/* pour exit() */
#include <stdio.h>	/* pour printf() and co */
#include <errno.h>	/* pour errno and co */
#include <unistd.h>	/* pour fork() */
#include <sys/types.h>  /* pour fork() */
#include <sys/wait.h>   /* pour waitpid() */
#include <sched.h>

#define NB_MAX 50

static pid_t exploration(char ** arg)
{
  pid_t res_f, res_e;

  res_f=fork();
  if (res_f==-1) {perror("Echec fork "); exit(errno); }

  cpu_set_t mask;
  CPU_ZERO(&mask);
  CPU_SET(0,&mask); // 0 ou numero
  sched_setaffinity(0,sizeof(cpu_set_t),&mask);

  if (res_f==0)
  {
    res_e=execvp(arg[0],arg);
    if (res_e==-1) {perror("Echec execvp "); exit(errno); }
 }

 return res_f;
}

int main(int argc, char *argv[])
{
  if (argc != 2)
  {
    fprintf(stderr, "Usage : %s <nombre d'explorateurs>\n", argv[0]);
    exit(EXIT_FAILURE);
  }

  unsigned int nbe = (unsigned)atoi(argv[1]);

  if ( nbe > NB_MAX )
  {
    fprintf(stderr, "Restons raisonnable: ne dépassons pas %d explorateurs!\n", NB_MAX);
    exit(EXIT_FAILURE);
  }
  pid_t pids[NB_MAX];

  char id[3];
  char *cmd[]={"", "", "300000000", NULL};
  cmd[1]=id;
  char* region[2]={"./bin-gcc/wcoord-time","./bin-gcc/ecoord-time"};

  for (unsigned int i=0; i < nbe; ++i)
  {
    cmd[0]=region[i%2];
    sprintf(id, "%d",i);
    pids[i] = exploration(cmd);
  }

  pid_t res_w;
  for (unsigned int i=0; i < nbe; ++i)
  {
    res_w=waitpid(pids[i],NULL,0);
    if (res_w==-1) {perror("Echec wait "); exit(errno); }
  }

  printf("\n");

  return EXIT_SUCCESS;
}
