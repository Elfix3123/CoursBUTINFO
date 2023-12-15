public class Categorie implements Comparable<Categorie>{
	// Attributs
	private String nomCat;
	private ListeTrieeC<Instrument> lInstruments;

	// Constructeurs
	public Categorie(){
		/*
		 * Constructeur d'une Catégorie vide
		 */
		this.nomCat = "";
		this.lInstruments = new ListeTrieeC<>();
	}

	public Categorie(String nomCat){
		/*
		 * Constructeur d'une Catégorie avec un nom en paramètre
		 */
		this.nomCat = nomCat;
		this.lInstruments = new ListeTrieeC<>();
	}

	public Categorie(String nomCat, ListeTrieeC<Instrument> lInstruments){
		/*
		 * Constructeur d'une Catégorie avec un nom et une liste
		 * d'instruments en paramètre
		 */
		this.nomCat = nomCat;
		this.lInstruments = lInstruments;
	}

	// Getters
	public String getNomCat(){
		/*
		 * Getter de l'attribut nomCat
		 * 
		 * @return nomCat
		 */
		return this.nomCat;
	}

	public ListeTrieeC<Instrument> getLInstruments(){
		/*
		 * Getter de l'attribut lInstruments
		 * 
		 * @return lInstruments
		 */
		return this.lInstruments;
	}

	// Méthodes
	public void afficheCat() {
		/*
		 * Affiche une chaîne de caractères représentant l'instance active 
		 * de Categorie
		 */
		System.out.print(this.nomCat + " (" + this.lInstruments.getLongueur()+") : ");
		lInstruments.afficheGD();
	}

	public boolean exixstInsDispo() {
		// { lInstruments non vide } =>
		// { résultat = vai si au moins un instrument de lInstruments peut être prêté }
		return !this.lInstruments.estVide();
	}

	public int compareTo(Categorie comparant){
		/*
		 * Compare l'instance active de Categorie avec l'instance en paramètre
		 * selon l'ordre naturel de l'attribut nomCat
		 * 
		 * @return résultat de la comparaison
		 */
		return this.nomCat.compareTo(comparant.getNomCat());
	}
}
