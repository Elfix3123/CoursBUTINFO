#include <stdlib.h>

#define BUFFER_LEN 64

void bin2dec(char bin[], char dec[]);

int main(int argc, char *argv[])
{
	printf("donner un nombre en binaire : ");
	char bin[BUFFER_LEN];
	scanf("%s", bin);
	char dec[BUFFER_LEN];
	bin2dec(bin, dec);
	printf("<%s>2 = <%s>10\n", bin, dec);
	return EXIT_SUCCESS;
}

void bin2dec(char bin[], char dec[])
{
	int i = 0;
	while (i < BUFFER_LEN && bin[i] != '\0')
	{
		i++;
	}
	
	int len = i;
	i--;

	int res = 0;

	while (i >= 0)
	{
		res = res * 2 + (bin[i] == '1');
		i--;
	}
	
	sprintf(dec, "%d", res);
}