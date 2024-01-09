import java.lang.Math;

public class Cercle {
	// Constante PI (rapport constant du périmètre d'un cercle à son diamètre)
	final double PI = 3.14;
	// Attribut
	float rayon;  // longueur du rayon

	// Constructeur - À DÉCOMMENTER ET COMPLÉTER
	public Cercle(float rayon) {
		this.rayon = rayon;
	}

	// Méthodes
	// getter
	public float getRayon() {
		return this.rayon;
	}

	// périmètre
	public float getPerimetre() {
		// { } => { Résultat = périmètre de ce Cercle }
		return 2 * (float)this.PI * this.rayon;
	}

	// surface
	public float getSurface() {
		// { } => { Résultat = surface de ce Cercle }
		return (float)this.PI * (float)Math.pow(this.rayon, 2);
	}

	// Pour l'affichage du rayon, du périmètre et de la surface de ce Cercle
	@Override
	public String toString() {
		return "Rayon : "+ rayon + " | Périmètre : " + getPerimetre() + " | Surface : " + getSurface();
	}
}
