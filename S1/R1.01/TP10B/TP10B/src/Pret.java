import java.util.ArrayList;

public class Pret {
	private int numPret;
	private ArrayList<Instrument> instrumentsPretes;

	// Constructeurs
	public Pret(int numPret, ArrayList<Instrument> instrumentsPretes){
		/*
			* Constructeur d'un Pret avec un nombre et un vecteur
			* d'instruments en paramètre
			*/
		this.numPret = numPret;
		this.instrumentsPretes = instrumentsPretes;
	}

	// Getters
	public int getnumPret(){
		/*
			* Getter de l'attribut numPret
			* 
			* @return numPret
			*/
		return this.numPret;
	}

	public ArrayList<Instrument> getinstrumentsPretes(){
		/*
			* Getter de l'attribut instrumentsPretes
			* 
			* @return instrumentsPretes
			*/
		return this.instrumentsPretes;
	}

	public void addTrieIns(Instrument unInstrument) {
		// { le vecteur instrumentsPretes de ce Pret est trié
		// et peut contenir plusieurs occurrences de unInstrument } =>
		// { unInstrument a été ajouté dans ce vecteur, en respect du tri }
		int i = 0;

		while(i < this.instrumentsPretes.size() && this.instrumentsPretes.get(i).compareTo(unInstrument) < 0){
			i++;
		}

		this.instrumentsPretes.add(i, unInstrument);
	}

	public void removeTrieIns(Instrument unInstrument) {
		// { le vecteur instrumentsPretes de ce Pret est trié
		// et contient au moins une occurrence de unInstrument } =>
		// { la première occurrence de unInstrument a été supprimée de ce vecteur }
		int i = 0;

		// On est certain de trouver
		while(this.instrumentsPretes.get(i).compareTo(unInstrument) < 0){
			i++;
		}

		if (this.instrumentsPretes.get(i).compareTo(unInstrument) == 0) {
			this.instrumentsPretes.remove(i);
		}
	}

	public int nbExemplaires(Instrument unInstrument) {
		// { le vecteur instrumentsPretes de ce Pret est trié et contient une
		// ou plusieurs occurrences de unInstrument }=>
		// { résultat = nombre d'occurrences de unInst dans instrumeentsPretes }
		int i = 0;

		while(this.instrumentsPretes.get(i).compareTo(unInstrument) < 0){
			i++;
		}

		int compteur = 0;

		while(this.instrumentsPretes.get(i).compareTo(unInstrument) == 0){
			compteur++;
			i++;
		}

		return compteur;
	}

	public boolean isSolde() {
		// { } =>
		// { résultat = vrai si le vecteur instrumentsPretes de ce Prêt est vide }
		return this.instrumentsPretes.isEmpty();
	}

	public void recapPret() {
		// { } =>
		// { * si ce Pret n'est pas soldé, pour chaque Instrument différent dans
		// instrumentsPretes, le nom de l'instrument et son nombre d'exemplaires
		// dans ce vecteur a été affiché
		// * sinon, un message rappellant que ce Pret est soldé a été affiché }
		if(this.isSolde()){
			System.out.println("Ce pret est soldé");
		}
		else{
			int i = 0;
			int nbExemplaires = 0;
			while (i < this.instrumentsPretes.size()-1) {	// Parcours complet du vecteur jusqu'à l'avant dernier élémént
				nbExemplaires++;	// On ajoute l'exemplaire i
				if (this.instrumentsPretes.get(i).compareTo(this.instrumentsPretes.get(i+1)) != 0) {	// Si c'est le dernier du vecteur
					System.out.println("(" + this.instrumentsPretes.get(i).getNomInstrument() + ", " + nbExemplaires + ")");	// On l'affiche
					nbExemplaires = 0;	// Et on remet le nombre d'exemplaires à 0

				}
			}
			System.out.println("(" + this.instrumentsPretes.get(i).getNomInstrument() + ", " + nbExemplaires + ")");	// On affiche dans tous les cas le dernier élément
		}
	}
	
	public int compareTo(Pret pret){
		/*
		 * Compare l'instance active de Pret avec l'instance en paramètre
		 * selon l'ordre naturel de l'attribut numPret
		 * 
		 * @return résultat de la comparaison
		 */
		return this.numPret-pret.getnumPret();
	}
}

