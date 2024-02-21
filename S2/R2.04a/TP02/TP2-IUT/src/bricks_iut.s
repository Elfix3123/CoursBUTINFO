| ====================================================================
| === Constantes et Variables globales
| ====================================================================
.section .data

| === Variables ===	| en mémoire à partir de 0x00FF0500
		.org 0x0500 	  

nb_bricks: ds.w  1	| nombre elements du tableau
id_bricks: ds.w  100  | tableau de couleurs des briques (id des sprites)

lettre_I: dc.w 9, 10, 11, 19, 28, 36, 37, 38, -1
lettre_U: dc.w 12, 14, 21, 23, 30, 32, 39, 40, 41, -1
lettre_T: dc.w 15, 16, 17, 25, 34, 43, -1
lettres:  dc.l lettre_I, lettre_U, lettre_T

| ====================================================================
| === Instructions du programme
| ====================================================================
.section .text

.include "inc/prologue.s" | <=== Ne pas supprimer

	move.l 0x00AABBCC,%d7 | <=== point arret
| === DEBUT
										| %d0 : compteur de brique
										| %d1 : 2*indice pour pouvoir acceder aux briques 
										| %d2 : limite des briques
										| %d3 : 
										| %d4 : 
										| %d5 : brique temporaire
										| %d6 : indice temporaire, i
										| %d7 : 
										| %a0 : adresse de id_bricks
										| %a1 : adresse de lettres
										|
			MOVE.b #0, %d0				| %d0 := 0
			MOVE.w nb_bricks, %d2		| %d2 := nb_bricks
			ADD.w nb_bricks, %d2		| %d2 := %d2 + nb_bricks = 2*nb_bricks
			LEA id_bricks, %a0			| %a0 := adresse de id_bricks 
			LEA lettres, %a1			| %a1 := adresse de lettres
tantque1:	CMP.w %d2, %d0				| %d0 ? %d2
			BCC fintantque1				| %d0 >= %d2
faire1:		MOVE.b %d0, %d1
			ADD.b %d0, %d1
			MOVE.b #0, %d6
tantqueI:	MOVE.w (%a1), %d5
move.l 0x00AABBCC,%d5
			CMP #-1, %d5				| %d5 ? -1
			BEQ fintantqueI				| %d5 ? -1 -> fintantqueI
			CMP %d5, %d0				| %d0 ? %d5
			BEQ fintantqueI				| %d0 = %d5 -> fintantqueI
faireI:		ADDI.b #1, %d6
fintantqueI:
siI:		CMP %d5, %d0				| %d0 ? %d5 
			BNE finsiI					| %d0 != %d5 -> finsiI
alorsI:		MOVE.b %d6, %d1
			ADD.b %d6, %d1				| %d1 = 2 * %d6
			MOVE.w #1, (%a0, %d1)		| id_bricks[%d1/2 = %d0]
			MOVE.w #2, 106(%a0)
			ADDI.b #1, %d6
finsiI:
			ADDI.b #1, %d0				| %d0 := %d0 + 1
			BRA tantque1
fintantque1:


| === FIN
.include "inc/epilogue.s" | <=== Ne pas supprimer
