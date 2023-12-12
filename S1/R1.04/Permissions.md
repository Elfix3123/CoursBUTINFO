# Présentation
Une entrée a plusieurs attributs : son nom, sa date de création, son type... C'est ce qu'on appelle ses métadonnées. Parmi ces métadonnées se trouvent son propriétaire, UID, son groupe, GID, et les permissions qui lui sont associées. Ces permissions s'appliquent a 3 catégories d'utilisateur :
- L'**utilisateur**, appelé `u`, qui créé le fichier.
- Le **groupe**, appelé `g`, auquel appartient cet utilisateur
- Les **autres**, appelés `o`.

En outre, elles peuvent porter sur 3 actions différentes :
- La **lecture**, appelée `r`, le fait de pouvoir lire le fichier ou voir le contenu du répertoire.
- L'**écriture**, appelée `w`, le fait de pouvoir modifier le contenu du fichier ou du répertoire.
- L'**exécution**, appelée `x`, le fait de pouvoir exécuter le fichier ou traverser le répertoire, c'est-à-dire de modifier le contenu des entrées qu'il contient. 
# Changer les permissions
Le logiciel `chmod [-R] [QUI] +|-PERM ENTREE`, *change mod*, permet de changer les permissions. L'option -R permet de répercuter le changement sur toutes les entrées contenues par un répertoire. QUI est l'utilisateur à qui s'applique le changement de permission, fabriquée avec les caractères u, g, o ou aucun caractère. PERM est les permissions qu'on souhaite modifier, fabriquée avec les caractères r, w et x.