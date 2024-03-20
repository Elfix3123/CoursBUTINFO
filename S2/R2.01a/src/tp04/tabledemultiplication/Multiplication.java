package tp04.tabledemultiplication;

/**
 * Cette classe implémente une multiplication entre deux termes.
 */
public class Multiplication {
	private int terme1;
	private int terme2;
	private Integer reponseUtilisateur;
	private boolean modeSansErreur;

	/**
	 * Constructeur de la classe Multiplication.
	 * 
	 * @param terme1
	 * @param terme2
	 */
	public Multiplication(int terme1, int terme2, boolean modeSansErreur) {
		this.terme1 = terme1;
		this.terme2 = terme2;
		this.modeSansErreur = modeSansErreur;
	}

	/**
	 * Modifie la réponse de l'utilisateur.
	 * 
	 * @param reponseUtilisateur la réponse
	 */
	public void setReponseUtilisateur(int reponse) throws ErreurMultiplicationException {
		this.reponseUtilisateur = reponse;

		if (this.modeSansErreur & !this.isReponseJuste()) {
			throw new ErreurMultiplicationException("La réponse est fausse");
		}
	}

	/**
	 * Renvoie vrai si la réponse de l'utilisateur est correcte, faux sinon.
	 * 
	 * @return bool 
	 */
	public boolean isReponseJuste() {
		return this.terme1 * this.terme2 == this.reponseUtilisateur;
	}

	/**
	 * Renvoie une représnetation textuelle de la multiplication.
	 * 
	 * @return String
	 */
	public String toString() {
		return this.terme1 + " x " + this.terme2 + " = ";
	}
}
