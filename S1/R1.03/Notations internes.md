Dans un système donné, chaque nombre a une représentation unique.
# Généralités
Le **registre d'état** (status register) est un ensemble de bits d'un processeurs qui contient des drapeaux comme :
- Le bit **carry**, noté C, qui indique qu'une addition s'est mal passé sur des nombres en base 2.
- Le bit **overflow**, noté V, qui indique qu'une addition s'est mal passé sur des nombres en complément à 2.
En assembleur, lors qu'on appelle l’additionneur, il effectue l'opération sur la longueur indiquée et met à jour tous les indicateurs.
# Base 2
Pour passer de la base 10 à la base 2, on peut utiliser la méthode des divisions successives par 2, qui consiste à diviser le nombre en base 10 par 2, le reste étant le bit de poids le plus faible.
## Opérations en base 2
Pour additionner deux valeurs en base 2, on addition bit à bit en prenant garde à garder les retenues. La soustraction se passe de manière similaire.
Lors que la valeur d'une opération dépasse la plage de valeurs autorisée, on parle de **dépassement**, et l’indication **carry** vaut 1.
# Codage des entiers signés
Il existe plusieurs méthodes pour coder les entiers signés :
- **Signe et valeur absolue** : le bit de poids le plus fort représente le signe du nombre représenté, et les autres bits sont les mêmes que pour un codage en base 2; si le nombre commence par un 0, alors il est positif, si il commence par un 1 il est négatif. Cependant, ce codage ne fonctionne pas avec les opérations arithmétiques de la base 2.
- **Codage en complément à 2** : les nombres positifs sont écrits en base 2 et les nombres en négatif sont écrit comme la soustraction de 0 par le codage en base 2 du nombre. Ce codage fonctionne avec les opérations arithmétiques de la base 2, et le carry n'est pas utile lors de ces opérations : on regarde un autre indicateur, l'**overflow** (noté V).
# Codage des réels
Sachant que les réels ont une précision infinie impossible a retranscrire en informatique, on préférera parler de partie entière et de partie fractionnaire. Il existe plusieurs méthodes pour coder les réels :
- **Virgule fixe** : on décide du nombre de bits entiers et de bits fractionnaires, ce qui permet de fixer la virgule à un emplacement qui ne change pas. La **précision du codage** représente la valeur maximale de l'erreur de troncature lorsqu'on représente un nombre en virgule fixe, et elle vaut la valeur du bit de poids faible.