# Qu'est-ce que la conception ?
La conception représente le fait de schématiser et de modéliser un but, souvent d'un point de vue graphique. Elle permet de prendre du recul sur son objectif ainsi que de s'accorder sur celui-ci en équipe. Elle s'oppose à la réalisation, qui correspond à la mise en oeuvre de la conception.
La conception est une étape nécessaire au développement d'un logiciel. Elle permet de présenter au client une version simplifiée et comprehensible du logiciel.
La conception comprend plusieurs étapes :
- **Comprendre** les besoins et le point de départ. Que veut le client ? Quel est le contexte du projet ? Quels acteurs sont impliqués ?
- **Choisir** ses outils. Quels languages de modélisation choisir ?
# Quelques définitions
Règle des trois A : abstraction, automatisation, analyse.
Abstraction : simplification d'éléments de conception afin de généraliser leurs comportements.
Automatisation : passage à l'aide d'algorithmes de la conception à la réalisation.
Analyse : le fait de réfléchir au modèle afin de vérifier sa conformité, sa validité.
Modèle : maquette, représentation simplifiée et standardisée d'un système qui permet de le comprendre partiellement. 
Processus métier : ensemble d'activités pour arriver à un résultat déterminé.
Logiciel support :
Méthode : ensemble d'activités pour arriver à un résultat.
Généralisation/spécialisation : lien qui relie un élément hérité et un élément héritant.
Factorisation : fait pour une classe mère de faire hériter à la classe fille ses attributs.
Enrichissement : fait pour une classe fille d'ajouter des attributs à sa classe mère.
Polymorphisme : capacité pour une instance de classe abstraite d'avoir des méthodes différentes en fonction de son enrichissement.
# Associations
Une agrégation est une composition moins forte. 
Une composition au contraire permet au parent de modifier ses élément enfants. Cela implique qu'un élément composé a un et un seul conteneur; les compositions sont nécessairement de cardinalité [0..1].

Dans un héritage, l'élément parent n'a aucun pouvoir sur ses éléments enfants. Par exemple, si l'élément parent est supprimé, les éléments enfants ne le sont pas.
# Contraintes
Les contraintes sont représentées par des lignes pointillées. Il en existe plusieurs :
- `{opposite}`
- `{subset}` ou `{inclus}`
- `{ID}` ou `{unique}`
- `{eclude}` ou `{XOR}`