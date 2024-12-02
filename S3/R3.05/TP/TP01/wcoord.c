#include <stdlib.h>	/* pour exit() */
#include <stdio.h>	/* pour printf() and co */
#include <unistd.h>	/* pour getpid() */
#include <sys/types.h>  /* pour getpid() */

int main(int argc, char *argv[])
{
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
  return EXIT_SUCCESS;
}
