# Organisation de la sécurité
| Pratique                                 | Opérationnalisation                                                                                                                        |
| :--------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------- |
| Répartition des rôles et responsabilités | Définition du périmètre du SGSI (acteurs)<br>Définition des tâches du SGSI<br>Outils organisationnels (RACI)                               |
| Séparation des tâches                    | Mise en place du principe du moindre privilègre                                                                                            |
| Relation avec les autorités              | Identification des autorités de contrôle<br>Identification des obligations<br>Identification des canaux de communication et préformatage   |
| Gestion de projet                        | Intégration de l’aspect de sécurité des données à la démarche de gestion de projet (gestion des contraintes, analyse des risques avec PIA) |
| Mobilité et télétravail                  | Définition de la mobilité et des accès distants dans la politique de l'entreprise                                                          |

# Gestion des actifs 

| Pratique                  | Opérationnalisation                                                                                           |
| :------------------------ | :------------------------------------------------------------------------------------------------------------ |
| Responsabilité            | Identification et inventorisation de l'ensemble des actifs dans le périmètre du SGSI<br>Suivi de l'inventaire |
| Manipulation des supports | Politique de gestion , d'élimination et de protection physique des supports                                   |

# Cryptographie
| Pratique                 | Définition                                                                                    | Opérationnalisation                                                                                                                                                                                            |
| :----------------------- | :-------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Politique de chiffrement | Existence de directives concernant les méthodes de chiffrement des données                    | Étude du niveau de protection nécessaire au regard des objectifs de sécurité (confidentialité, intégrité, non-répudiation, authentification) et des méthodes organisationnelles et techniques d'implémentation |
| Gestion des clefs        | Existence d'une politique sur la création, la vie et la protection des clefs cryptographiques | La politique doit prévoir la génération, le stockage, l'archivage, la récupération, la distribution, la fin d'utilisation et la destruction des clefs                                                          |
# Exploitation
| Pratique                                    | Définition                                                                   | Opérationnalisation                                                                              |
| :------------------------------------------ | :--------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------- |
| Documentation des procédures d'exploitation | Documentation à l'usage interne pour les administrateurs systèmes et réseaux |                                                                                                  |
| Séparation des environnements               |                                                                              | Mise en place de 4 environnements (développement, qualification/test, préproduction, production) |
| Protection contre les malware               |                                                                              | Identification des points d'entrée                                                               |
| Sauvegarde                                  |                                                                              | Définition de la périodicité des sauvegardes (RTO)                                               |
| Journalisation                              |                                                                              | Traçage humain et technique                                                                      |
# Communication
| Pratique                      | Définition | Opérationnalisation                                          |
| :---------------------------- | :--------- | :----------------------------------------------------------- |
| Cloisonnement des réseaux     |            | Choix entre un cloisonnement physique, logique ou applicatif |
| Engagement de confidentialité |            |                                                              |
# Gestion des incidents
| Pratique                                 | Définition | Opérationnalisation                                 |
| :--------------------------------------- | :--------- | :-------------------------------------------------- |
| Signalement des incidents et des failles |            | Système de ticketing<br>Détection des flux anormaux |
| Recueil des preuves                      |            | Journalisation                                      |
# Continuité d'activité

| Pratique           | Définition                                                     | Opérationnalisation                         |
| :----------------- | :------------------------------------------------------------- | :------------------------------------------ |
| Plan de continuité | Capacité à continuer à fournir des services malgré un incident | Pas si l'attaque est massive et dommageable |
| Plan de reprise    | Capacité à fournir de nouveau des services après un incident   |                                             |
