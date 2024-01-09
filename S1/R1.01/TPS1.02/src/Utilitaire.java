import java.util.ArrayList;

public class Utilitaire {
	public static int triBulle_O (ArrayList<Integer> vInt) {
		// { vInt quelconque } =>
		// { * vInt a été trié par la méthode du TRI A BULLES AMELIORE
		// * résultat = nombre de comparaisons entre deux éléments de vInt }
		int i = 0, j;
		boolean aDeplace = true;
		int temp;
		int nbComparaisons = 0;

		while(aDeplace){	// Si aucun element n'est deplace la liste est triee
			aDeplace = false;
			j = vInt.size()-1;

			while(j > i){
				if(vInt.get(j) < vInt.get(j-1)){
					temp = vInt.get(j);
					vInt.set(j, vInt.get(j-1));
					vInt.set(j-1, temp);
					aDeplace = true;
				}
				nbComparaisons++;	// On a fait une comparaison avec le if

				j--;
			}

			i++;
		}

		return nbComparaisons;
	}

	public static int triInsert_O(ArrayList<Integer> vInt) {
		// { vInt quelconque } =>
		// { * vInt a été trié par la méthode du TRI PAR INSERTION
		// * résultat = nombre de comparaisons entre deux éléments de vInt }
		int i = 1, j;
		int temp;
		int nbComparaisons = 0;

		while(i < vInt.size()){
			
			temp = vInt.get(i);
			j = i; 
			while(j > 0 && temp < vInt.get(j-1)){
				vInt.set(j, vInt.get(j-1));
				j--;
				nbComparaisons++;	// On fait une comparaison a chaque iteration de la boucle
			}

			if(j > 0){	// On fait une comparaison ssi j > 0 est vrai
				nbComparaisons++;
			}

			vInt.set(j, temp);

			i++;
		}

		return nbComparaisons;
	}

	public static int triSelect_O (ArrayList<Integer> vInt) {
		// { vInt quelconque } =>
		// { * vInt a été trié par la méthode du TRI PAR SELECTION
		// * résultat = nombre de comparaisons entre deux éléments de vInt }
		int i = 0, j;
		int min, iMin;
		int temp;
		int nbComparaisons = 0;

		while(i < vInt.size()){
			iMin = i;
			min = vInt.get(i);
			j = i+1;

			while(j < vInt.size()){
				if(vInt.get(j) < min){
					iMin = j;
					min = vInt.get(j);
				}
				nbComparaisons++;
				j++;
			}

			if(i != iMin){
				temp = vInt.get(i);
				vInt.set(i, vInt.get(iMin));
				vInt.set(iMin, temp);
			}

			i++;
		}

		return nbComparaisons;
	}

	public static ArrayList<Integer> genVectSansDoublons(int n) {
		// { } =>
		// { résultat = vecteur de n entiers, sans doublons, dont les valeurs
		// sont choisies aléatoirement dans [0..2*n] }
		ArrayList<Integer> vInt = new ArrayList<>();
		int rng;
		
		while(vInt.size() < n){
			rng = (int)(Math.random()*(n*2+1));

			if(vInt.indexOf(rng) == -1){
				vInt.add(rng);
			}
		}

		return vInt;
	}

	public static PaireResCompteur<Integer> rechSeqIt_O(ArrayList<Integer> vInt, int unInt) {
		// { vInt non vide, trié } =>
		// { résultat = variable de type PaireResCompteur avec :
		// res = * indice de la 1ère occurrence de unInt dans vInt
		// * -1 si non trouvé
		// compteur = nombre de comparaisons entre unInt
		// et un élément de vInt }
		int i = 0;
		int nbComparaisons = 0;

		while(i < vInt.size() && unInt > vInt.get(i)){
			nbComparaisons++;	// On fait une comparaison à chaque iteration
			i++;
		}

		if(i < vInt.size()){
			nbComparaisons++;	// On vérifie la sortie de boucle
		}

		nbComparaisons++;

		if(unInt == vInt.get(i)){
			return new PaireResCompteur<Integer>(i, nbComparaisons);
		}
		else{
			return new PaireResCompteur<Integer>(-1, nbComparaisons);
		}
	}

