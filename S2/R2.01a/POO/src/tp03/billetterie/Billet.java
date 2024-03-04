package tp03.billetterie;

import javax.swing.text.Utilities;

/*
 * Cette classe représente un billet.
 */
public class Billet {
	private double prixAuKm;
	private Trajet trajet;

	/*
	 * Constructeur de la classe Billet.
	 * 
	 * @param prixAuKm le prix au kilomètre
	 * @param trajet le trajet
	 */
	public Billet(Trajet trajet, double prixAuKm) {
		this.prixAuKm = prixAuKm;
		this.trajet = trajet;
	}

	/*
	 * Retourne le départ du trajet.
	 * 
	 * @return trajet.depart
	 */
	public String getDepart() {
		return this.trajet.getDepart();
	}

	/*
	 * Retourne l'arrivée du trajet.
	 * 
	 * @return trajet.arrivee
	 */
	public String getArrivee() {
		return this.trajet.getArrivee();
	}

	/*
	 * Retourne la distance du trajet.
	 * 
	 * @return trajet.distance
	 */
	public int getDistance() {
		return this.trajet.getDistance();
	}

	/*
	 * Retourne le prix au kilomètre.
	 * 
	 * @return prixAuKm
	 */
	public double getPrixAuKm() {
		return this.prixAuKm;
	}

	/* 
	 * Retourne le prix du billet.
	 * 
	 * @return prix
	 */
	public double getPrix() {
		return this.getPrixAuKm() * this.trajet.getDistance();
	}

	/*
	 * Setter de prixAuKm.
	 * 
	 * @param prixAuKm le prix au kilomètre
	 */
	public void setPrixAuKm(double prixAuKm) {
		if (prixAuKm < 0.1) {
			this.prixAuKm = 0.1;
		}
		else if (prixAuKm > 2) {
			this.prixAuKm = 2;
		} 
		else {
			this.prixAuKm = prixAuKm;
		}
	}

	/*
	 * Retourne une représentation textuelle de l'instance courante de Billet.
	 * 
	 * @return la représentation de Billet
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : [" + this.trajet + "], prix : " + BilletterieUtilitaire.arrondirPrix(this.getPrix()) + " euros";
	}
}
