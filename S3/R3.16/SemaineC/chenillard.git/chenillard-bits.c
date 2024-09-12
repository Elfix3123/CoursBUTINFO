#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <time.h>

#define BUFFER_LEN 64
#define _POSIX_C_SOURCE 199309L  // nanosleep in POSIX.1b (real-time extensions)
#define ON '*'
#define OFF '.'
#define NB_AMPOULES 16
#define INTERVALE 200
#if NB_AMPOULES <= 8
	typedef uint8_t t_switch;
#elif NB_AMPOULES <= 16
	typedef uint16_t t_switch;
#elif NB_AMPOULES <= 32
	typedef uint32_t t_switch;
#elif NB_AMPOULES <= 64
	typedef uint64_t t_switch;
#else
	#error "NB_AMPOULES too big"
#endif

static void ms_sleep(const unsigned long long int ms);
unsigned char is_bulb_on(t_switch state, unsigned char bulb);
t_switch invert(t_switch state);
t_switch pow(t_switch base, t_switch exponent);
t_switch increment(t_switch state);
t_switch rotate_left(t_switch state);
t_switch rotate_right(t_switch state);
void affiche_chenillard(t_switch chenillard);

int main(int argc, char *argv[])
{
	if (argc != 1)
	{
		return EXIT_FAILURE;
	}

	t_switch chenillard = 453;

	while (1)
	{
		chenillard = invert(chenillard);
		affiche_chenillard(chenillard);
		ms_sleep(INTERVALE);
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

unsigned char is_bulb_on(t_switch state, unsigned char bulb)
{
	t_switch mask = pow(2, bulb);
	return (state & mask) == mask;
}

t_switch invert(t_switch state)
{
	return -state;
}

t_switch pow(t_switch base, t_switch exponent)
{
	if (exponent == 0)
	{
		return 1;
	}
	else if (exponent == 1)
	{
		return base;
	}
	else
	{
		return base * pow(base, exponent - 1);
	}	
}

t_switch increment(t_switch state)
{
	return state + 1;
}

t_switch rotate_left(t_switch state)
{
	t_switch inc = 0;

	if (is_bulb_on(state, NB_AMPOULES-1))
	{
		inc = 1;
	}
	
	state = (state << 1) + inc;

	return state;
}

t_switch rotate_right(t_switch state)
{
	t_switch inc = 0;

	if (is_bulb_on(state, 0))
	{
		inc = pow(2, NB_AMPOULES - 1);
	}
	
	state = (state >> 1) + inc;

	return state;
}

void affiche_chenillard(t_switch chenillard)
{
	char *display = malloc(NB_AMPOULES * sizeof(char));

	int i = 0;
	while (i < NB_AMPOULES)
	{
		display[i] = is_bulb_on(chenillard, i) ? ON : OFF;
		i++;
	}
	
	printf("%s\r", display);
	fflush(stdout);

	return;
}