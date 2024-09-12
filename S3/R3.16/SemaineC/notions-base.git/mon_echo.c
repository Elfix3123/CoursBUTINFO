#include <stdlib.h>

int main(int argc, char *argv[])
{
	int i = 1;

	while (i < argc)
	{
		printf("%s ",argv[i]);
		i++;
	}
	

	return EXIT_SUCCESS;
}
