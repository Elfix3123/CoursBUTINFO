Dans quelle mesure la non décidabilité du problème du point d'arrêt influence le fonctionnement des algorithmes de ramasse-miettes ?

Type de discours : argumentatif

Plan :
1ere partie : non décidabilité du problème de l'arrêt
2eme partie : influence sur les ramasse-miettes

Script :

Célian - Rolalala… j'arrive pas à lancer Fortnite… mon PC me dit que j'ai pas assez de mémoire alors que normalement j'en ai assez, on dirait que ma mémoire est toujours occupée. Comment je fait pour faire mes Top 1 moi maintenant ? Mais dit moi Nolan, pourquoi est-ce que ma mémoire n'arrive pas à se nettoyer au fur et à mesure ?

Nolan - Et bien tout ça c'est de ta faute ! La question que tu pose c'est : "Dans quelle mesure les algorithme influencent les ramasse-miettes ?", et c'est très simple : une fois que tu saura comment les ramasse-miettes fonctionnent tu pourras comprendre le role des algorithmes dans leur conception ! Voici un programme de ton ordinateur. Il est ici représenté par une boite noire car ce qu'il se passe à l'interieur ne nous interesse pas. Ce qui nous interesse, c'est l'éspace qu'il utilise. Lors de son execution, il va avoir besoin de stocker des variables, des piles d'execution… et tout ca, ca prend de la place dans la mémoire de ton ordinateur. Lors que tu n'as plus de mémoire disponnible, tout plante, et c'est pour cela qu'il est important de faire en sorte de libérer la mémoire disponnible au fur et à mesure, et c'est le rôle du ramasse-miettes ! Lors que ton programme a fini de s'éxecuter, il rend l'éspace qu'il utilise à la machine, mais ne le néttoie pas. C'est alors au rôle du ramasse miettes de s'en occuper ! Cependant, plus tu as de programmes ouverts, plus l'éspace est utilisé; Si tu n'as pas assez de mémoire pour lancer ton jeu, c'est que d'autres programmes sont ouverts en arrière plan : tu devrais donc les fermer.

Célian - D'accord, je comprend… mais je n'ai aucun programme ouvert en arrière plan et Fortnite ne veut toujours pas se lancer !

Nolan - Alors la c'est trop compliqué pour moi… la petite voix ?

Felix - Oui ?

Nolan - Visiblement tu à un chat dans la gorge, fin bon tu peux lui expliquer ?

Felix - Bien sur ! Il existe un problème principal qui limite l'efficacité des ramasse-miettes : le problème de l'arrêt. Pour qu'un ramasse-miettes soit optimal, il doit pouvoir savoir si un programme va un jour s’arrêter de lui-même ou non, pour nettoyer sa zone mémoire : si on sait qu'un programme ne s'arrête jamais, il est inutile de revérifier si on peut nettoyer sa zone mémoire puis qu'on ne pourra jamais la nettoyer. En revanche, si on sait si et quand un programme va se terminer, on peut prévoir de nétoyer sa zone à ce moment la.
Imaginons qu'une telle chose soit possible : voici le programme halt, qui prend en entrée un autre programme ainsi que son entrée et donne en sortie si le programme en entrée s'arrête ou non. Par exemple, avec ce programme et cette entrée, halt donne oui, et avec cette autre entrée, halt donne non. Voici un autre programme prog :
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
Ce programme boucle à l'infini si halt(prog, x) est vrai, c'est-à-dire si prog s’arrête avec l'entrée x. De plus, il s’arrête si halt(prog, x) est faux, c'est-à-dire si prog boucle à l'infini avec l'entrée x. Ainsi, si prog boucle à l'infini, prog s’arrête et si prog s’arrête, alors il boucle à l'infini : on constate un paradoxe, qui montre que halt n'existe pas.

Célian - J'ai compris ! Puis qu'on ne peut pas savoir à coup sûr si un programme s’arrête, alors le ramasse-miettes passe sûrement à coté de zones qu'il pourrait nettoyer ! Il me reste plus qu'à redémarrer mon PC…