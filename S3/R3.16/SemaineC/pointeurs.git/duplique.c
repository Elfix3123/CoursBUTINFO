#include <stdlib.h>
#include <string.h>

#define BUFFER_LEN 64

char *copier_chaine(char *str);

int main(int argc, char *argv[])
{
	char original[] = "Ma super chaine a copier";
	char *copie;  // copie a allouer dynamiquement

	copie = copier_chaine(original);
	printf("%s\n", copie);
	free(copie);

	return EXIT_SUCCESS;
}

char *copier_chaine(char *str)
{
	char *res = malloc(strlen(str) + 1);
	// char res[strlen(str) + 1];

	res = strncpy(res, str, strlen(str));
	res[strlen(str)] = '\0';

	return res;
}