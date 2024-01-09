  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	Inst1	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on reserve et on initialise avec la directive DC 
* on reserve sans initialiser avec la directive DS
		ORG	$A00
a		DC.W 1
b	    DC.W 10
cas     DC.L 'init'

* debut des instructions du programme

Inst1		ORG	$AC0

*  a vous d'ecrire la suite en assembleur...

		MOVE.W a,d0
si      CMP.W b,d0		;a ? b
		BHI alors       ;a > b sur entiers naturels -> alors
ou		CMP.W #4,d0		;a ? 4
		BCC sinon		;a >= 4 sur entiers naturels -> sinon
alors	MOVE.L #'alo2',cas
		BRA finsi
sinon	MOVE.L #'sin2',cas
finsi
fin

* fin du programme principal
		BREAK	

* fin du contenu a assembler
		END