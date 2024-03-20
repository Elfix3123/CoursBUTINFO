Dans quelle mesure la non décidabilité du problème du point d'arrêt influence le fonctionnement des algorithmes de ramasse-miettes ?

Type de discours : argumentatif

Plan :
1ere partie : non décidabilité du problème de l'arrêt
2eme partie : influence sur les ramasse-miettes

Script :

Célian - Rolalala… j'arrive pas à lancer Fortnite… mon PC me dit que j'ai pas assez de mémoire alors que normalement j'en ai assez, on dirait que ma mémoire est toujours occupée. Comment je fait pour faire mes Top 1 moi maintenant ? Mais dit moi Nolan, pourquoi est-ce que ma mémoire n'arrive pas à se nettoyer au fur et à mesure ?

Nolan - Et bien c'est très simple ! Tout ça c'est de ta faute ! Dans ton ordinateur, il y a un programme qui tourne en continu et qui s'appelle le ramasse-miettes. *montre la maquette* Quand les programmes de ton PC s’exécutent, ils utilisent un certain espace dans la mémoire pour stocker les variables, les executions : quand il n'y a plus d’espace, plus rien ne fonctionne ! C'est pour ça que quand une zone n'est plus utile, par exemple quand le programme qui l'utilise se termine, le ramasse-miettes s'occupe de la vider, permettant ainsi à un autre programme de l'utiliser. Si tu n'as pas assez de mémoire pour lancer ton jeu, c'est que d'autres programmes sont ouverts en arrière plan : tu devrais donc les fermer.

Célian - D'accord, je comprend… mais je n'ai aucun programme ouvert en arrière plan et Fortnite ne veut toujours pas se lancer !

Nolan - Alors là je sèche… 

Felix - C'est également possible que le ramasse-miettes fasse mal son travail, et pour vous expliquer ça je vais devoir vous parler du problème de l'arrêt. Pour qu'un ramasse-miettes soit optimal, il doit pouvoir savoir si un programme va un jour s’arrêter de lui-même ou non. Imaginons qu'une telle chose soit possible : voici le programme halt, qui prend en entrée un autre programme ainsi que son entrée et donne en sortie si le programme en entrée s'arrête ou non. Par exemple, avec ce programme et cette entrée, halt donne oui, et avec cette autre entrée, halt donne non. Voici un autre programme prog :
```
prog(x) {
	Si halt(prog, x) {
		boucle infinie
	}
	sinon {
		fin
	}
}
```
Ce programme boucle à l'infini si halt(prog, x) est vrai, c'est-à-dire si prog s’arrête avec l'entrée x. De plus, il s’arrête si halt(prog, x) est faux, c'est-à-dire si prog boucle à l'infini avec l'entrée x. Ainsi, si prog boucle à l'infini, prog s’arrête et si prog s’arrête, alors il boucle à l'infini : on constate un paradoxe, qui met en relief le fait que halt n'existe pas.

Célian - J'ai compris ! Puis qu'on ne peut pas savoir à coup sûr si un programme s’arrête, alors le ramasse-miettes passe sûrement à coté de zones qu'il pourrait nettoyer ! Il me reste plus qu'à redémarrer mon PC…