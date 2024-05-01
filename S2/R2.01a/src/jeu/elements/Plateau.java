package jeu.elements;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import jeu.Application;
import jeu.guerriers.Guerrier;

/**
 * Cette classe représente un plateau du jeu de Faerun.
 */
public class Plateau {
	ArrayList<Carreau> carreaux;
	private static final Logger LOGGER = Logger.getLogger(Application.class.getPackageName());

	/**
	 * Constructeur de la classe Plateau.
	 * 
	 * @param longueur la longueur du plateau
	 */
	public Plateau(int longueur) {
		LOGGER.log(Level.INFO, "Création d'une instance de plateau");
		carreaux = new ArrayList<Carreau>();
		
		int i = 0;

		while (i < longueur) {
			carreaux.add(new Carreau());
			i++;
		}
	}

	/**
	 * Ajoute des guerriers de la couleur du chateau en paramètre à l'instance de plateau courante, à la première case de la couleur du chateau.
	 * 
	 * @param Chateau le chateau dont on veut ajouter les guerriers
	 * @param ArrayList<Guerrier> les guerriers à ajouter
	 */
	public void ajoutGuerriers(Chateau chateau, ArrayList<Guerrier> guerriers) {
		LOGGER.log(Level.INFO, "Ajout de guerriers à une instance de plateau");
		if (chateau.getCouleur() == Couleur.BLEU) {
			this.getCaseDepartBleus().ajoutGuerriersBleus(guerriers);
		} else {
			this.getCaseDepartRouges().ajoutGuerriersRouges(guerriers);
		}
	}

	/**
	 * Renvoie la case de départ des bleus.
	 * 
	 * @return Carreau la case de départ des bleus
	 */
	public Carreau getCaseDepartBleus() {
		return carreaux.get(0);
	}

	/**
	 * Renvoie la case de départ des rouges.
	 * 
	 * @return Carreau la case de départ des rouges
	 */
	public Carreau getCaseDepartRouges() {
		return carreaux.get(carreaux.size() - 1);
	}

	/**
	 * Déplace tous les guerriers du plateau.
	 */
	public void deplacerGuerriers() {
		LOGGER.log(Level.INFO, "Déplacement des guerriers sur une instance de plateau");
		int i = 0;
		ArrayList<Guerrier> guerriersBleusTemp = new ArrayList<Guerrier>();
		ArrayList<Guerrier> guerriersBleusCourants = new ArrayList<Guerrier>();

		while (i < this.carreaux.size()) {
			if (this.carreaux.get(i).estBleu()) {
				guerriersBleusCourants.clear();
				guerriersBleusCourants.addAll(this.carreaux.get(i).retirerGuerriersBleus());
				this.carreaux.get(i).ajoutGuerriersBleus(guerriersBleusTemp);
				guerriersBleusTemp.clear();
				guerriersBleusTemp.addAll(guerriersBleusCourants);
			} else {
				this.carreaux.get(i).ajoutGuerriersBleus(guerriersBleusTemp);
				guerriersBleusTemp.clear();
				if (this.carreaux.get(i).estRouge() & i != 0) {
					this.carreaux.get(i - 1).ajoutGuerriersRouges(this.carreaux.get(i).retirerGuerriersRouges());
				}
			}

			i++;
		}
	}
	
	/**
	 * Lance un combat sur toutes les cases de l'instance de plateau courante qui sont des champs de bataille.
	 * 
	 * @return le nombre de guerriers morts
	 */
	public int lanceCombats() {
		LOGGER.log(Level.INFO, "Lancement des combats sur une instance de plateau");
		int i = 0;
		int guerriersMorts = 0;

		while (i < this.carreaux.size()) {
			if (this.carreaux.get(i).estChampsDeBataille()) {
				guerriersMorts += this.carreaux.get(i).lanceCombat();
			}

			i++;
		}

		return guerriersMorts;
	}

	/**
	 * Renvoie une représentation textuelle du plateau.
	 * 
	 * @return String la représentation textuelle du plateau
	 */
	public String toString() {
		String plateau = "|";

		for (Carreau carreau : carreaux) {
			plateau += carreau.toString();
			plateau += "\t|";
		}

		return plateau;
	}
}
