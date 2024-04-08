package jeu.guerriers;

import java.util.logging.Level;
import java.util.logging.Logger;

import jeu.Application;
import jeu.elements.Chateau;
import jeu.elements.Couleur;

/**
 * La classe Guerrier représete un guerrier du jeu Faërun.
 * Elle a pour objectif d'implémenter des méthodes permettant
 * de jouer à ce jeu.
 */
public abstract class Guerrier {
	private final int FORCE_BASE = 10;
	private final int PV_MAX_BASE = 100;
	private final int RESSOURCE_BASE = 1;
	private int pointsDeVie;
	private static final Logger LOGGER = Logger.getLogger(Application.class.getPackageName());

	private Couleur couleur;
	
	/**
	 * Constructeur d'une instance de Guerrier.
	 * 
	 * La valeur par défault de force est 10.
	 * La valeur par défault de pointsDeVie est 100.
	 */
	public Guerrier() {
		LOGGER.log(Level.INFO, "Création d'une instance de guerrier" + this.toString());
		this.pointsDeVie = this.PV_MAX_BASE;
	}

	// Getters
	/**
	 * Retourne la force de l'instance courante de Guerrier
	 * 
	 * @return l'attribut FORCE_BASE de l'instance courante de Guerrier
	 */
	public int getForce() {
		return this.FORCE_BASE;
	}

	/**
	 * Retourne la pointsDeVie de l'instance courante de Guerrier
	 * 
	 * @return l'attribut pointsDeVie de l'instance courante de Guerrier
	 */
	public int getPointsDeVie() {
		return this.pointsDeVie;
	}

	/**
	 * Retourne le nombre de ressources nécessaires pour entraîner l'instance courante de Guerrier
	 * 
	 * @return l'attribut RESSOURCE_BASE de l'instance courante de Guerrier
	 */
	public int getRessourcesPourEntrainement() {
		return this.RESSOURCE_BASE;
	}

	/**
	 * Retourne la couleur de l'instance courante de Guerrier
	 * 
	 * @return l'attribut couleur de l'instance courante de Guerrier
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * Modifie le nombre de points de vie de l'instance courante de Guerrier
	 * 
	 * @param pointsDeVie le nombre de points de vie
	 */
	public void setPointsDeVie(int pointsDeVie) {
		LOGGER.log(Level.INFO, "Modification des points de vie d'une instance de guerrier" + this.toString());
		this.pointsDeVie = pointsDeVie;
	}

	/**
	 * Modifie le chateau de l'instance courante de Guerrier.
	 * 
	 * @param chateau le chateau cible
	 */
	public void setChateau(Chateau chateau) {
		LOGGER.log(Level.INFO, "Modification du chateau d'une instance de guerrier" + this.toString());
		chateau.ajoutGuerrierNovice(this);
		this.couleur = chateau.getCouleur();
	}

	// Methodes
	/**
	 * Vérifie si l'instance courante de Guerrier est vivante.
	 * 
	 * @return vrai si pointsDeVie > 0, faux sinon
	 */
	public boolean estVivant() {
		return this.getPointsDeVie() > 0;
	}

	/**
	 * Renvoie vrai si l'instance courante de Guerrier est bleue, faux sinon.
	 * 
	 * @return vrai si couleur == Couleur.BLEU, faux sinon
	 */
	public boolean estBleu() {
		return this.couleur == Couleur.BLEU;
	}

	/**
	 * Renvoie vrai si l'instance courante de Guerrier est rouge, faux sinon.
	 * 
	 * @return vrai si couleur == Couleur.ROUGE, faux sinon
	 */
	public boolean estRouge() {
		return this.couleur == Couleur.ROUGE;
	}

	/**
	 * Permet à l'instance courante de Guerrier d'attaquer l'instance de Guerrier
	 * passée en paramètre et de lui infliger des dégats.
	 * 
	 * @param guerrier le guerrier à attaquer
	 */
	public void attaquer(Guerrier guerrier) {
		LOGGER.log(Level.INFO, "Attaque d'une autre instance de guerrier" + this.toString());
		guerrier.subirDegats(GuerrierUtilitaire.de3(this.getForce()));
	}

	/**
	 * Fait subir des degats à l'instance courante de guerrier.
	 * 
	 * @param degats les degats à subir
	 */
	protected void subirDegats(int degats) {
		LOGGER.log(Level.INFO, "Degats recus par une instance de guerrier, " + this.toString());
		this.setPointsDeVie(this.getPointsDeVie() - degats);
	}
	
	@Override
	public String toString() {
		return "{" +
			" force='" + getForce() + "'" +
			", pointsDeVie='" + getPointsDeVie() + "'" +
			"}";
	}
}
