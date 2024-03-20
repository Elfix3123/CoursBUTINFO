package tp04.tabledemultiplication;

import java.util.ArrayList;
import java.util.Collections;

public class TableDeMultiplication {
	private ArrayList<Multiplication> multiplications;
	private int nombreTable;
	private boolean modeSansErreur;

	/**
	 * Constructeur d'une table de multiplication.
	 * 
	 * @param nombreTable le nombre de la table
	 * @param estMelange si la table est mélangée ou non
	 */
	public TableDeMultiplication(int nombreTable, boolean estMelange, boolean modeSansErreur) {
		this.nombreTable = nombreTable;
		this.multiplications = new ArrayList<>();
		this.modeSansErreur = modeSansErreur;

		this.initialisation();

		if (estMelange) {
			this.melange();
		}
	}

	/**
	 * Initialise la table dans l'ordre.
	 */
	private void initialisation() {
		int i = 1;

		while (i < 11) {
			this.multiplications.add(new Multiplication(i, nombreTable, this.modeSansErreur));
			i++;
		}
	}

	/**
	 * Mélange les multiplications de la table.
	 */
	private void melange() {
		Collections.shuffle(this.multiplications);
	}

	/**
	 * Renvoie le nombre de réponses justes.
	 */
	public int getNombreReponsesJustes() {
		int nombreReponsesJustes = 0;

		for (Multiplication multiplication : this.multiplications) {
			if (multiplication.isReponseJuste()) {
				nombreReponsesJustes++;
			}
		}

		return nombreReponsesJustes;
	}

	/**
	 * Renvoie le nombre total de multiplications.
	 */
	public int getNombreDeMultiplications() {
		return this.multiplications.size();
	}

	/**
	 * Retourne un élément de multiplications.
	 * 
	 * @param index l'indice de l'élément
	 */
	public Multiplication getMultiplication(int index) {
		return this.multiplications.get(index);
	}
}
