package tp01.forme;

public class Cercle {
	/*
	 * La classe Cercle représente un cercle du plan.
	 * Elle utilise la classe point comme attribut centre.
	 * 
	 * L'attribut rayon est toujours positif.
	 */
	private Point centre;
	private int rayon;

	/*
	 * Constructeur de Cercle.
	 * Le centre est les coordonnées par défaut de Point.
	 * 
	 * @param rayon le rayon du cercle
	 */
	Cercle (int rayon) {
		this.centre = new Point();
		this.setRayon(rayon);
	}
	
	/*
	 * Constructeur de Cercle.
	 * 
	 * @param rayon le rayon du cercle
	 * @param point le centre du cercle
	 */
	Cercle (int rayon, Point point) {
		this.centre = point;
		this.setRayon(rayon);
	}

	// Getters et setters
	public Point getCentre() {
		return this.centre;
	}

	public int getRayon() {
		return this.rayon;
	}

	public void setRayon(int rayon) {
		if (rayon >= 0) {
			this.rayon = rayon;
		}
		else {
			this.rayon = 0;
		}
	}

	// Methodes
	/*
	 * Calcule le périmètre de l'instance courante de Cercle.
	 * 
	 * @return Le périmètre du cercle
	 */
	public double getPerimetre() {
		return 2 * Math.PI * this.rayon;
	}

	/*
	 * Calcule l'aire de l'instance courante de Cercle.
	 * 
	 * @return L'aire du cercle
	 */
	public double getAire() {
		return Math.PI * Math.pow(rayon, 2);
	}

	/*
	 * Déplace le centre de l'instance courante de Cercle.
	 * 
	 * @param dX le déplacement horizontal
	 * @param dY le déplacement vertical
	 */
	public void deplaceCentre(int dX, int dY) {
		this.centre.deplaceXY(dX, dY);
	}


	@Override
	public String toString() {
		return "{" +
			" centre='" + this.getCentre() + "'" +
			", rayon='" + this.getRayon() + "'" +
			", périmètre='" + this.getPerimetre() + "'" +
			", aire='" + this.getAire() + "'" +
			"}";
	}
}
