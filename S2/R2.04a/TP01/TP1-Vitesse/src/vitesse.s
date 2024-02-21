| ====================================================================
| === Constantes et Variables globales
| ====================================================================
.section .data

| === Constantes ===
.set XMIN,87        | coordonnees des murs
.set XMAX,228       |
.set YMIN,5         |
.set YMAX,220       |

| === Variables === | en mémoire à partir de 0x00FF0500
	.org 0x0500 

x:  dc.w 87         | coordonnee de la balle
y:  dc.w 5         |

vx: dc.w 2          | vecteur direction de la balle
vy: dc.w 2          |

| ====================================================================
| === Instructions du programme
| ====================================================================
.section .text

.include "inc/prologue.s" | <=== Ne pas supprimer

	| move.l 0x00AABBCC,%d7 | <=== point d'arret
| === DEBUT	
	
six:	move.w x, %d1		| 
		cmp.w #XMAX, %d1	| x ? #XMAX
		bhi alorsx			| x > #XMAX -> alorsx
oux:	cmp.w #XMIN, %d1	| x ? #XMIN
		bcc finx			| x >= #XMIN -> finx
alorsx:	neg.w vx			|
finx:	

siy:	move.w y, %d1		| 
		cmp.w #YMAX, %d1	| y ? #YMAX
		bhi alorsy			| y > #YMAX -> alorsy
ouy:	cmp.w #YMIN, %d1	| y ? #YMIN
		bcc finy			| y >= #YMIN -> finy
alorsy:	neg.w vy			|
finy:		

| === FIN
.include "inc/epilogue.s" | <=== Ne pas supprimer
	
