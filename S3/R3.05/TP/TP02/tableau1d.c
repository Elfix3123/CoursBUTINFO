#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <errno.h>

#define MILLIARD 1000000000.0

//-----------------------------------------------------------------------------
// renvoie le nombre d'entiers contenus dans une ligne
// du plus grand niveau de cache ne contenant pas entièrement une taille donnée.
static unsigned long nb_entiers_dans_ligne_cache_inf(long taille_octets)
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

//-----------------------------------------------------------------------------
int main(int argc, char *argv[])
{
  // vérification de la présence des paramètres sur la ligne de commande
  if (argc-1 != 2)
  {
     printf("Usage : %s taille_tableau_en_octets nb_repetitions\n", argv[0]);
     exit(1);
  }

  // récupération des paramètres de la ligne de commande
  unsigned long taille_octets=(unsigned long)(atol(argv[1]));
  unsigned long nb_repetitions=(unsigned long)(atol(argv[2]));

  // nombre d'entiers contenus dans le tableau
  unsigned long N=taille_octets/sizeof(int);

  // pas (step) du parcours des entrées du tableau
  unsigned long pas=nb_entiers_dans_ligne_cache_inf((long)(taille_octets));

  // allocation du tableau
  int* tableau=malloc(taille_octets);
  if (tableau==0)
  {
    perror("échec malloc");
    exit(EXIT_FAILURE);
  }

  // remplissage du tableau
  for (unsigned long i=0; i<N; i++)
    tableau[i] = (int)i;

  struct timespec rt1,rt2,ct1,ct2;
  clock_gettime(CLOCK_REALTIME,&rt1);
  clock_gettime(CLOCK_PROCESS_CPUTIME_ID,&ct1);

  int somme=0;			          // peu importe si on a un débordement
  unsigned long i=0;
  // relectures du tableau
  for (unsigned long r=0; r<nb_repetitions; r++)
    // parcours du tableau
    for (i=0; i<N; i+=pas)
      somme += tableau[i];

  printf("somme : %d\n",somme);		  // affichage indispensable

  clock_gettime(CLOCK_PROCESS_CPUTIME_ID,&ct2);
  clock_gettime(CLOCK_REALTIME,&rt2);
  double temps_cpu_ecoule = (double)(ct2.tv_sec-ct1.tv_sec) + (double)(ct2.tv_nsec-ct1.tv_nsec)/MILLIARD;
  printf("durée cpu    des accès au tableau : %lf secondes\n", temps_cpu_ecoule);
  double temps_reel_ecoule= (double)(rt2.tv_sec-rt1.tv_sec) + (double)(rt2.tv_nsec-rt1.tv_nsec)/MILLIARD;
  printf("durée réelle des accès au tableau : %lf secondes\n", temps_reel_ecoule);

  printf("nb d'accès au tableau par seconde : %e \n", (double)(i/pas*nb_repetitions)/temps_reel_ecoule);

  free(tableau);

  struct rusage usage;
  if (getrusage(RUSAGE_SELF,&usage))
  { perror("Erreur getrusage"); exit(errno);}
  printf("nombre de défauts de page mineurs : %lu \n", usage.ru_minflt);
  printf("nombre de défauts de page majeurs : %lu \n", usage.ru_majflt);

  return 0;
}
//-----------------------------------------------------------------------------
