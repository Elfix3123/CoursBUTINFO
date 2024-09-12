#include <stdlib.h>

int afficheProduit(int a, int b);

int main(void)
{
	printf("programme qui multiplie 2 nombres\n");
	int a, b;
	printf("saisir un premier nombre : ");
	scanf("%d", &a);
	printf("saisir un deuxième nombre : ");
	scanf("%d", &b);
	afficheProduit(a, b);

	return EXIT_SUCCESS;
}

int afficheProduit(int a, int b)
{
	printf("%d X %d = %d \n", a, b, a*b);
}