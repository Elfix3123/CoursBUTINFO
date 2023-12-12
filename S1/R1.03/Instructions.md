# Qu'est-ce qu'une instruction ?
Une instruction est une indication que l'on fournit au processeur, qui lui demande de réaliser une opération. Celle-ci doit contenir l'opération à réaliser, des opérandes, la longueur de l'instruction, la zone de stockage du résultat (une des deux opérandes dans le cas du 68k)… On peut diviser les instruction en catégories : mouvement de données, opérations arithmétique, opérations logiques, branchements… 
0001 110 000 111 100
MOVE.B D4 1C
D4.B := $1C