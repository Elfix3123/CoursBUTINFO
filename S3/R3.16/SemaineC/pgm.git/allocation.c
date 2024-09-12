#include "allocation.h"

pgm_t_image *pgm_malloc(size_t width, size_t height)
{
	pgm_t_image *pgm = malloc(sizeof(pgm_t_image));
	pgm->pixels = malloc(sizeof(pgm_t_pixel) * width * height);
	pgm->width = width;
	pgm->height = height;
	return pgm;
}

void pgm_free(pgm_t_image *pgm)
{
	free(pgm->pixels);
	free(pgm);
}