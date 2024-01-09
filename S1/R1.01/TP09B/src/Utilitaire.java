import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {
	public static ListeChainee<PaysDeCont> countries(ArrayList<Pays> mondeT, String cont) {
		// { mondeT non vide, trié selon l'ORDRE (continent, nom) } =>
		// { résultat = liste chainée des pays du continent cont, TRIÉE par nom }
		ListeChainee<PaysDeCont> nouveauMonde = new ListeChainee<>();
		int i = mondeT.size()-1;

		while(i>=0 && mondeT.get(i).getContinent().compareTo(cont) != 0){
			i--;
		}

		while(i>=0 && mondeT.get(i).getContinent().compareTo(cont) == 0){
			nouveauMonde.insereTete(new PaysDeCont(mondeT.get(i).getNom(), mondeT.get(i).getPopulation(), mondeT.get(i).getSuperficie()));
			i--;
		}

		return nouveauMonde;
	}

	public static void affichePaysDeCont(ListeChainee<PaysDeCont> listePdeC) {
		// { listePdeC non vide } =>
		// { l'information portée par chaque celle de listePdeC a été affichée
		// ligne à ligne, précédée par sa position dans listePdeC }
		affichePaysDeCont_wk(1, listePdeC.getTete());
	}

	private static void affichePaysDeCont_wk(int pos, Cellule<PaysDeCont> cellCour) {
		if (cellCour != null) {
			System.out.println(pos + " - " + cellCour.getInfo());
			affichePaysDeCont_wk(pos + 1, cellCour.getCelluleSuivante());
		}
	}

	public static int indString(Scanner lecteur, ArrayList<String> vString) {
		// { vString non vide, trié par ordre strictement croissant } =>
		// { résultat = indice dans vString, d'une chaîne saisie par l'utilisateur }
		// La saisie a été répétée tant que la chaîne saisie n'est pas dans vString
		System.out.print("Entrer un nom de continent, choisi parmi : " + vString + " : ");
		String entree = lecteur.nextLine();
		
		while(vString.indexOf(entree) == -1){
			System.out.println("--> Saisie invalide, recommencez...");
			System.out.print("Entrer un nom de continent, choisi parmi : " + vString + " : ");
			entree = lecteur.nextLine();
		}

		return vString.indexOf(entree);
	}

	public static void contExtremes(ArrayList<String> vCont, ArrayList<ListeChainee<PaysDeCont>>vListesPdeC) {
		// { * vCont, trié et non vide : vecteur des continents du monde
		// * vListesPdeC, non vide : vecteur des listes de pays de ces continents
		// dans l'ordre des continents de vCont } =>
		// { le nom et le nombre de pays du continent qui a le plus de pays est affiché,
		// ainsi que le nom et le nombre de pays du continent qui a le moins de pays }
		int min = vListesPdeC.get(0).getLongueur();
		int imin = 0;
		int max = vListesPdeC.get(0).getLongueur();
		int imax = 0;
		int i = 1;

		while (i < vListesPdeC.size()) {
			if (min > vListesPdeC.get(i).getLongueur()) {
				min = vListesPdeC.get(i).getLongueur();
				imin = i;
			}
			else if (max < vListesPdeC.get(i).getLongueur()) {
				max = vListesPdeC.get(i).getLongueur();
				imax = i;
			}

			i++;
		}

		System.out.println("Continent comptant le plus de pays : " + vCont.get(imax) + " (" + max + " pays)");
		System.out.println("Continent comptant le moins de pays : " + vCont.get(imin) + " (" + min + " pays)");
	}

	public static ListeChainee<String> listeNomsPdeC (String unCont, ListeChainee<PaysDeCont> listePDeC) {
		// { * unCont est le nom d'un continent
		// * listePdeC contient les pays de unCont, triés par nom } =>
		// { résultat = liste triée dont chaque élément est une chaîne construite par
		// concaténation de unCont entre parenthèses, aux nom d'un pays
		// EXEMPLE : "Andorre (Europe)" }
		ListeChainee<String> lesPairesALEnvers = new ListeChainee<>();
		Cellule<PaysDeCont> cellulePays = listePDeC.getTete();

		while (cellulePays != null) {
			lesPairesALEnvers.insereTete(cellulePays.getInfo().getNom() + " (" + unCont + ")");
			cellulePays = cellulePays.getCelluleSuivante();
		}

		ListeChainee<String> lesPays = new ListeChainee<>();
		Cellule<String> celluleString = lesPairesALEnvers.getTete();

		while (celluleString != null) {
			lesPays.insereTete(celluleString.getInfo());
			celluleString = celluleString.getCelluleSuivante();
		}

		return lesPays;
	}

	public static int posInsert(ListeChainee<String> uneListe, String uneChaine) {
		// { uneListe triée, éventuellement vide } =>
		// { résultat = rang que devrait occuper uneChaine lors de son insertion dans
		// uneListe, pour que le tri soit respecté }
		int i = 1;
		Cellule<String> celluleActive = uneListe.getTete();

		while (celluleActive != null && celluleActive.getInfo().compareTo(uneChaine) < 0) {
			celluleActive = celluleActive.getCelluleSuivante();
			i++;
		}

		return i;
	}

	public static ListeChainee<String> listeNomsPaysDuMonde(ArrayList<String> vCont, ArrayList<ListeChainee<PaysDeCont>> vListesPdeC) {
		// { * vCont, trié et non vide : vecteur des continents du monde
		// * vListesPdeC, non vide : vecteur des listes de pays de ces continents } =>
		// { résultat = liste triée dont dont chaque élément est le nom d'un pays du
		// monde, concaténé au nom de son continent entre parenthèses }
		ListeChainee<String> listeRes = new ListeChainee<>();
		ListeChainee<String> lesNomsPdeC;
		Cellule<String> celluleActive;
		int indiceRes;
		int i = 0;

		while (i < vCont.size()) {
			lesNomsPdeC = listeNomsPdeC(vCont.get(i), vListesPdeC.get(i));
			celluleActive = lesNomsPdeC.getTete();

			while (celluleActive != null) {
				indiceRes = posInsert(listeRes, celluleActive.getInfo());
				listeRes.insereAtPosit(indiceRes, celluleActive.getInfo());
				celluleActive = celluleActive.getCelluleSuivante();
			}

			i++;
		}

		return listeRes;
	}

	public static void lexiquePaysDuMonde(ListeChainee<String> lesPays) {
		// { lesPays triée, contient les noms des pays du monde, concaténés
		// au nom de leur continent entre parenthèses } =>
		// { les éléments de lesPays ont été affichés par lots de pays de même initiale,
		// précédés de l'affichage de cette initiale }
		Cellule<String> celluleActive = lesPays.getTete();
		char initialeActive = celluleActive.getInfo().charAt(0);

		while (celluleActive != null) {
			if (initialeActive != celluleActive.getInfo().charAt(0)) {
				initialeActive = celluleActive.getInfo().charAt(0);
				System.out.println(initialeActive);
			}
			System.out.println(celluleActive.getInfo());
			celluleActive = celluleActive.getCelluleSuivante();
		}
	}
}
