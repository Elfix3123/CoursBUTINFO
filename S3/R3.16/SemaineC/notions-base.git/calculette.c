#include <stdlib.h>

int main(int argc, char *argv[])
{
	if (argc != 4)
	{
		return EXIT_FAILURE;
	}
	
	int lhs = atoi(argv[1]);
	char op = argv[2][0];
	int rhs = atoi(argv[3]);
	int res = 0;

	if (op == '+')
	{
		res = lhs + rhs;
	}
	else if (op == '-')
	{
		res = lhs - rhs;
	}
	else if (op == 'x')
	{
		res = lhs * rhs;
	}
	else if (op == '/')
	{
		res = lhs / rhs;
	}
	
	printf("%d %c %d = %d\n", lhs, op, rhs, res);
	
	return EXIT_SUCCESS;
}