# Utilité et principe
Ils permettent de manipuler plusieurs entrées en une seule commande en ne les nommant pas explicitement. 
Ils utilisent les caractères spéciaux suivants :
- Le caractère `*` permet de remplacer une suite quelconque de caractères.
- Le caractère `?` permet de remplacer un caractère quelconque.
- Les caractères `[]` permettent de remplacer un caractère par une suite de caractères possibles.

On peut les combiner avec d'autres notations, en utiliser plusieurs différents…
**Les jokers sont un outil puissant, ils peuvent ainsi avoir des résultats catastrophiques**
# Mécanisme interne
- **globbing** : processus par lequel le shell effectue la substitution des jokers avec les expressions.
Le logiciel lancé par la commande de voit pas les jokers mais uniquement leur substitution.
