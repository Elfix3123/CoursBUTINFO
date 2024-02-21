package tp02.universite;

import tp02.contrainte.ReelContraint;

/**
 * La classe Personnel représente la notion de personnel et hérite de la classe Personne.
 */
public class Personnel extends Personne {
	private int echelon;
	public static final int ECHELON_MIN = 1;
	public static final int ECHELON_MAX = 4;
	private ReelContraint pointDIndice;
	public static final double POINTDINDICE_MIN = 1000;
	public static final double POINTDINDICE_MAX = 1200;

	/**
	 * Constructeur de Personnel sans echelon et point d'indice.
	 * 
	 * @param login le login du Personnel
	 * @param prenom le prénom du Personnel
	 * @param nom le nom du Personnel
	 */
	public Personnel(String login, String prenom, String nom) {
		// Appel du constructeur de la classe parent
		super(login, prenom, nom);
		this.setEchelon(ECHELON_MIN);
		this.pointDIndice = new ReelContraint(POINTDINDICE_MIN, POINTDINDICE_MAX);
		this.setPointDIndice(POINTDINDICE_MIN);
	}

	/**
	 * Constructeur de Personnel.
	 * 
	 * @param login le login du Personnel
	 * @param prenom le prénom du Personnel
	 * @param nom le nom du Personnel
	 * @param echelon l'échelon du Personnel
	 * @param pointDIndice le point d'indice du Personnel
	 */
	public Personnel(String login, String prenom, String nom, int echelon, double pointDIndice) {
		// Appel du constructeur de la classe parent
		super(login, prenom, nom);
		this.setEchelon(echelon);
		this.pointDIndice = new ReelContraint(POINTDINDICE_MIN, POINTDINDICE_MAX);
		this.setPointDIndice(pointDIndice);
	}

	/**
	 * Getter d'echelon.
	 * 
	 * @return l'echelon de l'instance courante de Personnel.
	 */
	public int getEchelon() {
		return this.echelon;
	}

	/**
	 * Getter de point d'indice.
	 * 
	 * @return le point d'indice de l'instance courante de Personnel.
	 */
	public ReelContraint getPointDIndice() {
		return this.pointDIndice;
	}
	
	/**
	 * Setter de echelon.
	 * 
	 * @param echelon l'échelon de l'instance courante de Personnel.
	 */
	public void setEchelon(int echelon) {
		if (echelon < this.ECHELON_MIN) {
			this.echelon = this.ECHELON_MIN;
		}
		else if (echelon > this.ECHELON_MAX) {
			this.echelon = this.ECHELON_MAX;
		}
		else {
			this.echelon = echelon;
		}
	}

	/**
	 * Setter de point d'indice.
	 * 
	 * @param pointDIndice le point d'indice de l'instance courante de Personnel.
	 */
	public void setPointDIndice(double pointDIndice) {
		this.pointDIndice.setValeur(pointDIndice);
	}

	/**
	 * Renvoie le salaire calculé.
	 * 
	 * @return this.echelon * this.pointDIndice
	 */
	public double getSalaire() {
		return this.echelon * this.pointDIndice.getValeur();
	}

	/**
	 * Renvoie le mail du Personnel.
	 *
	 * @return Le mail
	 */
	public String getMail() {
		return super.getPrenom() + "." + super.getNom() + "@univ-grenoble-alpes.fr";
	}

	@Override
	public String toString() {
		return "{" +
			"Personne = '" + super.toString() + "'" +
			" echelon='" + getEchelon() + "'" +
			", pointDIndice='" + getPointDIndice() + "'" +
			"}";
	}
}
