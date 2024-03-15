package tp01.forme;

public class Point {
	/*
	 * La classe Point représente un point du plan.
	 * 
	 * Les attributs x et y sont toujours positifs.
	 */
	private int x;
	private int y;

	/*
	 * Constructeur avec arguments de Point
	 * 
	 * @param x l'abscisse du point
	 * @param y l'ordonnée du point
	 */
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	/*
	 * Constructeur dans arguments de Point
	 * Les valeurs par défault de x et y sont 0
	 */
	public Point() {
		this.setX(0);
		this.setY(0);
	}

	// Getters et setters
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		if (x >= 0) {
			this.x = x;
		}
		else {
			this.x = 0;
		}
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		if (y >= 0) {
			this.y = y;
		}
		else {
			this.y = 0;
		}
	}

	// Methodes
	/*
	 * Déplace l'instance courante de point d'un vécteur donné en paramètres.
	 * 
	 * @param dX le déplacement horizontal du point
	 * @param dY le déplacement vertical du point
	 */
	public void deplaceXY(int dX, int dY) {
		this.setX(x + dX);
		this.setY(y + dY);
	}

	@Override
	public String toString() {
		return "{" +
			" x='" + getX() + "'" +
			", y='" + getY() + "'" +
			"}";
	}
}
