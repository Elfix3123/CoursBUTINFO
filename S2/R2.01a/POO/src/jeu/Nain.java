package jeu;

/**
 * La classe Nain représete un guerrier nain du jeu Faërun.
 * Elle est une classe fille de Guerrier.
 */
public class Nain extends Guerrier{
	/**
	 * Fait subir des degats à l'instance courante de Nain.
	 * 
	 * @param degats les degats à subir
	 */
	protected void subirDegats(int degats) {
		super.subirDegats(degats/2);
	}
}
