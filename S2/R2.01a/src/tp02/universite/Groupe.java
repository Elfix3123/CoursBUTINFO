package tp02.universite;

import java.util.TreeSet;

/*
 * Cette classe représente un groupe d'étudiants.
 */
public class Groupe {
	private String libelle;
	private TreeSet<Etudiant> etudiants;

	/**
	 * Constructeur de la classe Groupe.
	 * 
	 * @param libelle le libellé du groupe
	 */
	public Groupe(String libelle) {
		this.libelle = libelle;
		this.etudiants = new TreeSet<>();
	}

	/**
	 * Retourne le libellé de l'instance courante de Groupe.
	 * 
	 * @return libelle le libellé du groupe
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Setter de libelle.
	 * 
	 * @param libelle le libellé du groupe
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Ajoute un étudiant au groupe courant.
	 * 
	 * @param etudiant l'étudiant à ajouter
	 */
	public void ajouterEtudiant(Etudiant etudiant) {
		this.etudiants.add(etudiant);
		if (etudiant.getGroupe() != this) {
			etudiant.setGroupe(this);
		}
	}

	/**
	 * Enlève un étudiant du groupe courant.
	 * 
	 * @param etudiant l'étudiant à enlever
	 */
	public void enleverEtudiant(Etudiant etudiant) {
		this.etudiants.remove(etudiant);
		etudiant.setGroupe(null);
	}

	/**
	 * Vérifie si le groupe courant contient un étudiant.
	 * 
	 * @param etudiant l'étudiant à vérifier
	 */
	public boolean contientEtudiant(Etudiant etudiant) {
		return this.etudiants.contains(etudiant);
	}

	/**
	 * Retourne la colléction d'étudiants du groupe courant.
	 * 
	 * @return etudiants la collection d'étudiants
	 */
	public TreeSet<Etudiant> getEtudiants() {
		return this.etudiants;
	}
}
