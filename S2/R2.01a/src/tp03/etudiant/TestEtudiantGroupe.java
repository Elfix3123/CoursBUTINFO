package tp03.etudiant;

import tp02.universite.*;

public class TestEtudiantGroupe {
	public static void main(String[] args) {
		// Créer des groupes
		Groupe groupeA = new Groupe("A");
		Groupe groupeB = new Groupe("B");
		
		// Créer des étudiants
		Etudiant etudiant1 = new Etudiant("SANZF", "FLORIANT", "Sanz");
		Etudiant etudiant2 = new Etudiant("portepa", "Pierre-Antoine", "Porte");
		Etudiant etudiant3 = new Etudiant("burlatn", "nils", "burlat");
		Etudiant etudiant4 = new Etudiant("brunetr", "Raphaël", "Brunet-Manquat");
		Etudiant etudiant5 = new Etudiant("brunetm", "Maxime", "Brunet-Manquat");
		
		// Ajouter TOUS les étudiants au groupe A
		// ATTENTION à ne pas boucler à cause de l'association bidirectionnelle !
		groupeA.ajouterEtudiant(etudiant1);
		groupeA.ajouterEtudiant(etudiant1); 
		// On ajoute plusieurs fois le même étudiant
		groupeA.ajouterEtudiant(etudiant1); 
		groupeA.ajouterEtudiant(etudiant2);
		groupeA.ajouterEtudiant(etudiant3);
		groupeA.ajouterEtudiant(etudiant4);
		groupeA.ajouterEtudiant(etudiant5);
		
		// Ajouter les deux derniers étudiants au groupe B
		etudiant4.setGroupe(groupeB);
		etudiant5.setGroupe(groupeB);
		
		// Afficher les étudiants du groupe A
		System.out.println("---------");
		System.out.println("Etudiants du Groupe A");
		for (Etudiant etudiant : groupeA.getEtudiants()) { 
			System.out.println(etudiant.getGroupe().getLibelle() + " " +
			etudiant.getNom() + " " + etudiant.getPrenom());
		}
		
		// Afficher les étudiants du groupe B
		System.out.println("---------");
		System.out.println("Etudiants du Groupe B");
		for (Etudiant etudiant : groupeB.getEtudiants()) {
		System.out.println(etudiant.getGroupe().getLibelle() + " " +
		etudiant.getNom() + " " + etudiant.getPrenom());
		}
	}
}
