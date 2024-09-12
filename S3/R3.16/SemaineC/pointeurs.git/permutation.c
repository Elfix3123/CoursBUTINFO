#include <stdlib.h>

#define BUFFER_LEN 64

void permuter(int *adr_a, int *adr_b);

int main(int argc, char *argv[])
{
	if (argc != 3)
	{
		return EXIT_FAILURE;
	}

	int a = atoi(argv[1]);
	int b = atoi(argv[2]);

	printf("a = %d, b = %d\n", a, b);
	permuter(&a, &b);
	printf("a = %d, b = %d\n", a, b);

	return EXIT_SUCCESS;
}

void permuter(int *adr_a, int *adr_b)
{
	int tmp = *adr_a;
	*adr_a = *adr_b;
	*adr_b = tmp;
}