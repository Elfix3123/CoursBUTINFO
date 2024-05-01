package jeu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import jeu.elements.Chateau;
import jeu.elements.Couleur;
import jeu.elements.Plateau;
import jeu.guerriers.GuerrierUtilitaire;

public class Application {
	private static final LogManager LOG_MANAGER = LogManager.getLogManager();
	private static final Logger LOGGER = Logger.getLogger(Application.class.getPackageName());
	
	// Configuration du logger
	static{
		try {
			LOG_MANAGER.readConfiguration(new FileInputStream("conf/debug-logging.properties"));
		} catch (IOException exception ) {
			LOGGER.log(Level.SEVERE, "Echec de la configuration du logger", exception);
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
			chateauBleu.ajoutGuerrierNovice(GuerrierUtilitaire.guerrierAleatoire());
			i++;
		}
		
		// Donner les ordres de creation de Guerriers pour le chateau rouge
		i = 0;

		while (i < 10) {
			chateauRouge.ajoutGuerrierNovice(GuerrierUtilitaire.guerrierAleatoire());
			i++;
		}
		
		////
		// 4) --Boucle du jeu
		int tour = 1;
		while (!(plateau.getCaseDepartBleus().estRouge() & !plateau.getCaseDepartBleus().getGuerriersRouges().isEmpty()) & 
			!(plateau.getCaseDepartRouges().estBleu() & !plateau.getCaseDepartRouges().getGuerriersBleus().isEmpty())) {
			
			// Affichage du numéro de tour
			System.out.println("Tour " + tour);
			////
			// 4.1) -- Entraînement et mise en jeu des Guerriers entraînés
			System.out.println("Entraînement des guerriers...");
			plateau.getCaseDepartBleus().ajoutGuerriersBleus(chateauBleu.entrainer());
			plateau.getCaseDepartRouges().ajoutGuerriersRouges(chateauRouge.entrainer());
			System.out.println(plateau);

			////
			// 4.2) -- Tous les Guerriers des deux camps avancent d'un Carreau
			//           sauf s'il y a un ou plusieurs Guerriers du
			//           camp adverse sur leur Carreau
			System.out.println("Déplacement des guerriers...");
			plateau.deplacerGuerriers();
			System.out.println(plateau);
			
			////
			// 4.3) -- Lancer les combats + affichage des combats (et des morts)
			System.out.println("Lancement des combats...");
			System.out.println("Nombre de guerriers morts : " + plateau.lanceCombats());
			System.out.println(plateau);

			////
			// 4.4) -- Incrémenter les ressources des chateaux
			chateauBleu.incrementerRessources();
			chateauRouge.incrementerRessources();
			
			tour++;
		}
			
		////
		// 5) -- Affichage de l'équipe gagnate
		if (plateau.getCaseDepartBleus().estRouge() & !plateau.getCaseDepartBleus().getGuerriersRouges().isEmpty()) {
			System.out.println("L'équipe rouge a gagné !");
		} else {
			System.out.println("L'équipe bleue a gagné !");
		}
	}
}