	public static PaireResCompteur<Integer> rechDichoIt_O(ArrayList<Integer> vInt, int unInt) {
		// { vInt non vide, trié } =>
		// { résultat = variable de type PaireResCompteur avec :
		// res = * indice de la 1ère occurrence de unInt dans vInt
		// * -1 si non trouvé
		// compteur = nombre de comparaisons effectuées entre unInt
		// et un élément de vInt }
		int nbComparaisons = 0;
		if(!(vInt.size() <= 0)){
			nbComparaisons++;	// On vérifie la condition du if
		}
		if(vInt.size() <= 0 || vInt.get(vInt.size()-1) < unInt){
			return new PaireResCompteur<Integer>(-1, nbComparaisons);
		}
		else{
			int inf = 0;
			int sup = vInt.size()-1;
			int m;

			while(inf < sup){
				m = (inf+sup)/2;

				if(unInt <= vInt.get(m)){
					sup = m;
				}
				else{
					inf = m+1;
				}

				nbComparaisons++;	// On ajoute la comparaison du if
			}

			nbComparaisons++;	// On ajoute la comparaison du if de renvoi

			if(unInt == vInt.get(inf)){
				return new PaireResCompteur<Integer>(inf, nbComparaisons);
			}
			else{
				return new PaireResCompteur<Integer>(-1, nbComparaisons);
			}
		}
	}

	public static PaireResCompteur<Integer> rechDichoRec_O(ArrayList<Integer> vInt, int unInt) {
		// { vInt non vide, trié } =>
		// { résultat = variable de type PaireResCompteur avec :
		// res = * indice de la 1ère occurrence de unInt dans vInt
		// * -1 si non trouvé
		// compteur = nombre de comparaisons effectuées entre unInt
		// et un élément de vInt }
		if(vInt.get(vInt.size()-1) < unInt){
			return new PaireResCompteur<Integer>(-1, 1);
		}
		else{
			PaireResCompteur<Integer> temp = rechDichoRec_O_wk(vInt, unInt, 0, vInt.size()-1);
			return new PaireResCompteur<Integer>(temp.getRes(), temp.getCompteur() + 1);
		}
	}

	public static PaireResCompteur<Integer> rechDichoRec_O_wk(ArrayList<Integer> vInt, int unInt, int inf, int sup) {
		// { 0<=inf<=sup<=vInt.size()-1, vInt[inf..sup] non vide et trié } =>
		// { résultat = variable de type PaireResCompteur avec :
		// res = * inf (ou sup) si inf=sup et unInt trouvé à l'indice inf
		// * -1 si non trouvé
		// compteur = nombre de comparaisons effectuées... }
		if(inf == sup){
			if(vInt.get(inf) == unInt){
				return new PaireResCompteur<Integer>(inf, 1);
			}
			else{
				return new PaireResCompteur<Integer>(-1, 1);
			}
		}
		else{
			int m = (inf+sup)/2;
			PaireResCompteur<Integer> temp;

			if(unInt <= vInt.get(m)){
				temp = rechDichoRec_O_wk(vInt, unInt, inf, m);
			}
			else{
				temp = rechDichoRec_O_wk(vInt, unInt, m+1, sup);
			}

			return new PaireResCompteur<Integer>(temp.getRes(), temp.getCompteur() + 1);
		}
	}

	public static int triFusion_O(ArrayList<Integer> vInt, int inf, int sup) {
		// { 0<=inf<=sup<vInt.size(), vInt[inf..sup] quelconque } =>
		// { * vInt[inf..sup] a été trié
		// * résultat = nombre de comparaisons entre 2 éléments de vInt[inf..sup] }
		if (inf < sup) {
			int m = (inf + sup) / 2;
			int nbComparaisons = triFusion_O(vInt, inf, m); // appel récursif sur tranche gauche
			nbComparaisons += triFusion_O(vInt, m + 1, sup); // appel récursif sur tranche droite
			return nbComparaisons + fusionTabGTabD_O(vInt, inf, m, sup); // appel du worker : tri de inf à sup
		}
		else{
			return 0;
		}
	}

	public static int fusionTabGTabD_O(ArrayList<Integer> vInt, int inf, int m, int sup) {
		// { 0<=inf<=sup<vInt.size(), m=(inf+sup)/2,
		// vInt[inf..m] trié, vInt[m+1..sup] trié } =>
		// { vInt[inf..sup] a été trié
		// résultat = nombre de comparaisons entre un élément de vInt[inf..m]
		// et un élément de vInt[m+1..sup] }
		ArrayList<Integer> vTemp = new ArrayList<>();
		int iGauche = inf;
		int iDroite = m+1;
		int nbComparaisons = 0;

		while(iGauche <= m && iDroite <= sup){
			if(vInt.get(iGauche) < vInt.get(iDroite)){
				vTemp.add(vInt.get(iGauche));
				iGauche++;
			}
			else{
				vTemp.add(vInt.get(iDroite));
				iDroite++;
			}
			nbComparaisons++;
		}
		
		while(iGauche <= m){
			vTemp.add(vInt.get(iGauche));
			iGauche++;
		}

		while(iDroite <= sup){
			vTemp.add(vInt.get(iDroite));
			iDroite++;
		}

		int i = inf;

		while(i <= sup){
			vInt.set(i, vTemp.get(i-inf));
			i++;
		}

		return nbComparaisons;
	}
}