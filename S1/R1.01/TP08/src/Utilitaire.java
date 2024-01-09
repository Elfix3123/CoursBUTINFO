import java.util.ArrayList;

public class Utilitaire {
	public static Pays plusGrandPaysIter(ArrayList<Pays> vPays) {
		// { vPays non vide } =>
		// { résultat = élément de vPays ayant la plus grande superficie }
		int i = 1;
		Pays paysMax = vPays.get(0);

		while(i < vPays.size()){
			if(paysMax.getSuperficie() < vPays.get(i).getSuperficie()){
				paysMax = vPays.get(i);
			}

			i++;
		}

		return paysMax;
	}

	public static Pays plusGrandPaysDPR(ArrayList<Pays> vPays) {
		// { vPays non vide } =>
		// { résultat = élément de vPays ayant la plus grande superficie }
		return maxPaysDPRWorker(vPays, 0, vPays.size()-1);
	}

	private static Pays maxPaysDPRWorker(ArrayList<Pays> vPays, int inf, int sup) {
		// { vPays non vide, 0<=inf<=sup<vPays.size() } =>
		// { résultat = élément de plus grande superficie dans vPays[inf..sup] }
		if(inf == sup){	// Cas trivial, le min d'une liste d'un élément
			return vPays.get(inf);
		}
		else{	// Cas non trivial, on appelle récursivement le worker
			Pays grandGauche = maxPaysDPRWorker(vPays, inf, (inf+sup)/2);
			Pays grandDroite = maxPaysDPRWorker(vPays, (inf+sup)/2+1, sup);
			
			if(grandGauche.getSuperficie() > grandDroite.getSuperficie()){
				return grandGauche;
			}
			else{
				return grandDroite;
			}
		}
	}

	public static int indMinPopIter(ArrayList<Pays> vPays) {
		// { vPays non vide } =>
		// { résultat = indice dans vPays de l'élément de population la plus faible }
		int i = 1;

		int imin = 0;
		Pays paysMin = vPays.get(0);

		while(i < vPays.size()){
			if(paysMin.getPopulation() > vPays.get(i).getPopulation()){
				imin = i;
				paysMin = vPays.get(i);
			}

			i++;
		}

		return imin;
	}

	public static int indMinPopDPR(ArrayList<Pays> vPays) {
		// { vPays non vide } =>
		// { résultat = indice dans vPays de l'élément de population la plus faible }
		return indMinPopDPRWorker(vPays, 0, vPays.size()-1);
	}

	private static int indMinPopDPRWorker(ArrayList<Pays> vPays, int inf, int sup) {
		// { vPays non vide, 0<=inf<=sup<vPays.size() } =>
		// { résultat = indice dans vPay[inf..sup] de l'élément de population
		// la plus faible }
		if(inf == sup){	// Cas trivial, le min d'une liste d'un élément
			return inf;
		}
		else{	// Cas non trivial, on appelle récursivement le worker
			int petitGauche = indMinPopDPRWorker(vPays, inf, (inf+sup)/2);
			int petitDroite = indMinPopDPRWorker(vPays, (inf+sup)/2+1, sup);
			
			if(vPays.get(petitGauche).getPopulation() < vPays.get(petitDroite).getPopulation() ){
				return petitGauche;
			}
			else{
				return petitDroite;
			}
		}
	}

	public static ArrayList<Pays> triBulleContNom(ArrayList<Pays> vPays) {
		// { } => { résultat = vecteur contenant les éléments de vPays,
		// triés selon l'ORDRE(continent, nom) }
		// ALGORITHME : tri à bulles amélioré
		int i = 0;
		int j;
		Pays temp;
		boolean onAPermute = true;
		ArrayList<Pays> vPaysTrie = new ArrayList<>(vPays);

		while(onAPermute){
			onAPermute = false;
			j = vPaysTrie.size()-1;

			while(j > i){
				if(vPaysTrie.get(j).compareTo(vPaysTrie.get(j-1)) < 0){
					temp = vPaysTrie.get(j);
					vPaysTrie.set(j,vPaysTrie.get(j-1));
					vPaysTrie.set(j-1, temp);
					onAPermute = true;
				}

				j--;
			}

			i++;
		}

		return vPaysTrie;
	}

	public static boolean verifTriContNom(ArrayList<Pays> vPays) {
		// { } => { résultat = vrai si vPays trié selon l'ORDRE(continent, nom) }
		int i = 0;

		while(i < vPays.size()-1 && vPays.get(i).compareTo(vPays.get(i+1)) < 0){
			i++;
		}

		return i == vPays.size()-1;	
	}

	public static int indDichoIter(ArrayList<Pays> vPays, String contP, String nomP) {
		// { vPays trié selon l'ORDRE(continent, nom) } =>
		// { résultat = * indice dans vPays du pays de continent contP et de nom nomP,
		// si trouvé
		// * -1 si non trouvé }
		Pays paysComparable = new Pays(nomP, contP, -1, -1);
		if(vPays.size() <= 0 || paysComparable.compareTo(vPays.get(vPays.size()-1)) > 0){
			return -1;
		}
		else{
			int inf = 0;
			int sup = vPays.size()-1;
			int m;

			while(inf < sup){
				m = (inf+sup)/2;

				if(paysComparable.compareTo(vPays.get(m)) <= 0){
					sup = m;
				}
				else{
					inf = m+1;
				}
			}
			if(paysComparable.compareTo(vPays.get(inf)) == 0){
				return inf;
			}
			else{
				return -1;
			}
		}
	}

