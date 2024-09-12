#include <stdlib.h>

void putchars(unsigned int repeat, char ch);

int main(int argc, char *argv[])
{
	if (argc != 3)
	{
		return EXIT_FAILURE;
	}
	
	int hauteur = atoi(argv[1]);
	char ch = argv[2][0];
	int i = 0;
	while (i < hauteur)
	{
		putchars(hauteur - i - 1, ' ');
		putchars(2 * i + 1, ch);
		printf("\n");
		i++;
	}
	
	return EXIT_SUCCESS;
}

void putchars(unsigned int repeat, char ch)
{
	int i = 0;
	while (i < repeat)
	{
		printf("%c", ch);
		i++;
	}
	
}