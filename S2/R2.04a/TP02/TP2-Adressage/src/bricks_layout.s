| ====================================================================
| === Constantes et Variables globales
| ====================================================================
.section .data

| === Variables ===   | en mémoire à partir de 0x00FF0000
       
| /!\ ATTENTION : ce sont des variables non initialisées
| Les valeurs seront affectées par le programme appelant
| NE PAS MODIFIER LES VARIABLES 
 
nb_bricks: ds.w  1    | nombre elements du tableau
id_bricks: ds.w  100  | tableau de couleurs des briques (id des sprites)


| ====================================================================
| === Instructions du programme
| ====================================================================
.section .text

.include "inc/prologue.s" | <=== Ne pas supprimer

	move.l 0x00AABBCC, %d7 | <=== point arret
| === DEBUT
.debut:
            MOVE.b #0, %d0            | %d0 := 0
            MOVE.w nb_bricks, %d1    | %d1 := nb_bricks
            ADD.w nb_bricks, %d1    | %d1 := %d1 + nb_bricks = 2*nb_bricks
            LEA id_bricks, %a0       | %a0 := adresse de id_bricks 
            MOVE.b #0, %d2          | %d2 := 0
tantque:    CMP.w %d1, %d0           | %d0 ? %d1
            BCC fintantque           | %d0 >= %d1
faire:      MOVE.w %d2, (%a0,%d0)     | id_bricks[%d0/2] := 3
            ADDI.b #1, %d2
            ADDI.b #2, %d0            | %d0 := %d0 + 2
si:         CMP.b  #4, %d2           | %d2 ? 4
            BNE finsi               | %d2 != 4
alors:      MOVE.b #0, %d2
finsi:
            BRA tantque
fintantque:
	
| === FIN
.include "inc/epilogue.s" | <=== Ne pas supprimer
