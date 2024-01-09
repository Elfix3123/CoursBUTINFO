  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	debut	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on les initialise avec la directive DC 

		ORG	$A00
Solde	DC.B	0

* debut des instructions du programme


debut	ORG	$AC0
		MOVE.B	#-1,Solde
si1		BMI		sinon1		* Si Solde est négatif
alors1	NOP
si2		BEQ		sinon2		* Si Solde est égal à 0
alors2	NOP
		MOVE.W	#$AAAA,D0
		BRA finsi2
sinon2	MOVE.W	#$CCCC,D0
finsi2	MOVE.W	#$1111,D1
		BRA finsi1
sinon1	MOVE.W #$FFFF,D0
finsi1	MOVE.W #$2222,D2

* fin du programme principal
		BREAK	

* fin du contenu a assembler
		END



