package tp03.etudiant;

import java.util.ArrayList;
import java.util.TreeSet;
import tp02.universite.*;

public class TestOrdreNaturelEtudiant {
	public static void main(String[] args) {
		// Créer les étudiants
		Etudiant etudiant1 = new Etudiant("login1", "Floriant", "Sanz");
		Etudiant etudiant2 = new Etudiant("login2", "Pierre-antoine", "Porte");
		Etudiant etudiant3 = new Etudiant("login3", "Nils", "Burlat");
		Etudiant etudiant4 = new Etudiant("login4", "Raphaël", "Brunet-manquat");
		Etudiant etudiant5 = new Etudiant("login5", "Maxime", "Brunet-manquat");

		// Créer la liste d'étudiants quelconque et ajouter les étudiants
		ArrayList<Etudiant> mesEtudiantsOrdreQcq = new ArrayList<>();
		mesEtudiantsOrdreQcq.add(etudiant1);
		mesEtudiantsOrdreQcq.add(etudiant2);
		mesEtudiantsOrdreQcq.add(etudiant3);
		mesEtudiantsOrdreQcq.add(etudiant4);
		mesEtudiantsOrdreQcq.add(etudiant5);

		// Afficher la liste d'étudiants quelconque
		System.out.println("--------------\nLes étudiants : mesEtudiantsOrdreQcq");
		TestUtilitaire.affichageEtudiants(mesEtudiantsOrdreQcq);

		// Créer l'ensemble d'étudiants trié et ajouter les étudiants
		TreeSet<Etudiant> mesEtudiantsTries = new TreeSet<>();
		mesEtudiantsTries.add(etudiant1);
		mesEtudiantsTries.add(etudiant2);
		mesEtudiantsTries.add(etudiant3);
		mesEtudiantsTries.add(etudiant4);
		mesEtudiantsTries.add(etudiant5);

		// Afficher l'ensemble d'étudiants trié
		System.out.println("--------------\nLes étudiants triés : mesEtudiantsTries");
		TestUtilitaire.affichageEtudiants(mesEtudiantsTries);
	}
}
