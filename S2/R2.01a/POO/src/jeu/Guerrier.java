package jeu;

/**
 * La classe Guerrier représete un guerrier du jeu Faërun.
 * Elle a pour objectif d'implémenter des méthodes permettant
 * de jouer à ce jeu.
 */
public class Guerrier {
	private int force;
	private int pointsDeVie;
	
	/**
	 * Constructeur d'une instance de Guerrier.
	 * 
	 * La valeur par défault de force est 10.
	 * La valeur par défault de pointsDeVie est 100.
	 */
	public Guerrier() {
		this.force = 10;
		this.pointsDeVie = 100;
	}

	// Getters
	/**
	 * Getter de force
	 * 
	 * @return l'attribut force de l'instance courante de Guerrier
	 */
	public int getForce() {
		return this.force;
	}

	/**
	 * Getter de pointsDeVie
	 * 
	 * @return l'attribut pointsDeVie de l'instance courante de Guerrier
	 */
	public int getPointsDeVie() {
		return this.pointsDeVie;
	}

	/**
	 * Setter de pointsDeVie
	 * 
	 * @param pointsDeVie le nombre de points de vie
	 */
	public void setPointsDeVie(int pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
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
	 * Permet à l'instance courante de Guerrier d'attaquer l'instance de Guerrier
	 * passée en paramètre et de lui infliger des dégats.
	 * 
	 * @param guerrier le guerrier à attaquer
	 */
	public void attaquer(Guerrier guerrier) {
		guerrier.subirDegats(GuerrierUtilitaire.de3(this.getForce()));
	}

	/**
	 * Fait subir des degats à l'instance courante de guerrier.
	 * 
	 * @param degats les degats à subir
	 */
	protected void subirDegats(int degats) {
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
