package tp01.universite;

public class EtudiantUtilitaire {
	/**
	 * Capitalise la chaine de charactères en paramètre
	 *
	 * @return la chaine en minuscules, sauf la première lettre qui est en majuscule
	 */
	public static String capitalize(String chaine) {
		StringBuilder chaineSB = new StringBuilder(chaine.toLowerCase());	// Creation d'un StringBuilder à partir de chaine en minuscules
		chaineSB.setCharAt(0, Character.toUpperCase(chaineSB.charAt(0)));	// Modification du premier charactère de chaineSB pour le mettre en majuscule
		return chaineSB.toString();	// Renvoi de chaineSB passé en string
	}

	public static void affiche(Etudiant etudiant) {
		/**
		 * Affiche l'instance d'etudiant en paramètre
		 */
		System.out.print("Login : " + etudiant.getLogin() +
						"\nNom complet : " + etudiant.getNomComplet() +
						"\nMail : " + etudiant.getMail());
		if (etudiant.existAdresse()) {
			System.out.println("Adresse : " + etudiant.getAdresse());
		}
		else {
			System.out.println("Adresse : aucune");
		}
		int indiceNotesEtudiant = etudiant.getIndiceDeNotes();
		if (indiceNotesEtudiant > 0) {
			System.out.println("Moyenne : " + etudiant.getMoyenne());
			System.out.print(indiceNotesEtudiant + " notes : ");
			int i = 0;
			while (i < indiceNotesEtudiant) {
				System.out.print(etudiant.getNotes()[i] + " ");
				i++;
			}
		}
		else {
			System.out.println("Moyenne : aucune note");
		}
	}
}
