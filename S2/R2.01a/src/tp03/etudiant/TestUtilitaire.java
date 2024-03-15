package tp03.etudiant;

import java.util.Collection;
import tp02.universite.*;

public class TestUtilitaire {
	/*
	 * Affiche les étudiants de la collection en paramètre.
	 */
	public static void affichageEtudiants(Collection<Etudiant> etudiants) {
		for (Etudiant etudiant : etudiants) {
			System.out.println("Moyenne = " + etudiant.getMoyenne() + " : " + etudiant.getNom() + ", " + etudiant.getPrenom());
		}
	}
}
