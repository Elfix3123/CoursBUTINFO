#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#define BUFFER_LEN 64
#define _POSIX_C_SOURCE 199309L  // nanosleep in POSIX.1b (real-time extensions)
#define ON '*'
#define OFF '.'
#define NB_AMPOULES 8
#define INTERVALE 200

static void ms_sleep(const unsigned long long int ms);

int main(int argc, char *argv[])
{
	if (argc != 1)
	{
		return EXIT_FAILURE;
	}

	char *chenillard = malloc(NB_AMPOULES);

	int i = 0;
	while (i < NB_AMPOULES)
	{
		chenillard[i] = OFF;
		i++;
	}
	
	i = 0;
	int diff = 1;

	while (1)
	{
		chenillard[i] = ON;
		printf("%s\r", chenillard);
		fflush(stdout);
		ms_sleep(INTERVALE);
		chenillard[i] = OFF;

		i += diff;

		if (i == 0 || i == NB_AMPOULES - 1)
		{
			diff = -diff;
		}
	}

	return EXIT_SUCCESS;
}

static void ms_sleep(const unsigned long long int ms)
{
	struct timespec delay = {
		.tv_sec = ms / 1000,
		.tv_nsec = ms % 1000 * 1000000,
	};
	nanosleep(&delay, NULL);
}