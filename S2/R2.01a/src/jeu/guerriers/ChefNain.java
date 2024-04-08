package jeu.guerriers;

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

	/**
	 * Retourne le nombre de ressources nécessaires pour entraîner l'instance courante de ChefNain.
	 * 
	 * @return l'attribut RESSOURCE_BASE de l'instance courante de ChefNain
	 */
	public int getRessourcesPourEntrainement() {
		return super.getRessourcesPourEntrainement() * 3;
	}
}
