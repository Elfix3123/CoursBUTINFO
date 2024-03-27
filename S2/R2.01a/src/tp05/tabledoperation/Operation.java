package tp05.tabledoperation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cette classe vise à implémenter les comportements communs aux opérations
 * de manière abstraite.
 */
public abstract class Operation {
	private double terme1;
	private double terme2;
	private Double reponseUtilisateur;
	private static Logger LOGGER = Logger.getLogger(TableDOperation.class.getPackageName());


	/**
	 * Constructeur d'une instance d'Operation entre deux termes.
	 * 
	 * @param terme1
	 * @param terme2
	 */
	public Operation(double terme1, double terme2) {
		this.terme1 = terme1;
		this.terme2 = terme2;
	}

	/**
	 * Modifie la réponse de l'utilisateur.
	 * 
	 * @param reponse;
	 */
	public void setReponseUtilisateur(double reponse) {
		this.reponseUtilisateur = reponse;
		if (this.isReponseJuste()) {
			LOGGER.log(Level.INFO, "Une réponse juste de l'utilisateur");
		} else {
			LOGGER.log(Level.WARNING, "Une réponse fausse de l'utilisateur");			
		}
	}

	/**
	 * Modifie la réponse de l'utilisateur.
	 * 
	 * @param reponse;
	 */
	public void setReponseUtilisateur(double reponse, boolean modeSansErreurs) throws ErreurOperationException {
		this.reponseUtilisateur = reponse;
		if (modeSansErreurs & !this.isReponseJuste()) {
			throw new ErreurOperationException("La réponse est incorrecte.");
		}
		if (this.isReponseJuste()) {
			LOGGER.log(Level.INFO, "Une réponse juste de l'utilisateur");
		} else {
			LOGGER.log(Level.WARNING, "Une réponse fausse de l'utilisateur");			
		}
	}

	/**
	 * Retourne vrai si l'utilisateur a rentré une reponse, faux sinon.
	 * 
	 * @return boolean
	 */
	public boolean existeReponseUtilisateur() {
		return this.reponseUtilisateur != null;
	}

	/**
	 * Retourne vrai si la réponse de l'operation est correcte, faux sinon.
	 * 
	 * @return boolean
	 */
	public boolean isReponseJuste() {
		return reponseUtilisateur == this.calculResultat();
	}

	/**
	 * Calcule et renvoie la réponse de l'opération.
	 * 
	 * @return double
	 */
	public abstract double calculResultat();

	/**
	 * Renvoie le premier terme de l'operation.
	 * 
	 * @return double
	 */
	public double getTerme1() {
		return this.terme1;
	}

	/**
	 * Renvoie le second terme de l'operation.
	 * 
	 * @return double
	 */
	public double getTerme2() {
		return this.terme2;
	}
}

