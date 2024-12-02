/*--------------------------------------------------------------------------
 * Programme à compléter pour expérimenter l'usage de fork
 * -----------------------------------------------------------------------*/

/*--------------------------------------------------------------------------
 * headers à inclure afin de pouvoir utiliser divers appels systèmes
 * -----------------------------------------------------------------------*/
#include <stdio.h>	/* pour printf() and co */
#include <stdlib.h>	/* pour exit() */
#include <errno.h>	/* pour errno and co */
#include <unistd.h>	/* pour fork() */
#include <sys/types.h>  /* pour pid_t */

/*--------------------------------------------------------------------------
 * Fonction principale
 * -----------------------------------------------------------------------*/
int main(void)
{
	pid_t res;
	int generation=1;

	res = fork();
	if (res==-1) {perror("Echec fork "); exit(errno); }

	if (res==0)
		generation ++;

	res = fork();
	if (res==-1) {perror("Echec fork "); exit(errno); }

	if (res==0)
		generation ++;

	printf("%*s %d : je suis %d fils de %d, res = %d\n", 1+2*generation, "gen", generation,
												 getpid(), getppid(), (int)res);

	return EXIT_SUCCESS;
}
