package tp02.telephone;

/**
 * Cette classe vise à implémenter les écrans.
 */
public class Ecran {
	private String type;
	private int taille;

	/**
	 * Constructeur de Ecran.
	 * 
	 * @param type
	 * @param taille
	 */
	public Ecran(String type, int taille) {
		this.type = type;
		this.taille = taille;
	}

	/**
	 * Getter de type
	 * 
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Getter de taille
	 * 
	 * @return taille
	 */
	public int getTaille() {
		return this.taille;
	}

	@Override
	public String toString() {
		return this.type +
		", " + this.taille + " pouces";
	}
}
