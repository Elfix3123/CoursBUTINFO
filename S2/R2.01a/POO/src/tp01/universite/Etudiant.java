package tp01.universite;

public class Etudiant {
	/**
	* La classe Etudiant représente la notion d'étudiant (login, nom, prénom
	et adresse).
	* ATTENTION des contraintes sur la notion d’étudiant :
	* – un étudiant doit toujours avoir un login en minuscule
	* – un étudiant doit toujours avoir un nom et un prénom avec
	* le premier caractère en majuscule et les autres en minuscule.
	*/
	private String login;
	private String prenom;
	private String nom;
	private String adresse;
	private double[] notes = new double[5];
	private int indiceDeNotes = 0;

	// Constructeur de la classe
	public Etudiant(String login, String prenom, String nom) {
		setLogin(login);
		setPrenom(prenom);
		setNom(nom);
	}

	// Getters
	public String getLogin() {
		return this.login;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public double[] getNotes() {
		return this.notes;
	}

	public int getIndiceDeNotes() {
		return this.indiceDeNotes;
	}

	// Setters
	public void setLogin(String login) {
		this.login = login.toLowerCase();
	}

	public void setNom(String nom) {
		this.nom = EtudiantUtilitaire.capitalize(nom);
	}

	public void setPrenom(String prenom) {
		this.prenom = EtudiantUtilitaire.capitalize(prenom);
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	// Methodes de la classe
	/**
	 * Vérifier l'existence d'un adresse pour l'étudiant
	 *
	 * @return Vrai si l'étudiant à une adresse, Faux sinon
	 */
	public boolean existAdresse() {
		return this.adresse != null;
	}

	/**
	 * Renvoie le nom complet de l'étudiant
	 *
	 * @return le nom complet
	 */
	public String getNomComplet() {
		return this.prenom + " " +  this.nom;
	}

	/**
	 * Renvoie le mail de l'étudiant
	 *
	 * @return le mail
	 */
	public String getMail() {
		return this.prenom + "." + this.nom + "@etu.univ-grenoble-alpes.fr";
	}

	/**
	 * Ajoute des notes à l'étudiant dans la limite de 5
	 */
	public void addNote(double note) {
		if (this.indiceDeNotes < 5) {
			this.notes[this.indiceDeNotes] = note;
			this.indiceDeNotes++;
		}
	}

	/**
	 * Calcule la moyenne des notes de l'etudiant
	 * 
	 * @return la moyenne si on peut la calculer, -1 sinon
	 */

	 public double getMoyenne() {
		if (this.indiceDeNotes > 0) {
			int i = 0;
			int somme = 0;

			while (i < this.indiceDeNotes) {
				somme += this.notes[i];
				i++;
			}

			return somme/this.indiceDeNotes;
		}
		else {
			return -1;
		}
	}
}
