# Qu'est-ce que la métaphore du bureau ?
C'est la représentation d'un bureau de manière informatique, avec des dossiers contenant des fichiers. Elle implique de la manipulation directe, et utilise le WIMP (Window, Icon, Menu Pointer).
# Anatomie d'une interface graphique
Une interface graphique peut être décomposée en plusieurs éléments :
- Les **label**, zones de textes impossibles à modifier par l'utilisateur.
- Les **textfield**, zones de texte éditables par l'utilisateur.
- Les **boutons**, qui peuvent être interagis avec l'utilisateur. Ils ont plusieurs formes (checkbox, radiobutton, listes, tables) et états.
- Les **context menus**, qui apparaissent en fonction des actions de l'utilisateur et sont contextuels.
- Les **panels** ou conteneurs, rassemblements logiques et spacial de composants. Le conteneur global est souvent la fenêtre, avec une toolbar.
# JavaFX
En JavaFX, il existe 4 classes de base :
- La classe **application**, la classe principale de l'application. Elle gère les composants dans l'ensemble de leur comportements et pendant toute la durée de vie de l'application.
- La classe **stage**, qui représente la fenêtre principale de l'application.
- La classe **scene**, qui représente l'interface qu'il faut associer à la fenêtre.
- La classe **node**, qui représente les éléments qui peuvent être affichés. Il y a 3 types de node : les formes primitives, les containers et les composants.
Ces éléments sont représentés dans un graphe de scène.
Une fois la scène prête, il est nécessaire de la rendre active, c'est-à-dire de faire en sorte que les événements aient un effet. Un événement a une source, une cible et un type.
