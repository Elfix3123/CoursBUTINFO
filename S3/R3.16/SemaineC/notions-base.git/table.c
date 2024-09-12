#include <stdlib.h>

int afficheProduit(int a, int b);

int main(void)
{
	printf("vous voulez la table de combien ? ");
	int a;
	scanf("%d", &a);

	int i = 0;
	while (i < 11)
	{
		afficheProduit(a, i);
		i++;
	}
	
	return EXIT_SUCCESS;
}

int afficheProduit(int a, int b)
{
	printf("%d X %d = %d \n", a, b, a*b);
}