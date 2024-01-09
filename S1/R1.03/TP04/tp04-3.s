  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	Inst1	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on reserve et on initialise avec la directive DC 
* on reserve sans initialiser avec la directive DS
		ORG	$A00
A   		DS.L 1
B	        DS.L 1


* debut des instructions du programme

		ORG	$AC0
Inst1		MOVE.L #348,A
		    MOVE.L #2225,B

*  a vous d'ecrire la suite en assembleur...

        MOVE.L A,d1
        MOVE.L B,d2
tq      CMP.L d1,d2     ;d2 ? d1
        BEQ fintq       ;d2 = d1 => aller à fintq
si      CMP.L d1,d2     ;d2 ? d1
        BCC sinon       ;d2 >= d1 en base 2 => aller à sinon
alors   SUB.L d2,d1
        BRA finsi
sinon   SUB.L d1,d2
finsi   BRA tq
fintq   NOP
        MOVE.L d1,d0


* fin du programme principal
		BREAK	

* fin du contenu a assembler
		END



