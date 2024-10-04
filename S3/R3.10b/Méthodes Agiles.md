# Grands principes
L'agile se base sur plusieurs principes forts; l'agile est :
- Incrémental, avec un développement par parties qui constitueront un tout cohérent
- Itératif, où on améliore une même maquette
- Pragmatique, avec peu de documentation
- Adaptatif, avec une forte susceptibilité au changement
- Centré utilisateur, en gardant en tête les besoins spécifiques des utilisateurs finaux
L'agile a également un encadrement temporel fort, avec des daily et weekly meeting et des sprint de 2 à 4 semaines, et est piloté par les tests, dans une démarche ressemblant au développement en V.
L'agile ne comprend pas de CDC; il comprend seulement un backlog, qui contient l'ensemble des user story. Son fonctionnement est tel qu'il existe un backlog de produit, et un backlog de sprint dans lequel on met des user story à mesure que de plus en plus sont validées. L'équipe projet, de 5 à 7 personnes, travaille sur le backlog de sprint jusqu'à la release, où les utilisateurs valident ou non le travail fait pendant une rétrospective. 
# SCRUM

# Outils agiles
Les modèles agiles reposent sur l'utilisation de pratiques agiles.
## Intégration continue
L'intégration continue est une pratique de développement qui consiste à mettre au plus tôt les modifications faites dans la branche principale du projet, idéalement plusieurs fois par jour; cette méthode permet d'assurer des tests fréquents des nouvelles parties du projet et une compatibilité constamment réfléchie et optimale des différents morceaux de codes. Le feedback est optimal puisque instantané, et la correction de bugs devient une activité également continue. Cependant, elle n'est pas très rapide puisque nécessitant une attention constante dans l'intégration. 
## TDD
Le test driven development est une pratique agile qui consiste à faire de la pratique de tests une activité continue, itérative et optimisée; il se décompose en trois parties :
- La phase rouge, càd le développement d'un test unitaire avant la fonction associée et qui échoue donc
- La phase verte, atteinte lors que le code minimal valide le test unitaire
- Le refactoring, phase pendant laquelle le code est structuré, homogénéisé et documenté tout en gardant les tests validés
Cette pratique permet de limiter les bugs puis qu'éliminés en continu et d'optimiser les morceaux de codes individuels (principe de non régression), mais nécessite beaucoup de temps dans son implémentation et son execution.
## Planning poker : 
Le planning poker/scrum poker est une méthode agile qui utilise des cartes physiques (d'où le nom poker) pour estimer le temps et les ressources nécessaires pour compléter chaque user story du backlog de sprint. On utilise un lot de cartes avec des durées différentes (suite de Fibonacci) afin de parier sur la durée d'une user story
## Kanban des tâches 
Le Kanban de tache correspond à une méthode de classification des tâches en fonction de si elles sont "rejetées", "à démarrer", "en cours", "à tester", et "finie". Les cartes Kanban comprennent l'user story, la tâche, la charge associée, la personne responsable de la tâche, les tests associés à la tâche, les métriques de réussite ainsi que d'autres informations propres au projet.
## Timeboxing
Le timeboxing consiste à enfermer chaque user story dans une boîte temporelle immuable; si elle n'est pas validée à la fin de la durée temporelle allouée, soit on dégrade l'user story, soit on remet l'user story au prochain sprint, en plus des autres. 
## User stories
Descriptions du besoin du produit de la perspective du client final, afin de la contextualiser. On appelle une macro user story une epic, qui est rédigée comme un besoin général portant sur l'ensemble du projet. L'user story contient elle-même des tâches, qui représentent chaque besoin technique de l'user story. Elle peut être développée par un membre de l'équipe en une itération.
## Réusinage de code
Principe de "module sur l'étagère"; dans une démarche bottom-up, on cherche à décomposer le projet en module individuels qu'on a déjà "sur l'étagère". Le réusinage en particulier consiste à restructurer le code existant sans en modifier sa fonctionnalité, afin d'en améliorer les caractéristiques fonctionnelles. On pourra par exemple remettre à plat la documentation ou changer le langage du code. Il faudra cependant faire attention à l'intérêt réel du réusinage afin de ne pas dépenser plus que l'on gagne.
## Pair programming
Le pair programming consiste à être deux développeurs sur un poste de travail : un driver, qui code, et un observer, qui supervise et pose des questions, propose des solutions, demande des précisions. Cette méthode est associée au pomodoro, avec à chaque cycle un échange entre driver er observer. Cette méthode permet réduire la dette technique en augmentant la qualité du code