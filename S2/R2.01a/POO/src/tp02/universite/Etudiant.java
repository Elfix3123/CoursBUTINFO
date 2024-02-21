package tp02.universite;

import java.util.ArrayList;

import tp02.contrainte.Note;

/**
 * La classe Etudiant représente la notion d'Etudiant et hérite de la classe Personne.
 */
public class Etudiant extends Personne {
	private String adresseParent;
	private ArrayList<Note> notes;

	/**
	 * Constructeur d'Etudiant sans adresses.
	 * 
	 * @param login le login de l'Etudiant
	 * @param prenom le prénom de l'Etudiant
	 * @param nom le nom de l'Etudiant
	 */
	public Etudiant(String login, String prenom, String nom) {
		// Appel du constructeur de la classe parent
		super(login, prenom, nom);
		this.notes = new ArrayList<>();
	}

	/**
	 * Constructeur d'Etudiant.
	 * 
	 * @param login le login de l'Etudiant
	 * @param prenom le prénom de l'Etudiant
	 * @param nom le nom de l'Etudiant
	 */
	public Etudiant(String login, String prenom, String nom, String adresse, String adresseParent) {
		// Appel du constructeur de la classe parent
		super(login, prenom, nom);
		super.setAdresse(adresse);
		this.setAdresse(adresse, adresseParent);
		this.notes = new ArrayList<>();
	}


	/**
	 * Renvoie le mail de l'Etudiant.
	 *
	 * @return Le mail
	 */
	public String getMail() {
		return super.getPrenom() + "." + super.getNom() + "@etu.univ-grenoble-alpes.fr";
	}

	/**
	 * Getter de adresse.
	 * 
	 * @return l'adresse de l'instance courante d'Etudiant.
	 */
	public String getAdresse() {
		return super.getAdresse();
	}

	/**
	 * Getter de adresse des parents.
	 * 
	 * @return l'adresse des parents de l'instance courante d'Etudiant.
	 */
	public String getAdresseParents() {
		return this.adresseParent;
	}

	/**
	 * Vérifier l'existence d'au moins une adresse pour l'Etudiant.
	 *
	 * @return Vrai si l'Etudiant a au moins une adresse, Faux sinon
	 */
	public boolean existAdresse() {
		return super.existAdresse() | this.adresseParent != null;
	}

	/**
	 * Setter des adresses.
	 * 
	 * @param adresse l'adresse de Personne.
	 * @param adresseParent l'adresse des parents de Personne.
	 */
	public void setAdresse(String adresse, String adresseParent) {
		super.setAdresse(adresse);
		this.adresseParent = adresseParent;
	}

	/**
	 * Ajoute une note dans le vecteur de notes.
	 * 
	 * @param note
	 */
	public void addNote(double note) {
		this.notes.add(new Note(note));
	}

	/**
	 * Calcule et renvoie la moyenne de l'Etudiant.
	 * 
	 * @return la moyenne
	 */
	public double getMoyenne() {
		int i = 0;
		double somme = 0;

		while (i < this.notes.size()) {
			somme += this.notes.get(i).getValeur();
			i++;
		}

		return somme/i;
	}

	@Override
	public String toString() {
		return "{" +
			"Personne = '" + super.toString() + "'" +
			" adresseParent='" + this.getAdresseParents() + "'" +
			"}";
	}
}