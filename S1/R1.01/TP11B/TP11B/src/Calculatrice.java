public class Calculatrice {
	public static final String[] opBinaire = new String[]{"divise", "exposant", "moins", "multiplie", "plus"};

	public static float calcul(float f1, float f2, String op) throws EDivideByZero, EBadExponentation, EUnknownOP {
		//{op représente une opérateur binaire} =>
		// {résultat = réel résultat de l'opération f1 op f2 si elle est valide
		// - l'exception EDivideByZero est levée si f2 est nul
		// et op est l'opérateur de division
		// - l'exception EBadExponentation est levée si f1 est négatif, f2 est inférieur à 1
		// et op est l'opérateur d'exponentiation
		// - l'exception EUnknownOP est levée si op n'est pas un opérateur connu}
		if (op.compareTo("plus") == 0) {
			return f1+f2;
		}
		else if (op.compareTo("moins") == 0) {
			return f1-f2;
		}
		else if (op.compareTo("multiplie") == 0) {
			return f1*f2;
		}
		else if (op.compareTo("divise") == 0) {
			if (f2 == 0f) {
				throw new EDivideByZero("Division par 0 non autorisée");
			}
			else {
				return f1/f2;
			}
		}
		else if (op.compareTo("exposant") == 0) {
			if (f1 < 0f && f2 < 1f) {
				throw new EBadExponentation("Puissance infèrieure à 1 d'un nombre négatif non autorisée");
			}
			else {
				return (float)Math.pow(f1, f2);
			}
		}
		else {
			throw new EUnknownOP("Opérateur inconnu");
		}
	}

	public static boolean estOpBinaire(String op) {
		// {} => {résultat = vrai si op est un opérateur binaire}
		int i = 0;

		while (i < opBinaire.length && opBinaire[i].compareTo(op) != 0) {
			i++;
		}

		return !(i==opBinaire.length);
	}

	public static boolean isFloat(String s) {
		//{} => {résultat = vrai si s représente un float}
		try {
			Float.valueOf(s);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

	public static float resExp(String exp, PileFloat pCalc) throws EPilePleine, EPileVide, EDivideByZero, EBadExponentation, EUnknownOP, EUnknowNumber{
		//{exp représente une séquence de calcul RPN (ex : 3 ENTER 2 plus 5 multiplie}
		// => {résultat = valeur résultant du calcul s'il est possible, sinon
		// l'exception levée est traitée et un message approprié est affiché}
		String[] monTableau = exp.split(" ");
		
		if (isFloat(monTableau[0])) {
			float ecran = Float.valueOf(monTableau[0]);
			int i = 1;
			while (i < monTableau.length) {
				System.out.println("Pile : " + pCalc);
				System.out.println("Ecran : " + ecran);
				System.out.println("Tableau[i] : " + monTableau[i]);
				System.out.println("i : " + i);
				System.out.println();
				if (isFloat(monTableau[i])){
					ecran = Float.valueOf(monTableau[i]);
				}
				else if (estOpBinaire(monTableau[i])) {
					try {
						ecran = calcul(ecran, pCalc.depile(), monTableau[i]);
					}
					catch (EPileVide e) {
						throw new EPileVide("Opérateur saisi avant l'opérande");
					}
				}
				else {
					try {
						pCalc.empile(ecran);
					}
					catch (EPilePleine e) {
						throw new EPilePleine("Trop de valeurs saisies");
					}
				}
				i++;
			}
			return ecran;
		}
		else {
			throw new EUnknowNumber("Opérateur saisi avant l'opérande");
		}



	}

	public static void main(String[] args) {
		PileFloat maPile = new PileFloat(4);
		
		try {
			System.out.println(resExp("30 ENTER 2 plus 5 multiplie", maPile));
		}
		catch (EPilePleine | EPileVide | EDivideByZero | EBadExponentation | EUnknownOP | EUnknowNumber e){
			System.out.println(e);
		}
	}
}