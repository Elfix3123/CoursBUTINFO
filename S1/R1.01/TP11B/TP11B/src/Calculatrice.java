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
			
		}
	}

	public static boolean estOpBinaire(String op) {
		// {} => {résultat = vrai si op est un opérateur binaire}

	}

	public static boolean isFloat(String s) {
		//{} => {résultat = vrai si s représente un float}

	}

	public static float resExp(String exp, PileFloat pCalc) throws EPilePleine, EPileVide, EDivideByZero, EBadExponentation, EUnknownOP {
		//{exp représente une séquence de calcul RPN (ex : 3 ENTER 2 plus 5 multiplie}
		// => {résultat = valeur résultant du calcul s'il est possible, sinon
		// l'exception levée est traitée et un message approprié est affiché}

	}
}