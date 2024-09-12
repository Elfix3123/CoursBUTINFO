#ifndef TRAITEMENT_H_
#define TRAITEMENT_H_

#define DEBUG 1

#include <stdlib.h>
#include <stdio.h>
#include <pgmio.h>

void pgm_solid(pgm_t_image *pgm, pgm_t_pixel color);
void pgm_negative(pgm_t_image *pgm);
void pgm_threshold(pgm_t_image *pgm, pgm_t_pixel threshold);
void pgm_gradient(pgm_t_image *pgm);

#endif /* TRAITEMENT_H_ */