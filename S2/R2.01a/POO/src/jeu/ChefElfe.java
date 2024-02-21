package jeu;

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
}
