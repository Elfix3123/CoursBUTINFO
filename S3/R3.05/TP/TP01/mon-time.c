#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/time.h>

#define MILLION 1000000.0

/*--------------------------------------------------------------------------
 * Fonctions secondaires
 * -----------------------------------------------------------------------*/
static void cree_enfant(pid_t *pid)
{
	*pid = fork();
	if (*pid == -1) {perror("Echec fork "); exit(errno); }
}

static void executer_commande(char *arg[])
{
	int res=execvp(arg[0],arg);
	if (res==-1) {perror("Echec execvp "); exit(errno);}
}

static void attends_enfant(pid_t enfant, int *code)
{
	int res=waitpid(enfant, code, 0);
	if (res==-1) {perror("Echec waitpid "); exit(errno);}
}

///////////////////////////////////////////////////////////////////////////////

int main(int argc, char* argv[])
{
  // on prend la mesure du temps avant le fork()
  // pour avoir des mesures plus stables
  // à compléter : déclaration de deux variables t1 et t2 de type struct timeval
  //               et 1ère mesure du temps dans t1
  struct timeval t1, t2;
  gettimeofday(&t1, NULL);

  // si une commande est passée en argument, on la fait exécuter par un fils
  if (argc>1)
  {
    pid_t pid;
    cree_enfant(&pid);

    // à corriger : test père/fils
    if (pid==0)
    { // on est dans le fils
      // à remplacer : exécution de la commande passée en argument
      printf("exécution de %s\n", argv[1]);
      executer_commande(argv+1);
    }
    else
    { // on est dans le père
      int code;
      attends_enfant(pid, &code);
    }
  }

  // fin de la mesure du temps
  // à compléter : 2ème mesure du temps dans t2
  //               et calcul du temps écoulé
  gettimeofday(&t2, NULL);
  double temps_ecoule = ((t2.tv_sec - t1.tv_sec) + (t2.tv_usec - t1.tv_usec) / MILLION);
  fprintf(stdout,"temps écoulé : %lf secondes\n", temps_ecoule);

  return EXIT_SUCCESS;
}
