import java.util.Scanner;

public class Calculs {

	private static int saisieEntPosOuNul() {
		// { } => { résultat = un entier positif ou nul saisi par l'utilisateur }
		Scanner lecteur = new Scanner(System.in);
		System.out.print("Veuillez entrer un entier positif ou nul : ");
		int entree = lecteur.nextInt();
		lecteur.nextLine();
		while(entree < 0){
			System.out.print("Entier non valide ! Veuillez entrer un entier positif ou nul : ");
			entree = lecteur.nextInt();
			lecteur.nextLine();
		}
		return entree;
	}

	private static int saisieEntMinMax(int min, int max){
		// { 0 <= min <= max } => { résultat = entier compris entre min et max saisi par l'utilisateur }
		Scanner lecteur = new Scanner(System.in);
		System.out.print("Veuillez entrer un entier strictement compris entre " + min + " et " + max + " : ");
		int entree = lecteur.nextInt();
		lecteur.nextLine();
		while((entree < min)|(entree > max)){
			System.out.print("Entier non valide ! Veuillez entrer un entier strictement compris entre " + min + " et " + max + " : ");
			entree = lecteur.nextInt();
			lecteur.nextLine();
		}
		return entree;
	}

	private static int factorielle(int n) {
		// { n >= 0 } => { résultat = factorielle de n (n!) }
		int factorielle = 1;
		int compteur = 2;
		while(compteur <= n){
			factorielle *= compteur; 
			compteur++;
		}
		return factorielle;
	}

	private static int combinaison(int n, int p) {
		// { 0 <= p <= n } =>
		// { résultat = nombre de sous-ensembles de p éléments que l'on peut obtenir à partir d'un ensemble de n éléments - formule : n!/(p!*(n-p)!) }
		return factorielle(n)/(factorielle(p)*factorielle(n-p));
	}

	private static int arrangement(int n, int p) {
		// { 0 <= p <= n } =>
		// { résultat = nombre de n-uplets ordonnés de p éléments que l'on peut obtenir à partir d'un ensemble de n éléments formule : n!/(n-p)! }
		return factorielle(n)/factorielle(n-p);
	}

	private static void trianglePascal(int n) {
		// { n >= 0 } => { les lignes 0 à n du triangle de Pascal ont été affichées de façon à ce que sur chaque ligne, les coefficients binomiaux soient séparés par un espace }
		
	}

	public static void main(String[] args) {
		int n = saisieEntPosOuNul();
		int p = saisieEntMinMax(0, n);
		System.out.print("------------------------\nFactorielle de " + n + " = " + factorielle(n) + 
		"\n------------------------\nNombre de sous-ensembles de " + p + " éléments parmi " + p + " éléments : " + combinaison(n, p) + 
		"\n------------------------\nNombre de n-uplets ordonnés de " + p + " éléments parmi " + n + " éléments : " + arrangement(n, p));
	}
}
