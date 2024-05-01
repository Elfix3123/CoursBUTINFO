package jeu.elements;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import jeu.Application;
import jeu.guerriers.Guerrier;

/**
 * Cette classe représente un carreau du plateau de jeu.
 */
public class Carreau {
	ArrayList<Guerrier> guerriersBleus;
	ArrayList<Guerrier> guerriersRouges;
	private static final Logger LOGGER = Logger.getLogger(Application.class.getPackageName());

	/**
	 * Constructeur de la classe Carreau.
	 */
	public Carreau() {
		LOGGER.log(Level.INFO, "Création d'une instance de carreau");
		guerriersBleus = new ArrayList<Guerrier>();
		guerriersRouges = new ArrayList<Guerrier>();
	}

	/**
	 * Renvoie le vecteur des guerriers bleus présents sur l'instance de carreau courante.
	 * 
	 * @return ArrayList<Guerrier> le vecteur des guerriers bleus
	 */
	public ArrayList<Guerrier> getGuerriersBleus() {
		return this.guerriersBleus;
	}

	/**
	 * Renvoie le vecteur des guerriers rouges présents sur l'instance de carreau courante.
	 * 
	 * @return ArrayList<Guerrier> le vecteur des guerriers rouges
	 */
	public ArrayList<Guerrier> getGuerriersRouges() {
		return this.guerriersRouges;
	}

	/**
	 * Ajoute des guerriers bleus à l'instance de carreau courante.
	 * 
	 * @param ArrayList<Guerrier> les guerriers à ajouter
	 */
	public void ajoutGuerriersBleus(ArrayList<Guerrier> guerriers) {
		LOGGER.log(Level.INFO, "Ajout de guerriers bleus à une instance de carreau");
		this.guerriersBleus.addAll(guerriers);
	}

	/**
	 * Ajoute des guerriers rouges à l'instance de carreau courante.
	 * 
	 * @param ArrayList<Guerrier> les guerriers à ajouter
	 */
	public void ajoutGuerriersRouges(ArrayList<Guerrier> guerriers) {
		LOGGER.log(Level.INFO, "Ajout de guerriers rouges à une instance de carreau");
		this.guerriersRouges.addAll(guerriers);
	}

	/**
	 * Retire les guerriers bleus de l'instance de carreau courante et les renvoie.
	 * 
	 * @return ArrayList<Guerrier> les guerriers retirés
	 */
	public ArrayList<Guerrier> retirerGuerriersBleus() {
		LOGGER.log(Level.INFO, "Retrait de guerriers bleus d'une instance de carreau");
		ArrayList<Guerrier> guerriersRetires = new ArrayList<Guerrier>(this.guerriersBleus);
		this.guerriersBleus.clear();
		return guerriersRetires;
	}

	/**
	 * Retire les guerriers rouges de l'instance de carreau courante et les renvoie.
	 * 
	 * @return ArrayList<Guerrier> les guerriers retirés
	 */
	public ArrayList<Guerrier> retirerGuerriersRouges() {
		LOGGER.log(Level.INFO, "Retrait de guerriers rouges d'une instance de carreau");
		ArrayList<Guerrier> guerriersRetires = new ArrayList<Guerrier>(this.guerriersRouges);
		this.guerriersRouges.clear();
		return guerriersRetires;
	}

	/**
	 * Supprime un guerrier en paramètre de l'instance de carreau courante.
	 * 
	 * @param Guerrier le guerrier à supprimer
	 */
	public void supprimerGuerrier(Guerrier guerrier) {
		LOGGER.log(Level.INFO, "Suppression d'un guerrier d'une instance de carreau");
		if (this.guerriersBleus.contains(guerrier)) {
			this.guerriersBleus.remove(guerrier);
		} else if (this.guerriersRouges.contains(guerrier)) {
			this.guerriersRouges.remove(guerrier);
		}
	}

	/**
	 * Renvoie vrai si l'instance de carreau courante ne contient aucun guerrier rouge, faux sinon.
	 * 
	 * @return boolean vrai si le carreau est bleu, faux sinon
	 */
	public boolean estBleu() {
		return this.guerriersRouges.isEmpty();
	}

	/**
	 * Renvoie vrai si l'instance de carreau courante ne contient aucun guerrier bleu, faux sinon.
	 * 
	 * @return boolean vrai si le carreau est rouge, faux sinon
	 */
	public boolean estRouge() {
		return this.guerriersBleus.isEmpty();
	}

	/**
	 * Renvoie vrai si l'instance de carreau courante est peuplée d'au moins un guerrier bleu et un guerrier rouge, faux sinon.
	 * 
	 * @return boolean vrai si le carreau est un champs de bataille, faux sinon
	 */
	public boolean estChampsDeBataille() {
		return !this.guerriersBleus.isEmpty() && !this.guerriersRouges.isEmpty();
	}

	/**
	 * Lance un combat sur l'instance courante de carreau, suivant les règles du jeu.
	 * 
	 * @return int le nombre de guerriers morts
	 */
	public int lanceCombat() {
		LOGGER.log(Level.INFO, "Lancement d'un combat sur une instance de carreau");
		int i = 0;
		int guerriersMorts = 0;

		// Tour bleu
		while (i < this.guerriersBleus.size() & !this.guerriersRouges.isEmpty()) {	// Tant qu'il reste des guerriers bleus
			this.guerriersBleus.get(i).attaquer(this.guerriersRouges.get(0));	// Le guerrier bleu courant attaque le guerrier rouge en tête de file

			if (!this.guerriersRouges.get(0).estVivant()) {	// Si le guerrier rouge en tête de file est mort
				guerriersMorts++;
				this.guerriersRouges.remove(0);	// Supprime le guerrier rouge en tête de file
			}

			i++;
		}

		i = 0;

		// Tour rouge
		while (i < this.guerriersRouges.size() & !this.guerriersBleus.isEmpty()) {	// Tant qu'il reste des guerriers rouges
			this.guerriersRouges.get(i).attaquer(this.guerriersBleus.get(0));	// Le guerrier rouge courant attaque le guerrier bleu en tête de file

			if (!this.guerriersBleus.get(0).estVivant()) {	// Si le guerrier bleu en tête de file est mort
				guerriersMorts++;
				this.guerriersBleus.remove(0);	// Supprime le guerrier bleu en tête de file
			}

			i++;
		}
		
		return guerriersMorts;
	}

	/**
	 * Renvoie une représentation textuelle de l'instance de carreau courante.
	 * 
	 * @return String la représentation textuelle du carreau
	 */
	public String toString() {
		String carreau = "";
		carreau += new String(new char[this.guerriersBleus.size()]).replace("\0", "B");
		carreau += new String(new char[this.guerriersRouges.size()]).replace("\0", "R");
		return carreau;
	}
}
