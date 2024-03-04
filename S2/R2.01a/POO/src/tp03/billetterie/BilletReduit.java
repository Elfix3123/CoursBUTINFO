package tp03.billetterie;

/*
 * Cette classe représente un billet à tarif réduit.
 */
public class BilletReduit extends Billet{
	private double tauxDeReduction;

	/*
	 * Constructeur de la classe BilletReduit.
	 * 
	 * @param prixAuKm le prix au kilomètre
	 * @param trajet le trajet
	 * @param tauxDeReduction le taux de réduction
	 */
	public BilletReduit(Trajet trajet, double prixAuKm, double tauxDeReduction) {
		super(trajet, prixAuKm);
		this.tauxDeReduction = tauxDeReduction;
	}

	/*
	 * Retourne le taux de réduction.
	 * 
	 * @return tauxDeReduction
	 */
	public double getTauxDeReduction() {
		return this.tauxDeReduction;
	}

	/* 
	 * Retourne le prix du billet réduit.
	 * 
	 * @return prix
	 */
	public double getPrix() {
		return super.getPrix() * (1 - this.tauxDeReduction);
	}

	/*
	 * Setter de tauxDeReduction.
	 * 
	 * @param tauxDeReduction le taux de réduction
	 */
	public void setTauxDeReduction(double tauxDeReduction) {
		if (tauxDeReduction < 0.05) {
			this.tauxDeReduction = 0.05;
		}
		else if (tauxDeReduction > 0.5) {
			this.tauxDeReduction = 0.5;
		}
		else {
			this.tauxDeReduction = tauxDeReduction;	
		}
	}

	/*
	 * Retourne une représentation textuelle de l'instance courante de BilletReduit.
	 * 
	 * @return la représentation de BilletReduit
	 */
	@Override
	public String toString() {
		return super.toString() + ", avec une réduction de " + this.tauxDeReduction*100 + "%";

	}

}
