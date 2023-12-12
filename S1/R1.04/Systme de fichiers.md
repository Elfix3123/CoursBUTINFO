# Contenu d'un système de fichier (SF)
Dans tous les systèmes, on retrouve des fichier - suite d'octets contenants selon un encodage des données - ainsi que des répertoires - contenant des fichiers et/ou des répertoires organisés de manière hiérarchique, sous forme d'arbres.
Dans les systèmes Unix, on retrouve également des liens symboliques.
L'arborescence des fichiers des systèmes Unix est standardisée.
# Vocabulaire, notations
- **Entrée** : tout fichier ou répertoire
- **Répertoire racine** : répertoire qui contient tous les autres, noté `/`
- **Répertoire parent d'une entrée** : c'est le répertoire auquel cette entrée appartient, noté `..`
- **Répertoire personnel, home directory** : c'est le répertoire personnel de l'utilisateur, noté `~`
- **Répertoire courant d'un shell** : c'est le répertoire de travail du shell, noté `.`
# Designer le chemin d'accès d'une entrée
Pour accéder à une entrée, il est nécessaire de l'identifier sans ambiguïté, ce qui est fait en énumérant les répertoires nécessaires pour y accéder depuis la racine si le chemin est absolu, depuis le répertoire courant si il est relatif.