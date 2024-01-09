import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;


public class VecteusrDeInteger {

	public static int saisieEntPos(){
		// { } => { résultat = un entier strictement positif }
		Scanner lecteur = new Scanner(System.in);
		System.out.print("Veuillez entrer un entier strictement positif : ");
		int entree = lecteur.nextInt();
		lecteur.nextLine();
		while(entree <= 0){
			System.out.print("Entier non valide ! Veuillez entrer un entier strictement positif : ");
			entree = lecteur.nextInt();
			lecteur.nextLine();
		}
		return entree;
	}

	public static ArrayList<Integer> lesDiviseurs(int unEnt) {
		// { unEnt >0 } => {résultat = vecteur contenant les diviseurs de unEnt
		// y compris 1 et unEnt }
		ArrayList<Integer> diviseursDeUnEnt = new ArrayList<Integer>();
		int i = 1;
		// Invariant : ∀a <= i, unEnt % a = 0 ⇔ a ∈ diviseursDeUnEnt
		while(i <= unEnt){
			if(unEnt % i == 0){
				diviseursDeUnEnt.add(i);
			}
			i++;
			// invariant vérifié en fin de boucle
		}
		// i = diviseursDeUnEnt.size() + 1 : sortie de boucle
		// invariant vérifié en sortie de boucle
		return diviseursDeUnEnt;
	}

	private static int sommeDe(ArrayList<Integer> unVectEntPos) {
		// { unVectEntPos non vide, tous ses éléments sont > 0 } =>
		// { résultat = somme des éléments de unVectEntPos }
		int sommeDeVect = 0;
		int i = 0;
		// Invariant : sommeDeVect = Σ pour k de 0 à i-1 de unVectEntierPos[k]
		while(i < unVectEntPos.size()){
			sommeDeVect += unVectEntPos.get(i);
			i++;
			// invariant vérifié en fin de boucle
		}
		// i = unVectEntPos.size() : sortie de boucle
		// invariant vérifié en sortie de boucle
		return sommeDeVect;
	}

	private static boolean estPremier(int unEnt) {
		// { unEnt >0 } => { résultat = vrai si unEnt est PREMIER }
		return lesDiviseurs(unEnt).size() == 2;
	}

	private static boolean estParfait (int unEnt) {
		// {unEnt >0 } => { résultat = vrai si unEnt est PARFAIT }
		return (sommeDe(lesDiviseurs(unEnt))%2 == 0) && (sommeDe(lesDiviseurs(unEnt))/2 == unEnt);
	}

	private static boolean estSublime(int unEnt) {
		//{ unEnt >0 } => { résultat = vrai si unEnt est SUBLIME }
		return (estParfait(lesDiviseurs(unEnt).size()))&&(estParfait(sommeDe(lesDiviseurs(unEnt))));
	}

	private static String qualiteDe(int unEnt) {
		// { unEnt >0 } =>
		// { résultat = "PREMIER", "PARFAIT", "SUBLIME" ou "QUELCONQUE"
		// selon les propriétés de unEnt }
		if(estPremier(unEnt)){
			return "PREMIER";
		}
		else if(estParfait(unEnt)){
			return "PARFAIT";
		}
		else if(estSublime(unEnt)){
			return "SUBLIME";
		}
		else{
			return "QUELCONQUE";
		}
	}

	public static void main(String[] args) {
		int unEnt;
		unEnt = saisieEntPos();
		ArrayList<Integer> lesDiv;
		lesDiv = lesDiviseurs(unEnt);
		String qualite = qualiteDe(unEnt);

		System.out.println("* Diviseurs de " + unEnt + " : " + lesDiv);
		System.out.println("* Nombre de diviseurs : " + lesDiv.size());
		System.out.println("* Somme des diviseurs : " + sommeDe(lesDiv));
		System.out.println("* Qualité : " + qualite);

		if(!qualite.equals("PREMIER")){
			System.out.println("* Diviseurs de " + unEnt + ", autres que 1 et " + unEnt);
			int i = 1;
			while(i < lesDiv.size() - 1){
				System.out.println(" - " + lesDiv.get(i) + " est " + qualiteDe(lesDiv.get(i)));
				i++;
			}
		}
	}
}
	
	