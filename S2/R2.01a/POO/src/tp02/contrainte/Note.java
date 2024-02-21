package tp02.contrainte;

/**
 * Cette classe implémente une note.
 */
public class Note extends ReelContraint {
	/**
	 * Constructeur de Note sans valeur.
	 */
	public Note(){
		super(0, 20);
		super.setValeur(0);
	}

	/**
	 * Constructeur de Note.
	 * @param valeur
	 */
	public Note(double valeur){
		super(0, 20);
		super.setValeur(valeur);
	}
}
