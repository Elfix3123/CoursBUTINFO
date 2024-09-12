#include <stdlib.h>

#define BUFFER_LEN 64

int carre_copie(int n);
void carre_adresse(int *adr_n);

int main(int argc, char *argv[])
{
	if (argc != 2)
	{
		return EXIT_FAILURE;
	}
	
	int n = atoi(argv[1]);
	printf("carre_copie(%d) = %d\n", atoi(argv[1]), carre_copie(n));
	carre_adresse(&n);
	printf("carre_adresse(%d) = %d\n", atoi(argv[1]), n);
	return EXIT_SUCCESS;
}

int carre_copie(int n)
{
	return n * n;
}

void carre_adresse(int *adr_n)
{
	*adr_n = *adr_n * *adr_n;
}