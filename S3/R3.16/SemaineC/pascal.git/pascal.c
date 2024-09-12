#include <stdlib.h>
#include <stdio.h>

#define BUFFER_LEN 64

int **pascal_malloc(int profondeur);
void free_pascal(int **pascal, int profondeur);
void pascal_fill(int **pascal, int profondeur);
void pascal_display(int **pascal, int profondeur);

int main(int argc, char *argv[])
{
	/*
	if (argc != 2)
	{
		return EXIT_FAILURE;
	}
	*/
	int **pascal = pascal_malloc(5);
	pascal_fill(pascal, 5);
	pascal_display(pascal, 5);
	free_pascal(pascal, 5);

	return EXIT_SUCCESS;
}

int **pascal_malloc(int profondeur)
{
	int **pascal = malloc((profondeur + 1) * sizeof(*pascal));
	int i = 0;

	while (i <= profondeur)
	{
		pascal[i] = malloc((i + 1) * sizeof(**pascal));
		i++;
	}
	
	return pascal;
}

void free_pascal(int **pascal, int profondeur)
{
	int i = 0;
	/*
	while (i <= profondeur)
	{
		free(pascal[i]);
		i++;
	}*/
	
	free(pascal);

	return;
}

void pascal_fill(int **pascal, int profondeur)
{
	int i = 0, j;
	while (i <= profondeur)
	{
		j = 0;
		while (j < i + 1)
		{
			pascal[i][j] = (j == 0 || j == i) ? 1 : pascal[i - 1][j - 1] + pascal[i - 1][j];
			j++;
		}
		
		i++;

	}
	
	return;
}

void pascal_display(int **pascal, int profondeur)
{
	int i = 0, j;
	while (i <= profondeur)
	{
		j = 0;
		while (j < i + 1)
		{
			printf("%d\t", pascal[i][j]);
			j++;
		}
		printf("\n");
		i++;
	}
	
	return;
}