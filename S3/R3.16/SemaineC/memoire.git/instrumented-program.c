#define _POSIX_C_SOURCE 200809L  // POSIX.1-2008 (correctness of function pointer cast)

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define COMMAND_BUFFER_LEN 64

/* TODO: déclarer les variables globales ici */
int globvar_decl;
int globvar_init = 420;

static void dump_memory_map(void)
{
	char command[COMMAND_BUFFER_LEN] = {0};

	puts("address                   perms offset  dev   inode                      pathname\n"
	     "-------                   ----- ------  ---   -----                      --------");
	snprintf(command, COMMAND_BUFFER_LEN, "cat /proc/%d/maps", getpid());
	system(command);
}

int main(void)
{
	/* variables globales */
	printf("\nadresse `globvar_decl`: %p\ncontenu `globvar_decl`: %p\n\n",
	       (void *)&globvar_decl,
	       (void *)globvar_decl);

	printf("\nadresse `globvar_init`: %p\ncontenu `globvar_init`: %p\n\n",
	       (void *)&globvar_init,
	       (void *)globvar_init);

	/* variables locales */
	const char *str = "Hello world!";
	puts(str);
	printf("\nadresse `str`: %p\ncontenu `str`: %p\n\n",
	       (void *)&str,
	       (void *)str);

	/* allocation dynamique */
	char *alloc = malloc(42 * sizeof(char));
	printf("adresse `alloc`: %p\ncontenu `alloc`: %p\n\n",
	       (void *)&alloc,
	       (void *)alloc);
	free(alloc);

	/* variables globales */
	/* TODO: afficher les adresses et contenus des variables globales */

	/* fonctions */
	printf("adresse `main()`: %p\n", (void *)main);
	printf("adresse `dump_memory_map()`: %p\n\n", (void *)dump_memory_map);

	/*
	 * Note on function pointer cast:
	 *
	 * Casting a function pointer into a regular pointer is undefined
	 * behavior in the C standard.
	 * It is however mentioned as an extension in section J.5.7 'Function
	 * pointer casts'.
	 *
	 * POSIX (since POSIX.1-2008 Technical Corrigendum 1) however requires
	 * for conformance, see section 2.12.3 'Pointer Types', that function
	 * pointer univocally maps to a void *.
	 *
	 * As a result, the cast `(void *)function` is valid on Linux.
	 */

	dump_memory_map();

	return EXIT_SUCCESS;
}
