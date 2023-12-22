import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Algos {
	public static int saisieEntMinMax(Scanner lecteur, int min, int max) {
		// { } => { résultat = un entier de l'intervalle [min..max] saisi par l'utilisateur }
		System.out.print("Entrez un entier compris entre " + min + " et " + max + " : ");
		int entree = lecteur.nextInt();
		lecteur.nextLine();

		while (min > entree || entree > max) {
			System.out.println("-> Entrée invalide !");
			System.out.print("Entrez un entier compris entre " + min + " et " + max + " : ");
			entree = lecteur.nextInt();
			lecteur.nextLine();
		}

		return entree;
	}

	public static int saisieEntSup(Scanner lecteur, int val) {
		// { } => { résultat = un entier supérieur à val, saisi par l'utilisateur }
		// L'exception InputMismatchException qui sera déclenchée si l'utilisateur
		// saisit autre chose qu'un entier est gérée
		try {
			System.out.print("Entrez un entier supèrieur à " + val + " : ");
			int entree = lecteur.nextInt();
			lecteur.nextLine();

			while (val >= entree) {
				System.out.println("-> Entrée invalide !");
				System.out.print("Entrez un entier supèrieur à " + val + " : ");
				entree = lecteur.nextInt();
				lecteur.nextLine();
			}

			return entree;
		}
		catch (InputMismatchException e){
			lecteur.nextLine();
			System.out.println("-> Entrée invalide !");
			return saisieEntSup(lecteur, val);
		}
	}

	public static String saisieChaineDeV(Scanner lecteur, ArrayList<String> vString) {
		// { vString non vide }
		// => { résultat = un élément de vString, saisi par l'utilisateur }
		System.out.print("Entrez un élémént de " + vString + " : ");
		String entree = lecteur.nextLine();

		int i = 0;
		boolean nonPresent = true;
		while (nonPresent) {
			nonPresent = false;

			while (i < vString.size() && vString.get(i).compareTo(entree) != 0) {
				i++;
			}
			
			if (i == vString.size()) {
				nonPresent = true;
				System.out.println("-> Entrée invalide !");
				System.out.print("Entrez un élémént de " + vString + " : ");
				entree = lecteur.nextLine();
				i = 0;
			}
		}

		return entree;
	}

	public static int maximum(ArrayList<Integer> vInt) {
		// { vInt non vide } => { résultat = plus grand entier dans vInt }
		int i = 1;
		int lePlusGrand = vInt.get(0);

		while (i < vInt.size()) {
			if (lePlusGrand < vInt.get(i)) {
				lePlusGrand = vInt.get(i);
			}
			
			i++;
		}

		return lePlusGrand;
	}

	public static float moyenne(ArrayList<Integer> vInt) throws ExceptionMoyImpossible {
		// { } =>
		// { * si vInt est vide, l'exception ExceptionMoyImpossible est levée
		// avec un message expliquant le problème
		// * sinon, la moyenne des éléments de vInt est retournée }
		if (vInt.size() == 0) {
			throw new ExceptionMoyImpossible("Calcul de la moyenne d'un vecteur vide impossible");
		}
		else {
			int i = 0;
			int somme = 0;
			while (i < vInt.size()) {
				somme += vInt.get(i);
				i++;
			}
			return ((float)somme)/vInt.size();
		}
	}

	public static String minOrdreLG(ArrayList<String> vString) {
		// { vString non vide } =>
		// { résultat = plus petite chaîne de vString selon l'ordre lexicographique }
		int i = 1;
		String lePlusPetit = vString.get(0);

		while (i < vString.size()) {
			if (vString.get(i).compareTo(lePlusPetit) > 0) {
				lePlusPetit = vString.get(i);
			}
			
			i++;
		}

		return lePlusPetit;
	}

	public static int somme(ArrayList<Integer> vInt) {
		// { vInt non vide } => { résultat = somme des éléments de vInt }
		return somme_wk(vInt, 0);
	}

	private static int somme_wk(ArrayList<Integer> vInt, int dep) {
		if (vInt.size() == dep) {
			return 0;
		}
		else {
			return vInt.get(dep) + somme_wk(vInt, dep+1);
		}
	}

	public static int nbEntDeVal(ListeTrieeC<Integer> lIntC, int val) {
		// { } => { résultat = nombre d'entiers supérieurs à unEnt dans lIntC }
		return nbEntDeVal_wk(lIntC.getTete(), val);
	}

	private static int nbEntDeVal_wk(Cellule<Integer> cellCour, int unEnt) {
		if (cellCour == null) {
			return 0;
		}
		else {
			if (cellCour.getInfo() > unEnt) {
				return 1 + nbEntDeVal_wk(cellCour.getCelluleSuivante(), unEnt);
			}
			else {
				return nbEntDeVal_wk(cellCour.getCelluleSuivante(), unEnt);
			}
		}
	}

	public static int nbJetonsSup3(ArrayList<Jeton> vJetons) {
		// { vJetons non vide } =>
		// { résultat = nombre d'éléments de vJetons dont la valeur est supérieure à 3 }
		int i = 0;
		int totalJetons = 0;

		while (i < vJetons.size()) {
			if (vJetons.get(i).getValeur() > 3) {
				totalJetons ++;
			}
			i++;
		}

		return totalJetons;
	}

	public static boolean existValSeq_it(ArrayList<Integer> vInt, int val) {
		// { } => { résultat = vrai si val est un élément de vInt }
		int i = 0;

		while (i < vInt.size() && vInt.get(i) != val) {
			i++;
		}

		return !(i == vInt.size());
	}

	public static boolean existValSeq_rec(ArrayList<Integer> vInt, int val) {
		// { } => { résultat = vrai si val est un élément de vInt }
		return existValSeq_rec_wk(vInt, val, 0);
	}

	private static boolean existValSeq_rec_wk(ArrayList<Integer> vInt, int val, int indice) {
		// { 0 <= indice < vInt.size() } =>
		// { résultat = vrai si val est un élément de vInt[indice..vInt.size()-1] }
		if (vInt.size() == indice) {
			return false;
		}
		else {
			return vInt.get(indice) == val || existValSeq_rec_wk(vInt, val, indice+1);
		}
	}

	public static int rechIndDicho(ArrayList<Integer> vInt, int val) {
		// { vInt trié } =>
		// { résultat = indice de la 1ère occurrence de val dans vInt si trouvé, -1 sinon }
		if (vInt.size() == 0 || vInt.get(vInt.size()-1) < val) {
			return -1;
		}
		else {
			int min = 0;
			int max = vInt.size()-1;
			int m;

			while (min < max) {
				m = (min+max)/2;

				if (val <= vInt.get(m)) {
					max = m;
				}
				else {
					min = m+1;
				}
			}

			if (vInt.get(min) == val) {
				return min;
			}
			else {
				return -1;
			}
		}
	}

	public static int rechPos(ListeTrieeC<String> lString, String uneChaine) {
		// { lString trié } =>
		// { résultat = position de la 1ère occurrence de uneChaine dans lString,
		// 0 si non trouvée }
		Cellule<String> cellCour = lString.getTete();
		int i = 1;

		while (cellCour != null && cellCour.getInfo().compareTo(uneChaine) < 0) {
			cellCour = cellCour.getCelluleSuivante();
			i++;
		}

		if (cellCour == null) {
			return 0;
		}
		else {
			return i; 
		}
	}

	public static void triBulle(ArrayList<Integer> vInt) {
		// { } => { vInt a été trié par la méthode du tri à bulles amélioré }
		int i = 0;
		int j;
		int temp;
		boolean onAPermute = true;

		while (onAPermute) {
			onAPermute = false;
			j = vInt.size()-1;

			while (j > i) {
				if (vInt.get(j) < vInt.get(j-1)) {
					temp = vInt.get(j);
					vInt.set(j, vInt.get(j-1));
					vInt.set(j-1, temp);
					onAPermute = true;
				}
				j--;
			}

			i++;
		}
	}

	public static ArrayList<Jeton> vJetonTrie(ArrayList<Jeton> vJetons) {
		// { vJetons non vide } =>
		// { résultat = vecteur de Jeton trié dont les éléments sont ceux de vJetons }
		// Méthode utilisée pour le tri : tri par insertion
		ArrayList<Jeton> vJetonsTrie = new ArrayList<>(vJetons);
		int i = 0;
		int j;
		Jeton min;
		int iMin;
		Jeton temp;

		while (i < vJetonsTrie.size()) {
			j = i+1;
			iMin = i;
			min = vJetonsTrie.get(i);

			while (j < vJetonsTrie.size()) {
				if (vJetonsTrie.get(j).compareTo(min) < 0) {
					min = vJetonsTrie.get(j);
					iMin = j;
				}
				j++;
			}

			if (iMin != i) {
				temp = vJetonsTrie.get(i);
				vJetonsTrie.set(i, vJetonsTrie.get(iMin));
				vJetonsTrie.set(iMin, temp);
			}

			i++;
		}

		return vJetonsTrie;
	}

	public static boolean veriftri(ArrayList<Jeton> vJeton) {
		// { vJeton non vide }=> {
		// { résultat = vrai si vJeton trié selon l'ordre naturel de la classe Jeton, faux sinon }
		int i = 1;

		while (i < vJeton.size() && vJeton.get(i).compareTo(vJeton.get(i-1)) >= 0) {
			i++;
		}

		return i == vJeton.size();
	}
}
