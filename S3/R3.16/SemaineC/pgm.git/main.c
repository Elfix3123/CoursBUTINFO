#include <stdlib.h>
#include <stdio.h>
#include <pgmio.h>
#include <time.h>

#include "allocation.h"
#include "traitement.h"

#define BUFFER_LEN 64

void pgm_show(char *filename);

int main(int argc, char *argv[])
{
	int time = clock();
	pgm_t_image *pgm = pgm_read("guadalest.pgm");
	pgm_write("guadalest_copy.pgm", pgm);
	pgm_negative(pgm);
	pgm_write("guadalest_nega.pgm", pgm);
	pgm_threshold(pgm, PGM_PIXEL_MAX/2);
	pgm_write("guadalest_thresh.pgm", pgm);
	pgm_free(pgm);
	
	pgm = pgm_malloc(100, 200);
	pgm_solid(pgm, 'A');
	pgm_write("solid.pgm", pgm);
	pgm_gradient(pgm);
	pgm_write("gradient.pgm", pgm);
	pgm_free(pgm);	
	
	printf("Temps d'execution : %ld\n", clock() - time);
			
	return EXIT_SUCCESS;
}

void pgm_show(char *filename)
{
	char *command = malloc(BUFFER_LEN);
	sprintf(command, "gwenview %s", filename);
	system(command);
	free(command);
}
