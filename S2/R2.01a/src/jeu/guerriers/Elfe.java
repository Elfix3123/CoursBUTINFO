package jeu.guerriers;

/**
 * La classe Elfe représete un guerrier elfe du jeu Faërun.
 * Elle est une classe fille de Guerrier.
 */
public class Elfe extends Guerrier{
	/**
	 * Getter de force
	 * 
	 * @return l'attribut force de l'instance courante de Elfe
	 */
	public int getForce() {
		return super.getForce()*2;
	}

	/**
	 * Retourne le nombre de ressources nécessaires pour entraîner l'instance courante de Elfe.
	 * 
	 * @return l'attribut RESSOURCE_BASE de l'instance courante de Elfe
	 */
	public int getRessourcesPourEntrainement() {
		return super.getRessourcesPourEntrainement() * 2;
	}
}
