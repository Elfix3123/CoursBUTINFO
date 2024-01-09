  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	calcul	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on les initialise avec la directive DC 

		ORG	$A00
PrixBonbon		DC.B	18
PrixChocolat	DC.B	9
PrixGateau		DC.B	51
Depenses		DC.B	0
Etrennes		DC.B	100
Solde			DC.B	0

* debut des instructions du programme

		ORG	$AC0
calcul		MOVE.B	PrixBonbon,D1		* D1.B := PrixBonbon
			ADD.B	PrixChocolat,D1		* D1.B := D1.B + PrixChocolat = PrixBonbon + PrixChocolat
			ADD.B	PrixGateau,D1		* D1.B := D1.B + PrixGateau = PrixBonbon + PrixChocolat + PrixGateau
			MOVE.B	D1,Depenses			* Depenses := D1.B = PrixBonbon + PrixChocolat + PrixGateau

			MOVE.B	Etrennes,D1			* D1.B := Etrennes
			SUB.B	Depenses,D1			* D1.B := D1.B - Depenses = Etrennes - Depenses
			MOVE.B	D1,Solde			* Solde := D1.B = Etrennes - Depenses

* fin du programme principal
		BREAK	

* fin du contenu a assembler
		END