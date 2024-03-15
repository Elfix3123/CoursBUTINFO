package tp01.forme;

public class Rectangle {
	/*
	 * La classe Rectangle représente un rectangle du plan.
	 * 
	 * Les attributs largeur et longueur ainsi que les coordonnées d'origine
	 * sont troujours positives.
	 */
	private Point origine;
	private int largeur;
	private int longueur;

	//Constructeurs
	/*
	 * Constructeur de Rectangle de coordonnées (0, 0).
	 * 
	 * @param largeur la largeur du réctangle
	 * @param longueur la longueur du réctangle
	 */
	Rectangle (int largeur, int longueur) {
		this.origine = new Point();
		this.setLargeur(largeur);
		this.setLongueur(longueur);
	}

	/*
	 * Constructeur de Rectangle.
	 * 
	 * @param largeur la largeur du réctangle
	 * @param longueur la longueur du réctangle
	 * @param x l'abscisse d'origine du réctangle
	 * @param y l'ordonnée d'origine du réctangle
	 */
	Rectangle (int largeur, int longueur, int x, int y) {
		this.origine = new Point(x, y);
		this.setLargeur(largeur);
		this.setLongueur(longueur);
	}

	// Getters et setters
	public Point getOrigine() {
		return new Point(this.origine.getX(), this.origine.getY());
	}

	public int getLargeur() {
		return this.largeur;
	}

	public void setLargeur(int largeur) {
		if (largeur >= 0) {
			this.largeur = largeur;
		}
		else {
			this.largeur = 0;
		}
	}

	public int getLongueur() {
		return this.longueur;
	}

	public void setLongueur(int longueur) {
		if (longueur >= 0) {
			this.longueur = longueur;
		}
		else {
			this.longueur = 0;
		}
	}

	// Methodes
	/*
	 * Calcule le périmètre de l'instance courante de Rectangle.
	 * 
	 * @return Le périmètre du rectangle
	 */
	public double getPerimetre() {
		return 2 * (this.largeur + this.longueur);
	}

	/*
	 * Calcule l'aire de l'instance courante de Rectangle.
	 * 
	 * @return L'aire du rectangle
	 */
	public double getAire() {
		return this.largeur * this.longueur;
	}

	/*
	 * Déplace l'origine de l'instance courante de Rectangle.
	 * 
	 * @param dX le déplacement horizontal
	 * @param dY le déplacement vertical
	 */
	public void deplaceOrigine(int dX, int dY) {
		this.origine.deplaceXY(dX, dY);
	}

	@Override
	public String toString() {
		return "{" +
			" origine='" + this.getOrigine() + "'" +
			", largeur='" + this.getLargeur() + "'" +
			", longueur='" + this.getLongueur() + "'" +
			", périmètre='" + this.getPerimetre() + "'" +
			", aire='" + this.getAire() + "'" +
			"}";
	}

}
