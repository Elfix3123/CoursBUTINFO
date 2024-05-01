package jeu.guerriers;

import java.util.logging.Level;
import java.util.logging.Logger;

import jeu.Application;

/**
 * Classe utilitaire de Guerrier
 */
public class GuerrierUtilitaire {
	private static final Logger LOGGER = Logger.getLogger(Application.class.getPackageName());

	/**
	 * Lance un dé à 3 faces.
	 * 
	 * @return un nombre aléatoire tiré entre 1 et 3.
	 */
	public static int de3() {
		LOGGER.log(Level.INFO, "Lancement d'un dé à 3 faces");
		return (int)(Math.random()*3+1);
	}

	/**
	 * Lance nombreLancers dés à 3 faces.
	 * 
	 * @return la somme de nombreLancers nombres aléatoires tirés entre 1 et 3.
	 */
	public static int de3(int nombreLancers) {
		LOGGER.log(Level.INFO, "Lancement de " + nombreLancers + " dés à 3 faces");
		int somme = 0;
		int i = 0;

		while (i < nombreLancers) {
			somme += de3();
			i++;
		}

		return somme;
	}

	/**
	 * Retourne une instance d'une classe qui hérite de Guerrier (Nain, ChefNain, Elfe, ChefElfe) aléatoire
	 * 
	 * @return une instance d'une classe qui hérite de Guerrier
	 */
	public static Guerrier guerrierAleatoire() {
		LOGGER.log(Level.INFO, "Création d'une instance de guerrier aléatoire");
		int choix = (int)(Math.random()*4);
		switch (choix) {
			case 0:
				return new Nain();
			case 1:
				return new ChefNain();
			case 2:
				return new Elfe();
			case 3:
				return new ChefElfe();
			default:
				return null;
		}
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