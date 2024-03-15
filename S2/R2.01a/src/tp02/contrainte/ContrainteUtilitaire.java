package tp02.contrainte;

import java.util.Scanner;

public class ContrainteUtilitaire {
	/**
	 * Retourne un objet de type ReelContraint tut en veillant à ce que la valeur 
	 * saisie par l’utilisateur soit bien comprise dans l’intervalle [min, max] 
	 * 
	 * @param min
	 * @param max
	 * @return un bjet ReelContraint
	 */
	public static Note saisir() {
		Scanner lecteur = new Scanner(System.in);
		System.out.println("Veuillez entrer un double compris entre 0 et 20");
		double entree = lecteur.nextDouble();
		lecteur.nextLine();

		while (entree < 0 | entree > 20) {
			System.out.println("Entrée invalide !");
			System.out.println("Veuillez entrer un double compris entre 0 et 20");
			entree = lecteur.nextDouble();
			lecteur.nextLine();
		}

		Note note = new Note(entree);
		return note;
	}
}
