  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	calcul	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on les initialise avec la directive DC 

		ORG	$A00
PrixBonbon	DC.B	18




* debut des instructions du programme

		ORG	$AC0
calcul		MOVE.B	PrixBonbon,D1     * D1.B := PrixBonbon




* fin du programme principal
		BREAK	

* fin du contenu a assembler
		END



