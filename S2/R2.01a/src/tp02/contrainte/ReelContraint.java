package tp02.contrainte;

/**
 * Cette classe implémente un réel contraint, qui permet de définir des réels pour lesquels on
assure que leur valeur est comprise dans un intervalle fixé par une valeur minimale (min) et
une valeur maximale (max).
 */
public class ReelContraint {
	private final double min;
	private final double max;
	private double valeur;
	
	/**
	 * Constructeur de ReelContraint.
	 * @param min la valeur minimum 
	 * @param max la valeur maximum
	 */
	public ReelContraint(double min, double max) {
		this.min = min;
		this.max = max;
		this.valeur = min;
	}

	/**
	 * Getter de valeur.
	 * @return valeur
	 */
	public double getValeur() {
		return this.valeur;
	}

	/**
	 * Setter de valeur
	 * @param valeur
	 */
	public void setValeur(double valeur) {
		if (valeur >= this.min & valeur <= this.max) {
			this.valeur = valeur;
		}
	}

	/**
	 * Methode toString de ReelContraint.
	 * 
	 * @return l'instance courante de ReelContradouble sous forme de String.
	 */
	@Override
	public String toString() {
		return "{" +
			"valeur='" + this.valeur + "'" +
			", min='" + this.min + "'" +
			", max='" + this.max + "'" +
			"}";
	}
}
