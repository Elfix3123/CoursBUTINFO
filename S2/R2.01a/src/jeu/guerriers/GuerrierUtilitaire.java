package guerriers;

/**
 * Classe utilitaire de Guerrier
 */
public class GuerrierUtilitaire {
	/**
	 * Lance un dé à 3 faces.
	 * 
	 * @return un nombre aléatoire tiré entre 1 et 3.
	 */
	public static int de3() {
		return (int)(Math.random()*3+1);
	}

	/**
	 * Lance nombreLancers dés à 3 faces.
	 * 
	 * @return la somme de nombreLancers nombres aléatoires tirés entre 1 et 3.
	 */
	public static int de3(int nombreLancers) {
		int somme = 0;
		int i = 0;

		while (i < nombreLancers) {
			somme += de3();
			i++;
		}

		return somme;
	}

	/**
	 * Affiche une instance de guerrier.
	 * 
	 * @param guerrier le guerrier à afficher
	 */
	public static void afficheGuerrier(Guerrier guerrier) {
		System.out.println(guerrier);
	}
}