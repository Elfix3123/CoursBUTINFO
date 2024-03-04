package tp03.etudiant;

import java.util.ArrayList;
import java.util.Collections;

import tp02.universite.*;

public class TestEtudiantTriMoyenne {
	public static void main(String[] args) {
		// Créer les étudiants
		Etudiant etudiant1 = new Etudiant("login1", "Floriant", "Sanz");
		Etudiant etudiant2 = new Etudiant("login2", "Pierre-antoine", "Porte");
		Etudiant etudiant3 = new Etudiant("login3", "Nils", "Burlat");
		Etudiant etudiant4 = new Etudiant("login4", "Raphaël", "Brunet-manquat");
		Etudiant etudiant5 = new Etudiant("login5", "Maxime", "Brunet-manquat");

		// Ajouter des notes aux étudiants
		etudiant1.addNote(16.0);
		etudiant2.addNote(9.0);
		etudiant3.addNote(13.0);
		etudiant4.addNote(19.0);
		etudiant5.addNote(18.0);

		// Créer la liste d'étudiants et ajouter les étudiants
		ArrayList<Etudiant> mesEtudiantsTries = new ArrayList<>();
		mesEtudiantsTries.add(etudiant1);
		mesEtudiantsTries.add(etudiant2);
		mesEtudiantsTries.add(etudiant3);
		mesEtudiantsTries.add(etudiant4);
		mesEtudiantsTries.add(etudiant5);

		// Afficher la liste d'étudiants avant tri
		System.out.println("--------------\nLes étudiants avant Collections.sort() :");
		TestUtilitaire.affichageEtudiants(mesEtudiantsTries);

		// trier la liste
		Collections.sort(mesEtudiantsTries, Etudiant.compareToMoyenne);

		// Afficher la liste des étudiants après tri
		System.out.println("--------------\nLes étudiants après Collections.sort() :");
		TestUtilitaire.affichageEtudiants(mesEtudiantsTries);
	}
}
