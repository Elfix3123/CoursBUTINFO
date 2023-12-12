# Variables
Il existe 2 types de variables :
- Les **variables d'environnement**, communes à tus les processus.
- Les **variables locales**, propres à un processus et transférées de parent en enfant.

On peut les consulter avec la commande `env`. Pour les affectations, on utilise le symbole `=` et on utilise le nom de la variable précédé du symbole `$`. En cas d'erreur, aucun message n'est affiché.
La variable PATH est particulière : elle contient une liste de répertoires où le shell peut chercher des programmes ou des scripts.
# Passage de variables au script
Afin de passer des paramètres au script depuis le shell, on utilise les variables `$1`, `$2`, `$3`... jusqu'à `$9`.