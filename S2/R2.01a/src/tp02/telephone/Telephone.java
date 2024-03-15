package tp02.telephone;

import java.util.ArrayList;

public class Telephone {
	private String libelle;
	private Processeur processeur;
	private Memoire stockage;
	private ArrayList<Memoire> memoire;
	private Ecran ecran;

	/**
	 * Constructeur de Telephone.
	 * 
	 * @param libelle
	 * @param processeur
	 * @param stockage
	 * @param ecran
	 */
	public Telephone(String libelle, Processeur processeur, Memoire stockage, Ecran ecran) {
		this.libelle = libelle;
		this.processeur = processeur;
		this.stockage = stockage;
		this.memoire = new ArrayList<>();
		this.ecran = ecran;
	}

	/**
	 * Ajoute ram à la mémoire de l"instance courante de Telephone.
	 * 
	 * @param ram
	 */
	public void addRam(Memoire ram) {
		this.memoire.add(ram);
	}

	/**
	 * Renvoie la quantité totale de ram de l"instance courante de Telephone.
	 * 
	 * @return le total de ram
	 */
	public int getNombreGigaRam() {
		int i = 0;
		int total = 0;

		while (i < this.memoire.size()) {
			total += memoire.get(i).getNombreGiga();
			i++;
		}

		return total;
	}

	@Override
	public String toString() {
		String stringRam = "[" + this.memoire.get(0).toString();
		int i = 1;

		while (i < this.memoire.size()) {
			stringRam += " + " + this.memoire.get(i).toString();
			i++;
		}

		stringRam += "]";

		return this.libelle + 
		", processeur = " + this.processeur.toString() +
		", ram = " + this.getNombreGigaRam() + "Giga " + stringRam +
		", stockage = [" + this.stockage.toString() + "]" +
		", ecran = [" + this.ecran.toString() + "]";
	}
}