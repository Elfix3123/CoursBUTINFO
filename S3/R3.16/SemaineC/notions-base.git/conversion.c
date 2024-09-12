#include <stdlib.h>

float celsius(float fahrenheit);

int main(void)
{
	printf("-----------------------\nFahrenheit	Celsius\n-----------------------\n");
	
	int i = 0;
	while (i < 220)
	{
		printf("\t%d\t%.1f\n", i, celsius((float)i));
		i += 20;
	}
	
	return EXIT_SUCCESS;
}

float celsius(float fahrenheit)
{
	return (fahrenheit - 32) * 5 / 9;
}