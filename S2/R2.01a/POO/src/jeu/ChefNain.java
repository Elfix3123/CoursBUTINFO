package jeu;

/**
 * La classe ChefNain représete un guerrier chef nain du jeu Faërun.
 * Elle est une classe fille de Nain.
 */
public class ChefNain extends Nain{
	/**
	 * Fait subir des degats à l'instance courante de ChefNain.
	 * 
	 * @param degats les degats à subir
	 */
	protected void subirDegats(int degats) {
		super.subirDegats(degats/2);
	}
}
