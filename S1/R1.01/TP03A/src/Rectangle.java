import java.lang.Math;

public class Rectangle {
	// un rectangle est défini par la longueur de ses côtés quelle que soit sa position dans le plan
	
	// Attributs
	private float cote1; // longueur d'un côté
	private float cote2; // longueur des côtés adjacents à cote1
	
	public Rectangle(float cote1, float cote2) {
		this.cote1 = cote1;
		this.cote2 = cote2;
	}
	
	// getters 
	public float getCote1() {
		return this.cote1;
	}

	public float getCote2() {
		return this.cote2;
	}
	
	public float getDiagonale() {
		// { } => { resultat = diagonale de l'instance courante de Rectangle}
		return (float)Math.sqrt(Math.pow(this.cote1, 2) + Math.pow(this.cote2, 2));
	}

	public float getPerimetre() {
		// { } => { résultat = périmètre de ce Rectangle }
		return (2*this.cote1)+(2*this.cote2);
	}
	
	public float getSurface() {
		// { } => { résultat = surface de ce Rectangle }
		return this.cote1*this.cote2;
	}
	
	public Cercle cercleInscrit() {
		// { } => { résultat = le Cercle inscrit dans ceRectangle }
		return new Cercle(Math.min(this.cote1, this.cote2));
	}

	public Cercle cercleCirconscrit() {
		// { } => { résultat = le Cercle inscrit dans ceRectangle }
		return new Cercle(getDiagonale()/2);
	}

	@Override
	public String toString() {
		return "Cotés : ("+ cote1 + ", " + cote2 + ") | Périmètre : " + getPerimetre() + " | Surface : " + getSurface();
	}
}
