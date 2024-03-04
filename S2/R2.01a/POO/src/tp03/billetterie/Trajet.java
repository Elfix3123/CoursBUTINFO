package tp03.billetterie;

/* 
 * Cette classe représente un trajet entre deux villes.
 */
public class Trajet {
	private String depart;
	private String arrivee;
	private int distance;

	/* 
	 * Constructeur de la classe Trajet.
	 * 
	 * @param depart la ville de départ
	 * @param arrivee la ville d'arrivée
	 * @param distance la distance entre les deux villes
	 */
	public Trajet(String depart, String arrivee, int distance) {
		this.setDepart(depart);
		this.setArrivee(arrivee);
		this.setDistance(distance);
	}

	/*
	 * Retourne la ville de depart.
	 * 
	 * @return depart
	 */
	public String getDepart() {
		return this.depart;
	}

	/*
	 * Retourne la ville d'arrivée.
	 * 
	 * @return arrivee
	 */
	public String getArrivee() {
		return this.arrivee;
	}

	/*
	 * Retourne la distance entre les deux villes.
	 * 
	 * @return dista
	 */
	public int getDistance() {
		return this.distance;
	}

	/*
	 * Setter de depart.
	 * 
	 * @param depart la ville de départ
	 */
	public void setDepart(String depart) {
		this.depart = depart.toUpperCase();
	}

	/*
	 * Setter de arrivee.
	 * 
	 * @param arrivee la ville d'arrivée
	 */
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee.toUpperCase();
	}

	/*
	 * Setter de distance.
	 * 
	 * @param distance la distance entre les deux villes
	 */
	public void setDistance(int distance) {
		if (distance < 5) {
			this.distance = 5;
		}
		else if (distance > 2000) {
			this.distance = 2000;
		}
		else {
			this.distance = distance;
		}
	}

	/*
	 * Retourne une représentation textuelle de l'instance courante de Trajet.
	 * 
	 * @return la représentation de Trajet
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : " + this.getDepart() + " -> " + this.getArrivee() + " (" + this.getDistance() + " km)";
	}
}
