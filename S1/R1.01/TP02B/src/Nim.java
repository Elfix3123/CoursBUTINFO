import java.util.Scanner;

public class Nim {
	private static int saisieEntSupEgalMin(int min){
		// { min > 0 } => { résultat = un entier positif supérieur ou égal à min saisi par l'utilisateur }
		Scanner lecteur = new Scanner(System.in);
		System.out.print("Veuillez entrer un entier superieur ou egal à " + min + " : ");
		int entree = lecteur.nextInt();
		lecteur.nextLine();
		while(entree < min){
			System.out.print("Entier non valide ! Veuillez entrer un entier superieur ou egal à " + min + " : ");
			entree = lecteur.nextInt();
			lecteur.nextLine();
		}
		return entree;
	}
	
	private static int unePrise(int reste, int max){
		// { reste > 0, max > 0 } => { résultat = entier > 0 et inférieur ou égal à la plus petite valeur parmi reste et max }
		if(reste < max){max = reste;}
		Scanner lecteur = new Scanner(System.in);
		System.out.print("Entrez un entier (min 1, max " + max + "): ");
		int entree = lecteur.nextInt();
		lecteur.nextLine();

		while((entree < 1)|(entree > max)){
			System.out.print("*** Saisie invalide recommencez... Entrez un entier (min 1, max " + max + "): ");
			entree = lecteur.nextInt();
			lecteur.nextLine();
		}
		return entree;
	}

	public static void main(String[] args){
		final int MINJOUEURS = 2;
		final int MAXPRISE = 3;
		int numJoueur = 2;
		int nbCoups = 0;
		int prise;

		System.out.print("------------------------------------------------\nNombre de joueurs ?\n");
		int nbJoueurs = saisieEntSupEgalMin(MINJOUEURS);
		System.out.print("------------------------------------------------\nNombre d'allumettes?\n");
		int nbAllumettes = saisieEntSupEgalMin(3*nbJoueurs);
		System.out.print("------------------------------------------------\n\n********************************\n* Nombre de joueurs : " + nbJoueurs + "\n* Nombre d'allumettes : " + nbAllumettes + "\n********************************\n");

		int reste = nbAllumettes;

		while(reste > 0){
			numJoueur = (numJoueur%nbJoueurs)+1;
			nbCoups += 1;
			System.out.println("Joueur n°" + numJoueur + ", combien prenez-vous d'allumettes ?");
			prise = unePrise(reste, MAXPRISE);
			reste -= prise;
			System.out.println("> Il reste " + reste + " allumettes");
		}

		System.out.print("*****************************************************************\nVictoire du joueur n°" + numJoueur + " après " + nbCoups + " coups !\n*****************************************************************");
	}
}
