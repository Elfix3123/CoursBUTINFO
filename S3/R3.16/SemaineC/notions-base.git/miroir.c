#include <stdlib.h>

#define BUFFER_LEN 64

int main(void)
{
	char orig[BUFFER_LEN] = "bonjour";
	// = {0}; is the universal zero initializer, C99 Standard 6.7.8.21
	char mirror[BUFFER_LEN] = {0};  // fill buffer with 0 (a.k.a. '\0')

	int i = 0;

	while (orig[i] != '\0')
	{
		i++;
	}

	i--;
	int imax = i;

	while (i >= 0)
	{
		mirror[imax-i] = orig[i];
		printf("imax - i = %d, mirror = %c\n", imax-i, mirror[imax-i]);
		i--;
	}

	// Affichage sur la sortie standard 
	printf("%s\n", mirror);

	return EXIT_SUCCESS;
}
