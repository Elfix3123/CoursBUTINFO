# Capacité fonctionnelle
Capacité du système à répondre aux besoins explicites ou implicites des utilisateurs

| Critère                  | Définition                                                                       | Pertinence | Mesures organisationnelles                                                                                                         | Evaluation du respect                |
| :----------------------- | :------------------------------------------------------------------------------- | :--------- | :--------------------------------------------------------------------------------------------------------------------------------- | :----------------------------------- |
| Aptitude                 | Capacité du système à répondre aux besoins principaux de l’utilisateur           |            | **Recueil** des besoins **Priorisation** et **hiérarchisation** des besoins Modélisation des besoins **utilisateur** et **métier** | Tests unitaires en **boîte noire**   |
| Exactitude               | Capacité du système à fonctionner sans comportements imprévus                    |            |                                                                                                                                    | Tests unitaires en **boîte blanche** |
| Interoperabilité         | Capacité du système de communiquer avec le système d’information de l’entreprise |            | Respect de **normes** sur le format des données Etude des **nécessités de communication**                                          |                                      |
| Securité                 | Capacité du système à empêcher son accès à des agents non autorisés              |            | Gestion des **permissions** Mesures **préventives**                                                                                | Tests d’intrusion<br>Tests de stress |
| Conformité fonctionnelle | Capacité du logiciel à respecter des normes définies                             |            | Etude des **normes en place** Mise en place de **conventions**                                                                     | Audits                               |
# Fiabilité
Capacité du système à rendre des résultats corrects quelles que soient les conditions d'exploitation

| Critère                  | Définition                                                                | Pertinence                                                                      | Mesures organisationnelles | Evaluation du respect |
| :----------------------- | :------------------------------------------------------------------------ | :------------------------------------------------------------------------------ | :------------------------- | :-------------------- |
| Maturité                 | Capacité du système à ne pas dysfonctionner                               | Si le système a vocation à être pérenne                                         | Assurer l’**exactitude**   | Monitoring            |
| Tolérance aux fautes     | Capacité du système à continuer à maintenir un niveau de service          | Si le système doit avoir une haute disponibilité                                |                            | Tests de stress       |
| Capacité de récupération | Capacité du système à rétablir un niveau de service en cas de défaillance | Si le risque associé à la continuité est supérieur au dommage de l'interruption | Cloisonnement de réseaux   | Tests de stress       |
# Facilité d'usage
Effort nécessaire pour manipuler et apprendre à manipuler le système

| Critère                   | Définition                                                                         | Pertinence | Mesures organisationnelles                                    | Evaluation du respect |
| :------------------------ | :--------------------------------------------------------------------------------- | :--------- | :------------------------------------------------------------ | :-------------------- |
| Exploitabilité            | Capacité du système à supporter l'amélioration de la productivité des utilisateurs |            | Guidage<br>Homogeneité<br>Cohérence                           | Tests utilisateurs    |
| Facilité d'aprentissage   | Capacité du service à permettre à ses utilisateurs d'atteindre des objectifs       |            | Documentation<br>Sémiologie et sémiotique<br>Tutoriels et FAQ | Tests utilisateurs    |
| Facilité de compréhension | Capacité du système à faire comprendre son fonctionnement à ses utilisateurs       |            |                                                               | Tests utilisateurs    |
# Efficacité

| Critère                             | Définition | Pertinence | Mesures organisationnelles | Evaluation du respect              |
| :---------------------------------- | :--------- | :--------- | :------------------------- | :--------------------------------- |
| Efficacité des ressources employées |            |            |                            | Monitoring<br>Optimisation du code |
| Efficacité des temps de réalisation |            |            |                            | Monitoring<br>Optimisation du code |
# Maintenabilité

| Critère       | Définition                                                                           | Pertinence | Mesures organisationnelles                | Evaluation du respect   |
| :------------ | :----------------------------------------------------------------------------------- | :--------- | :---------------------------------------- | :---------------------- |
| Analysibilité | Capacité du système à faire comprendre son fonctionnement                            |            | Mise en place de conventions              | Revue de code           |
| Modifiabilité | Capacité du système à permettre des modifications                                    |            | Maintenance **curative** ou **évolutive** | Audit                   |
| Testabilité   | Capacité du système à être testé après modification                                  |            | Plans de test formalisés                  |                         |
| Stabilité     | Capacité du système à maintenir un niveau de performance constant après modification |            |                                           | Tests de non-régression |

# Portabilité
| Critère                              | Définition                                                                 | Pertinence | Mesures organisationnelles               | Evaluation du respect |
| :----------------------------------- | :------------------------------------------------------------------------- | :--------- | :--------------------------------------- | :-------------------- |
| Facilité d'installation              | Capacité du système à être installé dans un environnement                  |            |                                          |                       |
| Facilité de migration                | Capacité du système à être transféré dans un nouvel environnement logiciel |            | Choix techniques supportant la migration |                       |
| Adaptabilité                         | Capacité du système à fonctionner dans différents environnements matériels |            |                                          |                       |
| Conformité aux règles de portabilité |                                                                            |            |                                          |                       |
