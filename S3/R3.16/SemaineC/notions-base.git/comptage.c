#define _POSIX_C_SOURCE 200809L  // getline in POSIX.1-2008

/* à compléter: entêtes */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFFER_LEN 64

/*
 * readline() reads an entire line from stream and stores at most one less than
 * size characters into the buffer pointed to by buffer.
 * A terminating null byte ('\0') is stored after the last character in the
 * buffer.
 *
 * On success, readline() returns the number of characters read, excluding the
 * terminating null byte ('\0').
 *
 * The function returns -1 on failure to read a line (including end-of-file
 * condition).
 */
static ssize_t readline(char *buffer, size_t size, FILE *stream)
{
	char *line = NULL;
	size_t len = 0;
	ssize_t nread;
	ssize_t ncopied = -1;

	nread = getline(&line, &len, stream);
	if (nread != -1) {
		// copy at most size - 1 bytes
		ncopied = nread < (ssize_t)size - 1 ? nread : (ssize_t)size - 1;
		memcpy(buffer, line, ncopied);
		// terminating null byte
		buffer[size] = '\0';
	}
	free(line);

	return ncopied;
}

int main(void)
{

	char buffer[BUFFER_LEN];
	ssize_t nread;

	printf("Entrez une chaine quelconque : ");

	nread = readline(buffer, BUFFER_LEN, stdin);
	
	// Comptage de chaque caractère
	int charRencontres[BUFFER_LEN] = {0};
	int nCharRencontres[BUFFER_LEN] = {0};

	int i = 0, j;
	while (i < BUFFER_LEN && buffer[i] != '\0')
	{
		j = 0;

		while (charRencontres[j] != 0 && charRencontres[j] != buffer[i])
		{
			j++;
		}

		if (charRencontres[j] == 0)
		{
			charRencontres[j] = buffer[i];
			nCharRencontres[j] = 1;
		}
		else
		{
			nCharRencontres[j]++;
		}

		i++;
	}

	// Affichage du résultat
	i = 0;
	while (charRencontres[i] != 0)
	{
		printf("%c(0x%x): %d\n", charRencontres[i], charRencontres[i], nCharRencontres[i]);	// Affichage buggé du \n => demander
		i++;
	}
	

	return EXIT_SUCCESS;
}
