#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MILLIARD 1000000000.0

int main(int argc, char *argv[])
{
  // vérification de la présence des paramètres sur la ligne de commande
  if (argc-1 != 2)
  {
     printf("Usage : %s taille_tableau nb_repetitions\n", argv[0]);
     exit(1);
  }

  // récupération des paramètres de la ligne de commande
  unsigned int N=(unsigned int)atoi(argv[1]);
  unsigned int nb_repetitions=(unsigned int)atoi(argv[2]);

  printf("Allocation du tableau %d x %d...\n",N,N);
  // allocation d'un tableau de taille N*N
  int* tableau=malloc(N*N*sizeof(int));		  // ne marche pas en cas de dépassement
  if (tableau==0)
  {
    perror("échec malloc");
    exit(EXIT_FAILURE);
  }

  printf("Remplissage du tableau %d x %d (écritures)...\n",N,N);
  // remplissage du tableau
  for (unsigned int c=0; c<N; c++)          // pour chaque colonne
    for (unsigned int l=0; l<N; l++)			  // pour chaque ligne
       tableau[l*N+c] = (int)(l+c);			  // rand() est trop long

  printf("Lectures du tableau %d x %d...\n",N,N);
  struct timespec rt1,rt2,ct1,ct2;
  clock_gettime(CLOCK_REALTIME,&rt1);
  clock_gettime(CLOCK_PROCESS_CPUTIME_ID,&ct1);

  int somme=0;					  // peu importe si on a un débordement
  // relectures du tableau
  for (unsigned int i=0; i<nb_repetitions; i++)
    for (unsigned int c=0; c<N; c++)			  // pour chaque colonne
      for (unsigned int l=0; l<N; l++)			  // pour chaque ligne
        somme += tableau[l*N+c];

  clock_gettime(CLOCK_REALTIME,&rt2);
  clock_gettime(CLOCK_PROCESS_CPUTIME_ID,&ct2);

  printf("somme : %d\n\n", somme);		  // affichage indispensable
  double temps_cpu_ecoule = (double)(ct2.tv_sec-ct1.tv_sec) + (double)(ct2.tv_nsec-ct1.tv_nsec)/MILLIARD;
  printf("durée cpu    des accès au tableau : %lf secondes\n", temps_cpu_ecoule);
  double temps_horloge_ecoule= (double)(rt2.tv_sec-rt1.tv_sec) + (double)(rt2.tv_nsec-rt1.tv_nsec)/MILLIARD;
  printf("durée réelle des accès au tableau : %lf secondes\n", temps_horloge_ecoule);

  printf("nb acces au tableau par seconde    : %e \n", (double)(N*N*nb_repetitions)/temps_horloge_ecoule);

  free(tableau);

  return 0;
}
