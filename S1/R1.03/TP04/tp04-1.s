  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	Inst1	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on reserve et on initialise avec la directive DC 
* on reserve sans initialiser avec la directive DS
		ORG	$A00
Solde		DS.W 1
Depenses	DS.W 1


* debut des instructions du programme

		ORG	$AC0
Inst1		MOVE.W #20,Solde     ;  Solde := 20
		MOVE.W #40,Depenses   ;  Depenses :=40

*  a vous d'ecrire la suite en assembleur...

tq			CMPI.W		#20,Solde			;Solde ? 20
			BGT			fintq				;Solde > 20 en cpt. 2
et			CMPI.W		#50,Depenses		;Depenses ? 50
			BCC			fintq				;Depenses >= 50 en base 2
faire		SUBI.W		#5,Solde
			ADDI.W		#5,Depenses
			BRA			tq
fintq



* fin du programme principal
		BREAK	

* fin du contenu a assembler
		END



