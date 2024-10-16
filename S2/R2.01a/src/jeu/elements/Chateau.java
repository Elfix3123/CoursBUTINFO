package jeu.elements;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import jeu.Application;
import jeu.guerriers.*;

/**
 * La classe Chateau représente un chateau du jeu Faërun.
 * Elle a pour objectif d'implémenter des méthodes permettant
 * de jouer à ce jeu.
 */
public class Chateau {
	private final int RESSOURCES_INITIALES = 3;
	private final int RESSOURCES_AJOUTEES_PAR_TOUR = 1;
	private int ressources;
	private static final Logger LOGGER = Logger.getLogger(Application.class.getPackageName());

	private ArrayList<Guerrier> guerriers;
	private Couleur couleur;

	/**
	 * Constructeur d'une instance de Chateau.
	 * 
	 * La valeur par défault de ressources est 3.
	 */
	public Chateau(Couleur couleur) {
		LOGGER.info("Création d'une instance de chateau");
		this.ressources = this.RESSOURCES_INITIALES;
		this.couleur = couleur;
		this.guerriers = new ArrayList<>();
	}

	/**
	 * Ajoute un guerrier en parmètre à la liste des guerriers de l'intance courante de Chateau.
	 * 
	 * @param guerrier le guerrier à ajouter
	 */
	public void ajoutGuerrierNovice(Guerrier guerrier) {
		LOGGER.log(Level.INFO, "Ajout d'un guerrier novice à une instance de chateau");
		this.guerriers.add(guerrier);
	}

	/**
	 * Retourne le vecteur des guerriers de l'instance courante de Chateau.
	 */
	public ArrayList<Guerrier> getGuerriersNovices() {
		return this.guerriers;
	}

	/**
	 * Entraine un maximum de guerriers avec les ressources disponibles.
	 * 
	 * @return guerriersEntraines le vecteur des guerriers entrainés
	 */
	public ArrayList<Guerrier> entrainer() {
		LOGGER.log(Level.INFO, "Entraînement des guerriers d'une instance de chateau");
		ArrayList<Guerrier> guerriersEntraines = new ArrayList<Guerrier>();

		while (!guerriers.isEmpty() && guerriers.get(0).getRessourcesPourEntrainement() <= this.ressources) {
			this.ressources -= guerriers.get(0).getRessourcesPourEntrainement();
			guerriersEntraines.add(this.guerriers.get(0));
			this.guerriers.remove(0);
		}

		return guerriersEntraines;
	}

	/**
	 * Ajoute le nombre de ressources ajoutées par tour aux ressources de l'instance courante de Chateau.
	 */
	public void incrementerRessources() {
		LOGGER.log(Level.INFO, "Incrémentation des ressources d'une instance de chateau");
		this.ressources += this.RESSOURCES_AJOUTEES_PAR_TOUR;
	}

	/**
	 * Retourne la couleur de l'instance courante de Chateau.
	 * 
	 * @return la couleur du chateau
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * Retourne vrai si la couleur de l'instance courante de Chateau est bleue, faux sinon.
	 * 
	 * @return vrai si la couleur de l'instance courante de Chateau est bleue, faux sinon
	 */
	public boolean estBleu() {
		return this.couleur == Couleur.BLEU;
	}

	/**
	 * Retourne vrai si la couleur de l'instance courante de Chateau est rouge, faux sinon.
	 * 
	 * @return vrai si la couleur de l'instance courante de Chateau est rouge, faux sinon
	 */
	public boolean estRouge() {
		return this.couleur == Couleur.ROUGE;
	}
}
