#ifndef ALLOCATION_H_
#define ALLOCATION_H_

#include <stdlib.h>
#include <stdio.h>
#include <pgmio.h>

extern pgm_t_image *pgm_malloc(size_t width, size_t height);
void pgm_free(pgm_t_image *pgm);

#endif /* ALLOCATION_H_ */