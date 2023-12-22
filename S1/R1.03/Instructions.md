# Qu'est-ce qu'une instruction ?
Une instruction est une indication que l'on fournit au processeur, qui lui demande de réaliser une opération. Celle-ci doit contenir l'opération à réaliser, des opérandes, la longueur de l'instruction, la zone de stockage du résultat (une des deux opérandes dans le cas du 68k)… On peut diviser les instruction en catégories : mouvement de données, opérations arithmétique, opérations logiques, branchements… 
Mise à jour du pc : +2 octets pour le mot d'instruction, +2 pour chaque mot d'extension, +valeur si branchement
# Branchements
Lorsqu'on programme en assembleur, on joue le rôle du compilateur. Ainsi, il devient nécessaire de rajouter des branchements pour chaque condition, pour chaque itération…
Pour faire la traduction de la version algorithmique vers l'assembleur, on note chaque rupture séquence et on la traduit avec le branchement adapté.
Les instructions de branchement conditionnel ont des conditions sur N, Z, V et C. Pour les mettre à jour, il peut être utile d'utiliser CMP, qui met à jour les indicateurs en fonction de (destination-source).