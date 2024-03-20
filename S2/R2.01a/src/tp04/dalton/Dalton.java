package tp04.dalton;

import java.util.Comparator;

public class Dalton implements Comparable<Dalton>{
	private String nom;
	private Taille taille;

	/**
	 * Constructeur d'un Dalton.
	 * 
	 * @param nom
	 * @param taille
	 */
	public Dalton(String nom, Taille taille) {
		this.nom = nom;
		this.taille = taille;
	}

	/**
	 * Renvoie la taille du Dalton.
	 * 
	 * @return taille
	 */
	public Taille getTaille() {
		return this.taille;
	}

	/**
	 * Renvoie le nom du Dalton.
	 * 
	 * @return nom
	 */
	public String getNom() {
		return this.nom;
	}

	public static final Comparator<Dalton> compareDaltonNom = new Comparator<Dalton>() {
		@Override
		public int compare(Dalton o1, Dalton o2) {
			return o1.nom.compareTo(o2.nom);
		}
	};

	@Override
	public int compareTo(Dalton d) {
		ComparateurTaille comparateurTaille = new ComparateurTaille();
		if (comparateurTaille.compare(this, d) == 0) {
			ComparateurNom comparateurNom = new ComparateurNom();
			return comparateurNom.compare(this, d);
		}
		else {
			return comparateurTaille.compare(this, d);
		}
	}

	@Override
	public String toString() {
		return this.nom + " (" + this.taille.toString() + ")";
	}

}
