package jeu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import jeu.elements.Chateau;
import jeu.elements.Couleur;
import jeu.elements.Plateau;
import jeu.guerriers.Guerrier;
import jeu.guerriers.Nain;

public class Application {
	private static final LogManager LOG_MANAGER = LogManager.getLogManager();
	private static final Logger LOGGER = Logger.getLogger(Application.class.getPackageName());
	
	// Configuration du logger
	static{
		try {
			LOG_MANAGER.readConfiguration(new FileInputStream("conf/debug-logging.properties"));
		} catch (IOException exception ) {
			LOGGER.log( Level.SEVERE, "Echec de la configuration du logger", exception );
		}
	}
	public static void main(String[] args) {
		/////
		// 1) --Creation du plateau
		Plateau plateau = new Plateau(5);
		
		/////
		// 2) --Creation des chateaux
		Chateau chateauBleu = new Chateau(Couleur.BLEU);
		Chateau chateauRouge = new Chateau(Couleur.ROUGE);
		
		////
		// 3) --Initialisation des équipes
		////
		
		// Donner les ordres de creation de Guerriers pour le chateau bleu
		int i = 0;

		while (i < 10) {
			chateauBleu.ajoutGuerrierNovice(new Nain());
			i++;
		}
		
		// Donner les ordres de creation de Guerriers pour le chateau rouge
		
		
		
		////
		// 4) --Boucle du jeu
		//while (---) {
			
			// Affichage du numéro de tour
			
			////
			// 4.1) -- Entraînement et mise en jeu des Guerriers entraînés
			
			////
			// 4.2) -- Tous les Guerriers des deux camps avance d'un Carreau
			//           sauf s'il y a un ou plusieurs Guerriers du
			//           camp adverse sur leur Carreau
			
			
			////
			// 4.3) -- Lancer les combats + affichage des combats (et des morts)
			
			//}
			
			////
			// 5) -- Affichage de l'équipe gagnate
			
		}
	}
	