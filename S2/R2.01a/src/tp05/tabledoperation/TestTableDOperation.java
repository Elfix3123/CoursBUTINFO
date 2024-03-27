package tp05.tabledoperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import tp05.TestLogging;

public class TestTableDOperation {
	// Récupérarion du gestionnaire de logs.
	private static final LogManager LOG_MANAGER = LogManager.getLogManager();
	private static Logger LOGGER = Logger.getLogger(TestLogging.class.getPackageName());

	// Configuration du logger
	static{
		try {
			LOG_MANAGER.readConfiguration(new FileInputStream("/home/felix/Documents/Cours/S2/R2.01a/conf/debug-logging.properties"));
		} catch (IOException exception ) {
			LOGGER.log( Level.SEVERE, "Echec de la configuration du logger", exception );
		}
	}

	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);

		System.out.print("Addition 1 ou Soustraction 2 ou Multiplication 3 ? ");
		int numeroOperation = lecteur.nextInt();

		while (1 > numeroOperation | numeroOperation > 3) {
			System.out.print("Merci de répondre par 1 ou 2 ou 3 ? ");
			numeroOperation = lecteur.nextInt();
		}
		OperationEnum typeOperation = OperationEnum.getOperationEnum(numeroOperation);
		LOGGER.log(Level.INFO, "Type d'operation : " + typeOperation.toString());

		System.out.print("Mode sans erreur true ou false ? ");
		boolean modeSansErreurs = lecteur.nextBoolean();
		LOGGER.log(Level.INFO, "Mode sans erreur : " + modeSansErreurs);

		TableDOperation tableDOperation = new TableDOperation(typeOperation);
		

		System.out.println("Donner les réponses aux opérations : ");

		int i = 0;
		while (!tableDOperation.estTableRepondue()) {
			System.out.print(tableDOperation.getOperation(i).toString());
			double reponse = lecteur.nextDouble();
			try {
				tableDOperation.getOperation(i).setReponseUtilisateur(reponse, modeSansErreurs);
			}
			catch (ErreurOperationException exception) {
				System.out.println("Votre réponse n'est pas correcte, réessayer !");
				i--;
			}

			i++;
		}

		System.out.println("Nombre de réponses justes : " + tableDOperation.getNombreReponsesJustes());
	}
}
