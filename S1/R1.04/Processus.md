# Les processus
Sur une machine, il peut être nécessaire d'exécuter plusieurs logiciels ou d'avoir plusieurs utilisateurs simultanément (OS multi-tâches et multi-utilisateurs).
L'exécution d'un logiciel donne naissance à un processus, qui est donc un programmes en train de s'exécuter. C'est une entité dont le noyau contrôle l'état, de la vie à la mort. Dans un système à temps partagé, le processeur est partagé entre plusieurs processus concurrents. Dans un système multi-tâches préemptif, l'ordonnanceur peut reprendre la main sur le matériel d'un processus afin de le donner à un autre.
Les processus sont crées par duplication de processus déjà existants : ils sont donc organisés en arborescence.
# Attributs des processus
- **PID** : l'identifiant d'un processus
- **PPID** : l'identifiant du processus parent d'un processus
- **UID** : l'utilisateur au nom duquel s'exécute le processus
- **GID** : groupe auquel le processus est rattaché
- La priorité du processus, de -20 - très important - à 19 - peu important.
# Ressources d'un processus
- Un **environnement** hérité du processus parent - répertoire courant, ligne de commande, variables d'environnements…
- De la **RAM** entièrement séparée et indépendante, l'espace d'adressage du processus
- Des **fichiers** ouverts, au moins 3 par défauts - l'entrée standard, la sortie standard et l'erreur standard - mais plus si nécessaire.
# Quelques commandes
- **ps** et **pstree** servent à afficher les processus en cours.
- **top** sert à ###########???
- **kill** sert à tuer un processus avec son PID.
- **killall** sert à tuer un processus avec son nom.
