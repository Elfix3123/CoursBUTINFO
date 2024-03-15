package tp01;

import java.util.Scanner;

public class TestString {
	public static void main(String[] args) {
		// Exercice 1.1
		Scanner entree = new Scanner(System.in);	// Initialisation du lecteur

		System.out.println("Entrez un texte :");
		String maChaine = entree.nextLine();	// Lecture de l'entrée
		System.out.println("Valeur de maChaine : \n" + maChaine);	// Affichage de l'entrée

		// Exercice 1.2
		System.out.println("Nombre de caractères de maChaine : " + maChaine.length());	// Utilisation de la méthode String.length() pour récuperer le nombre de caractères de maChaine
		System.out.println(maChaine.toUpperCase());	// Uttilisation de String.toUpperCase() pour passer maChaine en majuscules

		String maDeuxiemeChaine = entree.nextLine();	// Lecture d'une deuxième chaine

		if (maChaine.compareToIgnoreCase(maDeuxiemeChaine) == 0) {	// Vérification de la similarité des deux chaines
			System.out.println("Les deux chaines sont identiques sans tenir compte de la casse");
		}
		else {
			System.out.println("Les deux chaines sont différentes sans tenir compte de la casse");
		}
		if (maChaine.compareTo(maChaine.toLowerCase()) == 0) {	// Vérification de la casse de maChaine
			System.out.println("maChaine est en minuscules");
		}
		else {
			System.out.println("maChaine est en majuscules");
		}
		System.out.println("maChaine sans blancs : " + maChaine.trim());	// Utilisation de String.trim() pour enlever les blancs
	}
}