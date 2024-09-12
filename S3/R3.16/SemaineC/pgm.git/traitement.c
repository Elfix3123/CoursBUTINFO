#include "traitement.h"

#define SEUIL1_PIXEL(valeur, seuil) (valeur > seuil ? PGM_PIXEL_MAX : 0)
#define SEUIL2_PIXEL(valeur, seuil) (valeur = valeur > seuil ? PGM_PIXEL_MAX : 0)
#if DEBUG
	#define AFFICHER_FONCTION printf("%s\n", __func__)
#else
	#define AFFICHER_FONCTION 
#endif

void pgm_solid(pgm_t_image *pgm, pgm_t_pixel color)
{
	AFFICHER_FONCTION;
	int i = 0, imax = pgm->width * pgm->height;
	while(i < imax)
	{	
		pgm->pixels[i] = color;
		i++;
	}
}

void pgm_negative(pgm_t_image *pgm)
{
	AFFICHER_FONCTION;
	int i = 0, imax = pgm->width * pgm->height;
	while(i < imax)
	{
		pgm->pixels[i] = PGM_PIXEL_MAX - pgm->pixels[i];
		i++;
	}
}

void pgm_threshold(pgm_t_image *pgm, pgm_t_pixel threshold)
{
	AFFICHER_FONCTION;
	int i = 0, imax = pgm->width * pgm->height;
	while(i < imax)
	{
		SEUIL2_PIXEL(pgm->pixels[i], threshold);
		i++;
	}
}

void pgm_gradient(pgm_t_image *pgm)
{
	AFFICHER_FONCTION;
	size_t x = 0, y = 0;
	while(x < pgm->width)
	{
	y = 0;
		while(y < pgm->height)
		{
			pgm->pixels[y * pgm->width + x] = x * PGM_PIXEL_MAX / pgm->width;
			y++;
		}
		x++;
	}
}
