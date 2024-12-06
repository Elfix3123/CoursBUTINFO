#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <sys/time.h>
#include <time.h>
#include <unistd.h>

//-----------------------------------------------------------------------------
// renvoie le nombre d'entiers contenus dans une ligne
// du plus grand niveau de cache ne contenant pas entièrement une taille donnée.
__attribute__((used)) static unsigned long nb_entiers_dans_ligne_cache_inf(long taille_octets)
{
  long taille_ligne_cache=0;
  if (taille_octets <= sysconf(_SC_LEVEL2_CACHE_SIZE))
    taille_ligne_cache = sysconf(_SC_LEVEL1_DCACHE_LINESIZE);
  else if (taille_octets <= sysconf(_SC_LEVEL3_CACHE_SIZE))
    taille_ligne_cache = sysconf(_SC_LEVEL2_CACHE_LINESIZE);
  else
    taille_ligne_cache = sysconf(_SC_LEVEL3_CACHE_LINESIZE);
  return (unsigned long)(taille_ligne_cache)/sizeof(int);
}
//-----------------------------------------------------------------------------

int main(void)
{
  return 0;
}
