package tp03.billetterie;

import java.util.ArrayList;

public class BilletterieUtilitaire {
	/*
	 * Arrondit le prix en paramètre à deux décimales.
	 * 
	 * @param prix le prix à arrondir
	 */
	public static double arrondirPrix(double prix) {
		return Math.round(prix * 100.0) / 100.0;
	}

	/*
	 * Affiche les trajets du vecteur en paramètre.
	 * 
	 * @param trajets le vecteur des trajets
	 */
	public static void afficheTrajets(ArrayList<Trajet> trajets) {
		System.out.println("----- Les trajets -----");
		int i = 0;

		while (i < trajets.size()) {
			System.out.println(trajets.get(i));
			i++;
		}

		System.out.println();
	}

	/*
	 * Affiche les billets du vecteur en paramètre.
	 * 
	 * @param billets le vecteur des billets
	 */
	public static void afficheBillets(ArrayList<Billet> billets) {
		System.out.println("----- Les billets -----");
		int i = 0;

		while (i < billets.size()) {
			System.out.println(billets.get(i));
			i++;
		}

		System.out.println();
	}
}
