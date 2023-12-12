import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilitaire {
	public static int getInt_IME(Scanner lecteur) {
		// { } => {résultat = un entier saisi par l'utilisateur }
		// L'EXCEPTION InputMismatchException EST GÉRÉE
		try{
			System.out.print("Entrez un entier : ");
			return lecteur.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Vous devez entrer un entier !");
			lecteur.nextLine();
			return getInt_IME(lecteur);
		}
	}

	public static int getIntMinMax_IME(Scanner lecteur, int min, int max) {
		// { min <= max } =>
		// { résultat = un entier compris entre min et max, saisi par l'utilisateur }
		// L'EXCEPTION inputMismatchException EST GÉRÉE
		try{
			System.out.print("Entrez un entier compris entre " + min + " et " + max + " : ");
			int entree = lecteur.nextInt();
			lecteur.nextLine();
			while(entree < min || entree > max){
				System.out.print("Vous devez entrez un entier compris entre " + min + " et " + max + " ! ");
				entree = lecteur.nextInt();
				lecteur.nextLine();
			}
			return entree;
		}
		catch(InputMismatchException e){
			System.out.println("Vous devez entrer un entier !");
			lecteur.nextLine();
			return getIntMinMax_IME(lecteur, min, max);
		}
	}

	public static int getInt_NFE(Scanner lecteur) {
		// { } => {résultat = un entier saisi par l'utilisateur }
		// L'EXCEPTION NumberFormatException EST GÉRÉE
		try{
			System.out.print("Entrez un entier : ");
			return Integer.parseInt(lecteur.nextLine());
		}
		catch(NumberFormatException e){
			System.out.println("Vous devez entrer un entier !");
			return getInt_NFE(lecteur);
		}
	}

	public static float getFloat_NFE(Scanner lecteur) {
		// { } => { résultat = un réel saisi par l'utilisateur }
		// L'EXCEPTION NumberFormatException EST GÉRÉE
		try{
			System.out.print("Entrez un réel : ");
			return Float.parseFloat(lecteur.nextLine());
		}
		catch(NumberFormatException e){
			System.out.println("Vous devez entrer un réel !");
			return getFloat_NFE(lecteur);
		}
	}

	public static int sumIter(ListeChainee<Integer> listInt) {
		// { listInt non vide } =>
		// { résultat = somme des entiers portés par les cellules de listInt }
		int somme = 0;
		Cellule<Integer> celluleActive = listInt.getTete();

		while(celluleActive != null){
			somme += celluleActive.getInfo();
			celluleActive = celluleActive.getCelluleSuivante();
		}

		return somme;
	}

	public static int sumRec(ListeChainee<Integer> listInt) {
		// { listInt non vide } =>
		// { résultat = somme des entiers portés par les cellules de listInt }
		return sumRec_wk(listInt.getTete());
	}	

	private static int sumRec_wk(Cellule<Integer> cellCour) {
		// { } =>
		// { résultat = somme des entiers portés par les cellules d'une sous-liste
		// de tête cellCour }
		if(cellCour == null){
			return 0;
		}
		else{
			return cellCour.getInfo() + sumRec_wk(cellCour.getCelluleSuivante());
		}
	}

	public static int posFirstSup(ListeChainee<Integer> listInt, int unInt) {
		// { } => {résultat = rang de la première cellule de listInt portant
		// un entier supérieur à unInt, 0 si non trouvée }
		Cellule<Integer> celluleActive = listInt.getTete();
		int i = 1;

		while(celluleActive != null && celluleActive.getInfo() < unInt){
			celluleActive = celluleActive.getCelluleSuivante();
			i++;
		}

		if(celluleActive != null){
			return i;
		}
		else{
			return 0;
		}
	}

	public static boolean existIntRec(ListeChainee<Integer> listInt, int unInt) {
		// { } =>
		// { résultat = vrai si au moins une cellule de listInt porte l'info unInt }
		return existIntRec_wk(listInt.getTete(), unInt);
	}

	private static boolean existIntRec_wk(Cellule<Integer> cellCour, int unInt) {
		// { } => { résultat = vrai si au moins une cellule d'une sous-liste de tête
		// cellCour porte l'info unInt }
		if(cellCour == null){
			return false;
		}
		else{
			return cellCour.getInfo() == unInt || existIntRec_wk(cellCour.getCelluleSuivante(), unInt);
		}
	}

	public static int bigger(ListeChainee<Integer> listInt) {
		// { listInt non vide } =>
		// { résultat = plus grand entier porté par une cellule de listInt }
		Cellule<Integer> celluleActive = listInt.getTete().getCelluleSuivante();
		int lePlusGrand = listInt.getTete().getInfo();

		while(celluleActive != null){
			if (celluleActive.getInfo() > lePlusGrand) {
				lePlusGrand = celluleActive.getInfo();
			}

			celluleActive = celluleActive.getCelluleSuivante();
		}

		return lePlusGrand;
	}

	public static ListeChainee<Integer> subList(ListeChainee<Integer> listInt, int position) {
		// { * listInt non vide,
		// * position compris entre 1 et le nombre de cellules de listInt } =>
		// { résultat = une liste d'entiers contenant les cellules de listInt
		// à partir de position }
		ListeChainee<Integer> newList = new ListeChainee<>();
		Cellule<Integer> celluleActive = listInt.getTete();
		int i = 1;

		while (i < position) {
			celluleActive = celluleActive.getCelluleSuivante();
			i++;
		}

		while (celluleActive != null) {
			newList.insereTete(celluleActive.getInfo()); 
			celluleActive = celluleActive.getCelluleSuivante();
		}

		ListeChainee<Integer> newListRenverse = new ListeChainee<>();
		celluleActive = newList.getTete();

		while (celluleActive != null) {
			newListRenverse.insereTete(celluleActive.getInfo()); 
			celluleActive = celluleActive.getCelluleSuivante();
		}

		return newListRenverse;
	}

	public static int nbMult2(ListeChainee<Integer> listeInt) {
		// { } =>
		// { résultat = nombre d'entiers pairs portés par les cellules de listeInt }
		return nbMult2_wk(listeInt.getTete());
	}

	private static int nbMult2_wk(Cellule<Integer> cellCour) {
		// { } =>
		// { résultat = nombre d'entiers pairs portés par les cellules d'une sous-liste
		// de tête cellCour }
		if(cellCour == null){
			return 0;
		}
		else{
			int courantPair = 0;
			if(cellCour.getInfo() % 2 == 0){
				courantPair = 1;
			}
			return courantPair + nbMult2_wk(cellCour.getCelluleSuivante());
		}
	}
}
