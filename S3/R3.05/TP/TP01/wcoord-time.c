#include <stdlib.h>	/* pour exit() */
#include <stdio.h>	/* pour printf() and co */
#include <unistd.h>	/* pour getpid() */
#include <sys/types.h>  /* pour getpid() */
#include <time.h>
#include <sys/time.h>
#define MILLIARD 1000000000.0

int main(int argc, char *argv[])
{
  struct timespec rt1,rt2,ct1,ct2;
  clock_gettime(CLOCK_REALTIME,&rt1);
  clock_gettime(CLOCK_PROCESS_CPUTIME_ID,&ct1);

  if (argc != 3)
  {
    fprintf(stderr, "Usage : %s <numéro d'explorateur> <nb_steps>\n", argv[0]);
    exit(EXIT_FAILURE);
  }

  unsigned long int nb_steps = (unsigned)atol(argv[2]);
  long int y = 0;

  srand((unsigned)getpid());

  for (unsigned long i = 0 ; i < nb_steps; ++i)
    y += rand()%3 - 1;

  printf("\nOUEST Explorateur %d : position finale = %ld", atoi(argv[1]),y);
  fflush(stdout);

  clock_gettime(CLOCK_PROCESS_CPUTIME_ID,&ct2);
  clock_gettime(CLOCK_REALTIME,&rt2);
  double temps_cpu_ecoule = (double)(ct2.tv_sec-ct1.tv_sec) + (double)(ct2.tv_nsec-ct1.tv_nsec)/MILLIARD;
  printf("\ndurée cpu    : %lf secondes", temps_cpu_ecoule);
  double temps_reel_ecoule= (double)(rt2.tv_sec-rt1.tv_sec) + (double)(rt2.tv_nsec-rt1.tv_nsec)/MILLIARD;
  printf("\ndurée réelle : %lf secondes\n", temps_reel_ecoule);

  return EXIT_SUCCESS;
}
