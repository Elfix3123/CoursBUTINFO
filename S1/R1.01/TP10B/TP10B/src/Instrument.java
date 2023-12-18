public class Instrument implements Comparable<Instrument> {
	// Attributs
	private String nomInstrument;
	private int nbDispo;

	// Constructeurs
	public Instrument(){
		/*
		 * Constructeur d'un Instrument vide
		 */
		this.nomInstrument = "";
		this.nbDispo = 0;
	}

	public Instrument(String nomInstrument){
		/*
		 * Constructeur d'un Instrument avec un nom en paramètre
		 */
		this.nomInstrument = nomInstrument;
		this.nbDispo = 0;
	}

	public Instrument(String nomInstrument, int nbDispo){
		/*
		 * Constructeur d'un instrument avec un nom et un nombre
		 * en paramètre
		 */
		this.nomInstrument = nomInstrument;
		this.nbDispo = nbDispo;
	}

	// Getters
	public String getNomInstrument(){
		/*
		 * Getter de l'attribut nomInstrument
		 * 
		 * @return nomInstrument
		 */
		return this.nomInstrument;
	}

	public int getNbDispo(){
		/*
		 * Getter de l'attribut nbDispo
		 * 
		 * @return nbDispo
		 */
		return this.nbDispo;
	}

	// Méthodes
	public void renduExemplaires(int nbEx) {
		// { } => { nbDispo a été mis à jour }
		this.nbDispo += nbEx;
	}

	public void retraitExemplaires(int nbEx) throws ExceptionDefautDispo {
		// { } => { nbDispo a été mis à jour si et seulement si sa valeur était
		// supérieure à nbEx, sinon, l'exception ExceptionDefautDispo
		// est levée }
		if(this.nbDispo >= nbEx){
			this.nbDispo-=nbEx;
		}
		else{
			throw new ExceptionDefautDispo("Stock insuffisant, il ne reste que "
				+ this.nbDispo + " instruments.");
		}
	}

	@Override
	public String toString(){
		/*
		 * Renvoie une chaîne de caractères représentant l'instance active 
		 * d'Instrument
		 * 
		 * @return (nomInstrument, nbDispo)
		 */
		return "(" + this.nomInstrument + ", " + this.nbDispo + ")";
	}

	public int compareTo(Instrument comparant){
		/*
		 * Compare l'instance active d'Instrument avec l'instance en paramètre
		 * selon l'ordre naturel de l'attribut nomInstrument
		 * 
		 * @return résultat de la comparaison
		 */
		return this.nomInstrument.compareTo(comparant.getNomInstrument());
	}
}
