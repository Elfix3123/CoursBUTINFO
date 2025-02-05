# Exercice 1
## Dépendances fonctionnelles
TypeCpte -> Taux
## Anomalies possibles
1. Anomalie de suppression : perte du taux du Codevi
2. Anomalie de mise à jour : les autres comptes de mêmes types ne sont pas mis à jour
3. Anomalie d'insertion : le nouveau n-uplet a des valeurs `null`
# Exercice 2
## Extension de R

| Module | UE  | Groupe | Eleve | Prof | Bureau |
| :----: | :-: | :----: | :---: | :--: | :----: |
|   AP   |  1  |   A    |  E1   |  P1  |  100   |
|   AP   |  1  |  *B*   |  E2   |  P1  |  100   |
|  OMGL  |  1  |   B    |  E3   |  P2  |  100   |
|  OMGL  |  1  |   B    |  E5   |  P2  |  100   |
|  OMGL  |  1  |   A    |  E1   |  P4  |  200   |
|  MAT   |  2  |   A    |  E1   |  P1  |  100   |
| *MAT*  |  2  |   B    |  E3   |  P3  |  200   |
|  MAT   |  2  |   A    |  E4   |  P1  |  100   |
## Étude des dépendances
a. Puisque la donnée prof suffit à définir de manière certaine son bureau à travers la dépendance fonctionnelle (Prof -> Bureau), un prof ne peut avoir qu'un bureau.
b. La dépendance Bureau -> Prof n'existe pas ; un bureau peut donc être occupé par plusieurs profs.
c. La dépendance Élève -> Prof n'existe pas ; un élève peut donc avoir plusieurs profs.
# Exercice 3
1. On pose les dépendances fonctionnelles suivantes : 1. Module -> UE, 2. Élève -> Groupe, 3. (Module, Groupe) -> Prof, 4. Prof -> Bureau. Avec (Module, Élève), on trouve UE à partir de Module avec 1, Groupe à partir de Élève avec 2, Prof à partir de Module et Groupe avec 3, et Bureau à partir de Prof avec 4.
2. R1 et R2 sont des projections de R. Cependant, la jointure de ces deux relations n'est pas possible ; R1 et R2 ne réalisent pas une décomposition binaire de R, et il y a perte d'information (le Prof de chaque (Module, Groupe)) et de DF ((Module, Groupe) -> Prof).
3. En tant que projection de R, et sachant que la jointure de R3 et R4 sur Prof produit R, R3 et R4 réalisent une décomposition binaire de R, et il n'y a pas de perte d'information ou de DF. Sachant que Module -> UE, que Élève -> Groupe et que (Module, Groupe) -> Prof, (Module, Eleve) est la clef de R3. Sachant que Prof -> Bureau, Prof est la clef de R4.
4. La DF (Module, Élève) -> Prof permettrait de répondre non à cette question.