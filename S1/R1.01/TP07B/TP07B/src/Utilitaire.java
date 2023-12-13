import java.util.ArrayList;

public class Utilitaire{
	public static boolean verifTri(ArrayList<Polar> vPolar) {
		// { } =>
		// { résultat = vrai si vPolar est trié par titre strictement croissant }
		int i = 0;

		while(i < vPolar.size()-1 && vPolar.get(i).compareTo(vPolar.get(i+1)) < 0){
			i++;
		}
		System.out.println(i);
		return i == vPolar.size();
	}

	public static int triSelectNbComp(ArrayList<Polar> vPolar) {
		// { } => { * vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI PAR SÉLECTION
		// * résultat = nombre de comparaisons effectuées
		// entre deux éléments de vPolar }
		int i = 0;
		int j;
		int iPolarMin;
		Polar temp;
		int comparaisons = 0;

		while(i < vPolar.size()-1){
			j = i + 1;
			Polar polarMin = vPolar.get(i);
			iPolarMin = i;

			while(j < vPolar.size()){
				if(vPolar.get(j).compareTo(polarMin) < 0){
					polarMin = vPolar.get(j);
					iPolarMin = j;
				}
				comparaisons++;
				j++;
			}

			if(iPolarMin != i){
				temp = vPolar.get(i);
				vPolar.set(i, vPolar.get(iPolarMin));
				vPolar.set(iPolarMin, temp);
			}
			i++;
		}

		return comparaisons;
	}

	public static void triBulle(ArrayList<Polar> vPolar) {
		// { } => { vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI À BULLES AMÉLIORÉ }
		int i = 0;
		int j;
		Polar temp;
		boolean onAPermute = true; 

		while(onAPermute){
			onAPermute = false;
			j = vPolar.size()-1;

			while(j > i){
				if(vPolar.get(j).compareTo(vPolar.get(j-1)) < 0){
					temp = vPolar.get(j);
					vPolar.set(j,vPolar.get(j-1));
					vPolar.set(j-1, temp);
					onAPermute = true;
				}

				j--;
			}

			i++;
		}
	}

	public static int triInsertionNbComp(ArrayList<Polar> vPolar) {
		// { } => { * vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI PAR INSERTION
		// * résultat = nombre de comparaisons effectuées
		// entre deux éléments de vPolar }
		int i = 1;
		int j;
		Polar temp;
		int comparaisons = 0;

		while(i < vPolar.size()){
			j = i;
			temp = vPolar.get(i);

			while(j > 0 && vPolar.get(j-1).compareTo(temp) > 0){
				if(j > 0){
					comparaisons++;
				}
				vPolar.set(j, vPolar.get(j-1));
				j--;
			}
			if(j > 0){
				comparaisons++;
			}

			vPolar.set(j, temp);

			i++;
		}

		return comparaisons;
	}

	public static void nbPolarAuteur(ArrayList<Polar> vPolar) {
		// { vPolar non vide, trié selon l'ORDRE(auteur, année) } =>
		// { le nombre de romans écrits par chaque auteur a été affiché
		// ligne à ligne, chaque ligne ayant la forme :
		// * Nombre de romans écrits par XXX : nbR
		// (nbR étant le nombre de romans de l'auteur de nom XXX} }
		int i = 0;
		int nbPolar = 0;

		while(i < vPolar.size()-1){
			nbPolar++;
			if(i+1 < vPolar.size() && vPolar.get(i).getAuteur().compareTo(vPolar.get(i+1).getAuteur()) != 0){
				System.out.println("* Nombre de romans écrits par " + vPolar.get(i).getAuteur() + " : " + nbPolar);
				nbPolar = 0;
			}
			i++;
		}
		System.out.println("* Nombre de romans écrits par " + vPolar.get(i).getAuteur() + " : " + nbPolar);
	}

	public static ArrayList<String> auteursDeAn(ArrayList<Polar> vPolar, int an) {
		// { vPolar non vide, trié selon l'ORDRE(auteur, annee) } =>
		// { résultat = vecteur contenant les noms des auteurs ayant écrit au
		// moins un roman l'année an }
		int i = 0;
		int j = 0;
		String auteurAAjouter;
		boolean ajout;
		ArrayList<String> lesAuteurs = new ArrayList<>();

		while(i < vPolar.size()){
			if(vPolar.get(i).getAnnee() == an){
				auteurAAjouter = vPolar.get(i).getAuteur();
				ajout = true;
				while(j < lesAuteurs.size()){
					if(lesAuteurs.get(j).compareTo(auteurAAjouter) == 0){
						ajout = false;
					}

					j++;
				}

				j = 0;
				
				if(ajout){
					lesAuteurs.add(vPolar.get(i).getAuteur());
				}
			}

			i++;
		}
		return lesAuteurs;
	}

