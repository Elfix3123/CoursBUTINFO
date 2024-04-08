package jeu.guerriers;

/**
 * La classe ChefElfe représete un guerrier chef elfe du jeu Faërun.
 * Elle est une classe fille de Elfe.
 */
public class ChefElfe extends Elfe{
	/**
	 * Getter de force
	 * 
	 * @return l'attribut force de l'instance courante de ChefElfe
	 */
	public int getForce() {
		return super.getForce()*2;
	}

	/**
	 * Retourne le nombre de ressources nécessaires pour entraîner l'instance courante de ChefElfe.
	 * 
	 * @return l'attribut RESSOURCE_BASE de l'instance courante de ChefElfe
	 */
	public int getRessourcesPourEntrainement() {
		return super.getRessourcesPourEntrainement() * 2;
	}
}
