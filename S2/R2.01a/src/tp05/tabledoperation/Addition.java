package tp05.tabledoperation;

/**
 * Cette classe vise à enrichir la classe Operation afin d'implémenter
 * les comportements spécifiques à l'addition.
 */
public class Addition extends Operation {
	/**
	 * Constructeur d'une instance d'Addition entre deux termes.
	 * 
	 * @param terme1
	 * @param terme2
	 */
	public Addition(double terme1, double terme2) {
		super(terme1, terme2);
	}

	/**
	 * Calcule et renvoie la réponse de l'addition.
	 * 
	 * @return double
	 */
	@Override
	public double calculResultat() {
		return this.getTerme1() + this.getTerme2();
	}

	/**
	 * Renvoie une représentation textuelle de l'opération.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return this.getTerme1() + " + " + this.getTerme2() + " = ? ";
	}
}
