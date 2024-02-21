package tp02.telephone;

/**
 * Cette classe vise à implémenter la mémoire.
 */
public class Memoire {
	private String type;
	private int nombreGiga;

	/**
	 * Constructeur de Memoire.
	 * 
	 * @param type
	 * @param nombreGiga
	 */
	public Memoire(String type, int nombreGiga) {
		this.type = type;
		this.nombreGiga = nombreGiga;
	}

	/**
	 * Getter de type
	 * 
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Getter de nombreGiga
	 * 
	 * @return nombreGiga
	 */
	public int getNombreGiga() {
		return this.nombreGiga;
	}


	@Override
	public String toString() {
		return this.type + " " + this.nombreGiga + "G";
	}	
}