	public static int indDichoRec(ArrayList<Pays> vPays, String contP, String nomP) {
		// { vPays trié selon l'ORDRE(continent, nom) } =>
		// { résultat = * indice dans vPays du pays de continent contP et de nom nomP,
		// si trouvé
		// * -1 si non trouvé }
		Pays paysComparable = new Pays(nomP, contP, -1, -1);
		if(vPays.size() <= 0 || paysComparable.compareTo(vPays.get(vPays.size()-1)) > 0){
			return -1;
		}
		else{
			return indDichoWorker(vPays, contP, nomP, 0, vPays.size()-1);
		}
	}

	private static int indDichoWorker(ArrayList<Pays> vPays, String contP, String nomP, int inf, int sup) {
		// { vPays trié selon l'ORDRE(continent,nom), 0<=inf<=sup<vPays.size() } =>
		// { résultat = * indice dans vPays[inf..sup] du pays de continent contP et de
		// nom nomP, si trouvé
		// * -1 si non trouvé }
		if(inf == sup){
			return inf;
		}
		else{
			Pays paysComparable = new Pays(nomP, contP, -1, -1);
			int m = (inf+sup)/2;
			if(paysComparable.compareTo(vPays.get(m)) <= 0){
				return indDichoWorker(vPays, contP, nomP, inf, m);
			}
			else{
				return indDichoWorker(vPays, contP, nomP, m+1, sup);
			}
		}
	}

	public static int nbPaysDeContInfNbHabIter(ArrayList<Pays> vPays, String unCont, int popMax) {
		// { vPays trié selon l'ORDRE(continent, nom), popMax > 0 } =>
		// { résultat = nombre d'éléments de vPays de continent unCont
		// et de population < popMax }
		int i = 0;
		int nbPays = 0;

		while(i < vPays.size() && vPays.get(i).getContinent().compareTo(unCont) != 0){
			i++;
		}

		while(i < vPays.size() && vPays.get(i).getContinent().compareTo(unCont) == 0){
			if(vPays.get(i).getPopulation() < popMax){
				nbPays++;
			}

			i++;
		}

		return nbPays;
	}

	public static int nbPaysDeContInfNbHabRec(ArrayList<Pays> vPays, String unCont, int popMax) {
		// { vPays trié selon l'ORDRE(continent, nom), popMax > 0 } =>
		// { résultat = nombre d'éléments de vPays de continent unCont
		// et de population < popMax }
		return nbPaysDeContInfNbHabWorker(vPays, unCont, popMax, 0);
	}

	private static int nbPaysDeContInfNbHabWorker(ArrayList<Pays> vPays, String unCont, int popMax, int ind) {
		// { vPays[ind..vPays.size()-1] trié selon l'ORDRE(continent, nom),
		// 0<=ind<vPays.size(), popMax > 0 } =>
		// { résultat = nombre d'éléments de vPays[ind..vPays.size()-1]
		// de continent unCont et de population < popMax }
		if(ind == vPays.size()){
			return 0;
		}
		else{
			if(vPays.get(ind).getContinent().compareTo(unCont) == 0 && vPays.get(ind).getPopulation() < popMax){
				return nbPaysDeContInfNbHabWorker(vPays, unCont, popMax, ind+1) + 1;
			}
			else{
				return nbPaysDeContInfNbHabWorker(vPays, unCont, popMax, ind+1);
			}
		}
	}

	public static void triFusion(ArrayList<Pays> vPays, int inf, int sup) {
		// { vPays[inf..sup] non vide } => { vPays[inf..sup] trié }
		if (inf < sup) {
			int m = (inf + sup) / 2;
			triFusion(vPays, inf, m); // appel récursif sur tranche gauche
			triFusion(vPays, m + 1, sup); // appel récursif sur tranche droite
			fusionTabGTabD(vPays, inf, m, sup); // appel du worker : tri de inf à sup
		}
	}

	public static void fusionTabGTabD(ArrayList<Pays> vPays, int inf, int m, int sup) {
		// { inf <= sup, m = (inf+sup)/2, vPays[inf..m] trié, vPays[m+1..sup] trié }
		// => { vPays[inf..sup] trié }
		ArrayList<Pays> vTemp = new ArrayList<>();
		int iGauche = inf;
		int iDroite = m+1;

		while(iGauche <= m && iDroite <= sup){
			if(vPays.get(iGauche).compareTo(vPays.get(iDroite)) < 0){
				vTemp.add(vPays.get(iGauche));
				iGauche++;
			}
			else{
				vTemp.add(vPays.get(iDroite));
				iDroite++;
			}
		}
		
		while(iGauche <= m){
			vTemp.add(vPays.get(iGauche));
			iGauche++;
		}

		while(iDroite <= sup){
			vTemp.add(vPays.get(iDroite));
			iDroite++;
		}

		int i = inf;

		while(i <= sup){
			vPays.set(i, vTemp.get(i-inf));
			i++;
		}
	}
}