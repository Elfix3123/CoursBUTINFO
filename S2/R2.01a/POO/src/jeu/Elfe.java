package jeu;

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
}
