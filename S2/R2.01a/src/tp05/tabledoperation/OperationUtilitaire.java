package tp05.tabledoperation;

import java.util.Random;
public class OperationUtilitaire {
	private static final Random random = new Random();
	private static final int RANGE_MAX = 200;
	private static final int ARRONDI = 10;
	
	// Retourne une valeur de type double entre 0 et RANGE_MAX/ARRONDI
	public static double randomDouble() {
		return (double)random.nextInt(RANGE_MAX)/ARRONDI;
	}

	// Retourne la valeur double arrondi
	// Evite les erreurs de calcul du au double en Java
	public static double arrondir(double valeur) {
		return (double)Math.round(valeur * ARRONDI) / ARRONDI;
	}

	/**
	 * Retourne une des classes filles de Operation en fonction du paramètre.
	 * 
	 * @param terme1
	 * @param terme2
	 * @param typeOperation
	 */
	public static Operation getOperation(double terme1, double terme2, OperationEnum typeOperation) {
		if (typeOperation == OperationEnum.ADDITION) {
			return new Addition(terme1, terme2);
		} else if (typeOperation == OperationEnum.SOUSTRACTION) {
			return new Soustraction(terme1, terme2);
		} else {
			return new Multiplication(terme1, terme2);
		}
	}
}