package tp02.telephone;

/**
 * Cette classe vise à implémenter les processeurs.
 */
public class Processeur {
	private String libelle;
	private double frequence;

	/**
	 * Constructeur de Processeur.
	 * 
	 * @param libelle
	 * @param frequence
	 */
	public Processeur(String libelle, double frequence) {
		this.libelle = libelle;
		this.frequence = frequence;
	}

	/**
	 * Getter de libelle
	 * 
	 * @return libelle
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Getter de frequence
	 * 
	 * @return frequence
	 */
	public double getFrequence() {
		return this.frequence;
	}

	@Override
	public String toString() {
		return this.libelle +
		" (" + this.frequence + "GHz)";
	}
}