	public static int rechPremIndSeq(ArrayList<Polar> vPolar, int an, String aut) {
		// { vPolar trié dans l'ordre (annee, auteur) } =>
		// { * s'il y a dans vPolar au moins un élément d'année an et d'auteur aut,
		// résultat = indice du premier de ces éléments
		// * sinon, résultat = -1 }
		// LA RECHERCHE EST SÉQUENTIELLE !!!
		int i = 0;
		Polar polarComparable = new Polar(an, aut, "polarComparable");

		while(i < vPolar.size() && (polarComparable.compareTo(vPolar.get(i)) > 0)){
			i++;
		}

		if(i < vPolar.size() && (polarComparable.compareTo(vPolar.get(i)) == 0)){
			return i;
		}
		else{
			return -1;
		}
	}

	public static int rechPremIndDicho(ArrayList<Polar> vPolar, int an, String aut) {
		// { vPolar trié dans l'ordre (annee, auteur) } =>
		// { * s'il y a dans vPolar au moins un élément d'année an et d'auteur aut,
		// résultat = indice du premier de ces éléments
		// * sinon, résultat = -1 }
		// LA RECHERCHE EST DICHOTOMIQUE !!!
		Polar polarComparable = new Polar(an, aut, "polarComparable");
		if(vPolar.size() <= 0 || polarComparable.compareTo(vPolar.get(vPolar.size()-1)) > 0){
			return -1;
		}
		else{
			int inf = 0;
			int sup = vPolar.size()-1;
			int m;

			while(inf < sup){
				m = (inf+sup)/2;

				if(polarComparable.compareTo(vPolar.get(m)) <= 0){
					sup = m;
				}
				else{
					inf = m+1;
				}
			}
			if(polarComparable.compareTo(vPolar.get(inf)) == 0){
				return inf;
			}
			else{
				return -1;
			}
		}
	}

	public static PaireResultatCompteur<Integer> rechSeqT_O(ArrayList<Polar> vPolar,
	int an, String aut) {
		// { vPolar trié selon l'ORDRE(auteur, annee) } =>
		// { * le premier élément de vPolar écrit par aut, l'année an a été cherché
		// à l'aide d'un algorithme de RECHERCHE SÉQUENTIELLE
		// * résultat = un objet de type PaireResCompteur où :
		// - l'attribut res est égal à l'indice dans vPolar du 1er élément d'auteur aut
		// et d'année an, si trouvé / -1 si pas trouvé
		// - l'attribut compteur est égal au nombre de comparaisons effectuées entre
		// un élément du vecteur et ce qui est cherché, pour produire res }
		int i = 0;
		Polar polarComparable = new Polar(an, aut, "polarComparable");
		int comparaisons = 0;

		while(i < vPolar.size() && (polarComparable.compareTo(vPolar.get(i)) > 0)){
			i++;
			if(i < vPolar.size()){
				comparaisons++;
			}
		}

		if(i < vPolar.size() && (polarComparable.compareTo(vPolar.get(i)) == 0)){
			if(i < vPolar.size()){
				comparaisons++;
			}
			return new PaireResultatCompteur<Integer>(i, comparaisons);
		}
		else{
			if(i < vPolar.size()){
				comparaisons++;
			}
			return new PaireResultatCompteur<Integer>(-1, comparaisons);
		}
	}

	public static PaireResultatCompteur<Integer> rechDicho_O(ArrayList<Polar> vPolar,
		int an, String aut) {
		// { vPolar trié selon l'ORDRE(auteur, annee) } =>
		// { * le premier élément de vPolar écrit par aut, l'année an a été cherché
		// à l'aide d'un algorithme de RECHERCHE DICHOTOMIQUE
		// * résultat = un objet de type PaireResCompteur dont :
		// - l'attribut res est égal à l'indice dans vPolar du 1er élément d'auteur aut
		// et d'année an, si trouvé / -1 si pas trouvé
		// - l'attribut compteur est égal au nombre de comparaisons effectuées entre
		// un élément du vecteur et ce qui est cherché, pour produire res }
		Polar polarComparable = new Polar(an, aut, "polarComparable");
		int comparaisons = 0;

		comparaisons++;
		if(vPolar.size() <= 0 || polarComparable.compareTo(vPolar.get(vPolar.size()-1)) > 0){
			if(!(vPolar.size() <= 0)){
			}
			return new PaireResultatCompteur<Integer>(-1, comparaisons);
		}
		else{
			int inf = 0;
			int sup = vPolar.size()-1;
			int m;

			while(inf < sup){
				m = (inf+sup)/2;

				if(polarComparable.compareTo(vPolar.get(m)) <= 0){
					sup = m;
				}
				else{
					inf = m+1;
				}
				comparaisons++;
			}

			comparaisons++;

			if(polarComparable.compareTo(vPolar.get(inf)) == 0){
				return new PaireResultatCompteur<Integer>(inf, comparaisons);
			}
			else{
				return new PaireResultatCompteur<Integer>(-1, comparaisons);
			}
		}
	}
}