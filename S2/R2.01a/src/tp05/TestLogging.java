package tp05;

import java.io.FileInputStream ;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestLogging {
	// Récupérarion du gestionnaire de logs.
	private static final LogManager LOG_MANAGER = LogManager.getLogManager();
	private static Logger LOGGER = Logger.getLogger(TestLogging.class.getPackageName());

	// Configuration du logger
	static{
		try {
			LOG_MANAGER.readConfiguration(new FileInputStream("conf/debug-logging.properties"));
		} catch (IOException exception ) {
			LOGGER.log( Level.SEVERE, "Echec de la configuration du logger", exception );
		}
	}
	public static void main(String[] args) {
		// Déclaration des opérandes
		int dividende = (int)(Math.random()*9)+1;
		int diviseur = (int)(Math.random()*2)+1;

		// Affichage des logs
		LOGGER.log(Level.INFO, "Mon premier log !" );
		LOGGER.log(Level.WARNING, "Attention, une division par zéro peut se produire" );

		// Division
		try {
			int quotient = dividende/diviseur;
			Object[] data = { dividende, diviseur, quotient };

			LOGGER.log(Level.INFO, "dividende = {0}, diviseur = {1} et quotient = {2}", data);
		} catch (ArithmeticException e) {
			LOGGER.log(Level.SEVERE, "Le message d'exception : " + e.getMessage());
		}
		
	}
}