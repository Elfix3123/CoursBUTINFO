  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	Inst1	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on reserve et on initialise avec la directive DC 
* on reserve sans initialiser avec la directive DS
		ORG	$A00
a		DC.W 5
b	    DC.W 4
c       DC.B 'S'


* debut des instructions du programme

Inst1	ORG	$AC0

*  a vous d'ecrire la suite en assembleur...

tq      CMPI.W  #2,a        ;a ? 2
		BLS		fin         ;a <= 2 sur entiers naturels : aller à fin
et      CMPI.W	#3,b        ;b ? 3
		BLS     faire       ;b <= 3 sur entiers naturels : aller à faire
ou      CMPI.B	#'S',c      ;c ? 'S'
		BNE     fin         ;c != 'S' : aller à fin
faire   MOVE.B	#'N',c
		SUBI.W	#1,b
		SUBI.W	#1,a
		BRA		tq
fin

* fin du programme principal
		BREAK	

* fin du contenu a assembler
		END



