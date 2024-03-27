package tp05.tabledoperation;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cette classe a pour but d'implémenter une table contenant plusierus opérations.
 */
public class TableDOperation {
	private OperationEnum typeOperation;
	private ArrayList<Operation> operations = new ArrayList<Operation>();
	private final int NOMBRE_OPERATIONS = 5;
	private static Logger LOGGER = Logger.getLogger(TableDOperation.class.getPackageName());

	/**
	 * Constructeur de la classe TableDOperation.
	 * @param typeOperation
	 */
	public TableDOperation(OperationEnum typeOperation) {
		this.typeOperation = typeOperation;
		this.initialisation();
	}

	/**
	 * Initialise l'instance courante de TableDOperation 
	 * en nettoyant les opérations existantes puis en ajoutant
	 * le bon nombre d'opérations.
	 */
	private void initialisation() {
		LOGGER.log(Level.INFO, "Initialisation des operations...");
		operations.clear();

		int i = 0;

		while (i < NOMBRE_OPERATIONS) {
			operations.add(OperationUtilitaire.getOperation(OperationUtilitaire.randomDouble(), OperationUtilitaire.randomDouble(),this.typeOperation));
			LOGGER.log(Level.INFO, "Création d'opération : " + operations.get(i).toString());
			i++;
		}
	}

	/**
	 * Retourne le nombre total d'opérations de l'instance courante.
	 * @return
	 */
	public int getNombreOperations() {
		return this.NOMBRE_OPERATIONS;
	}

	/**
	 * Retourne le nombre de réponses répondues de l'instance courante.
	 * de TableDOperation.
	 * 
	 * @return int
	 */
	public int getNombreReponses() {
		int nombreReponses = 0;

		for (Operation operation : operations) {
			if (operation.existeReponseUtilisateur()) {
				nombreReponses++;
			}
		}

		return nombreReponses;
	}

	/**
	 * Retourne le nombre de réponses justes de l'instance courante.
	 * de TableDOperation.
	 * 
	 * @return int
	 */
	public int getNombreReponsesJustes() {
		int nombreReponsesJustes = 0;

		for (Operation operation : operations) {
			if (operation.isReponseJuste()) {
				nombreReponsesJustes++;
			}
		}

		return nombreReponsesJustes;
	}

	/**
	 * Retourne vrai si toutes les réponses ont été répondues, faux sinon.
	 * 
	 * @return boolean
	 */
	public boolean estTableRepondue() {
		return this.getNombreReponses() == this.getNombreOperations();
	}
	
	/** 
	 * Retourne une opération de l'instance courante de TableDOperation.
	 * 
	 * @param index
	 * 
	 * @return Operation
	 */
	public Operation getOperation(int index) {
		return operations.get(index);
	}
}
