package tp01.universite;

public class TestEtudiant {
	public static void main(String[] args) {
		// Création des étudiants
		Etudiant etudiant1 = new Etudiant("DUPONTP", "pierre", "DUPONT");
		Etudiant etudiant2 = new Etudiant("martinf", "francis", "martin");
		// Ajout d'une adresse et de notes
		etudiant2.setAdresse("2 Place Doyen Gosse");
		etudiant2.addNote(8.5);
		etudiant2.addNote(10);
		etudiant2.addNote(11.5);

		// Affichage des étudiants
		EtudiantUtilitaire.affiche(etudiant1);
		EtudiantUtilitaire.affiche(etudiant2);

	}
}
