#include <stdlib.h>

#define BUFFER_LEN 64

void dec2bin(char dec[], char bin[]);

int main(int argc, char *argv[])
{
	printf("donner un nombre en decimal : ");
	char dec[BUFFER_LEN];
	scanf("%s", dec);
	char bin[BUFFER_LEN];
	dec2bin(dec, bin);
	printf("<%s>10 = <%s>2\n", dec, bin);
	return EXIT_SUCCESS;
}

void dec2bin(char dec[], char bin[])
{
	int decint = atoi(dec);
	int i = 0;
	char bincalc[BUFFER_LEN];

	while (decint > 0)
	{
		bincalc[i] = decint % 2 + '0';
		decint /= 2;
		i++;
	}
	
	sprintf(bin, "%s", bincalc);
}