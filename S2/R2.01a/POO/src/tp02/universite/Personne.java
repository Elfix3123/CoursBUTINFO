package tp02.universite;

/**
 * La classe Personne représente la notion de personne (login, nom, prénom
 et adresse).
 * ATTENTION des contraintes sur la notion de personne :
 * – une personne doit toujours avoir un login en minuscule
 * – une personne doit toujours avoir un nom et un prénom avec
 * le premier caractère en majuscule et les autres en minuscule.
 */
public abstract class Personne {
	private String login;
	private String prenom;
	private String nom;
	private String adresse;

	// Constructeurs de la classe
	/**
	 * Constructeur de Personne sans adresse.
	 * 
	 * @param login le login de la Personne
	 * @param prenom le prénom de la Personne
	 * @param nom le nom de la Personne
	 */
	Personne(String login, String prenom, String nom) {
		setLogin(login);
		setPrenom(prenom);
		setNom(nom);
	}

	/**
	 * Constructeur de Personne.
	 * 
	 * @param login le login de la Personne
	 * @param prenom le prénom de la Personne
	 * @param nom le nom de la Personne
	 * @param adresse l'adresse de la Personne.
	 */
	Personne(String login, String prenom, String nom, String adresse) {
		setLogin(login);
		setPrenom(prenom);
		setNom(nom);
	}

	// Getters
	/**
	 * Getter de login.
	 * 
	 * @return le login de l'instance courante de Personne
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Getter de nom.
	 * 
	 * @return le nom de l'instance courante de Personne
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Getter de prenom.
	 * 
	 * @return le prenom de l'instance courante de Personne
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Getter de adresse.
	 * 
	 * @return l'adresse de l'instance courante de Personne
	 */
	public String getAdresse() {
		return this.adresse;
	}

	// Setters
	/**
	 * Setter du login.
	 * 
	 * @param login le login de Personne.
	 */
	public void setLogin(String login) {
		this.login = login.toLowerCase();
	}

	/**
	 * Setter du nom.
	 * 
	 * @param nom le nom de Personne.
	 */
	public void setNom(String nom) {
		this.nom = UniversiteUtilitaire.capitalize(nom);
	}

	/**
	 * Setter du prenom.
	 * 
	 * @param prenom le prenom de Personne.
	 */
	public void setPrenom(String prenom) {
		this.prenom = UniversiteUtilitaire.capitalize(prenom);
	}

	/**
	 * Setter de adresse.
	 * 
	 * @param adresse l'adresse de Personne.
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	// Methodes de la classe
	/**
	 * Vérifier l'existence d'un adresse pour la personne.
	 *
	 * @return Vrai si la personne à une adresse, Faux sinon
	 */
	public boolean existAdresse() {
		return this.adresse != null;
	}

	/**
	 * Renvoie le nom complet de la personne.
	 *
	 * @return Le nom complet
	 */
	public String getNomComplet() {
		return this.prenom + " " +  this.nom;
	}

	/**
	 * Renvoie le mail de la personne.
	 *
	 * @return Le mail
	 */
	public abstract String getMail();


	@Override
	public String toString() {
		return "{" +
			" login='" + getLogin() + "'" +
			", prenom='" + getPrenom() + "'" +
			", nom='" + getNom() + "'" +
			", adresse='" + getAdresse() + "'" +
			"}";
	}
}
