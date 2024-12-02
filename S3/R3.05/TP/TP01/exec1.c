/*--------------------------------------------------------------------------
 * headers à inclure afin de pouvoir utiliser divers appels systèmes
 * -----------------------------------------------------------------------*/
#include <unistd.h>	/* pour execvp() */
#include <stdlib.h>	/* pour EXIT_* */
#include <stdio.h>	/* pour perror() */
#include <errno.h>	/* pour errno and co */
#include <sys/types.h>	/* pour pid_t */
#include <sys/wait.h>   /* pour wait() and co */

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

/*--------------------------------------------------------------------------
 * Fonction principale
 * -----------------------------------------------------------------------*/
int main(void)
{
	char *cmd1[]={"ls", "tetsdf", NULL};
	pid_t enfant;

	cree_enfant(&enfant);

	if (enfant == 0) {
		executer_commande(cmd1);
	}
	else {
		int code;
		waitpid(enfant, &code, 0);
		printf("%s terminé : %d\n",cmd1[0], code);
	}

	return EXIT_SUCCESS;
}
