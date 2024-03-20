package elements;

import java.util.ArrayList;

import guerriers.Guerrier;

/**
 * Cette classe représente un plateau du jeu de Faerun.
 */
public class Plateau {
	ArrayList<Carreau> carreaux;

	/**
	 * Constructeur de la classe Plateau.
	 * 
	 * @param longueur la longueur du plateau
	 */
	public Plateau(int longueur) {
		carreaux = new ArrayList<Carreau>();
		
		int i = 0;

		while (i < longueur) {
			carreaux.add(new Carreau());
			i++;
		}
	}

	/**
	 * Ajoute des guerriers de la couleur du chateau en paramètre à l'instance de plateau courante, à la première case de la couleur du chateau.
	 * 
	 * @param Chateau le chateau dont on veut ajouter les guerriers
	 * @param ArrayList<Guerrier> les guerriers à ajouter
	 */
	public void ajoutGuerriers(Chateau chateau, ArrayList<Guerrier> guerriers) {
		if (chateau.getCouleur() == Couleur.BLEU) {
			this.getCaseDepartBleus().ajoutGuerriersBleus(guerriers);
		} else {
			this.getCaseDepartRouges().ajoutGuerriersRouges(guerriers);
		}
	}

	/**
	 * Renvoie la case de départ des bleus.
	 * 
	 * @return Carreau la case de départ des bleus
	 */
	public Carreau getCaseDepartBleus() {
		return carreaux.get(0);
	}

	/**
	 * Renvoie la case de départ des rouges.
	 * 
	 * @return Carreau la case de départ des rouges
	 */
	public Carreau getCaseDepartRouges() {
		return carreaux.get(carreaux.size() - 1);
	}

	/**
	 * Déplace tous les guerriers du plateau.
	 * 
	 * NE FONCTIONNE PAS ENCORE
	 */
	public void deplacerGuerriers() {
		int i = 0;
		ArrayList<Guerrier> guerriersBleusTemp = new ArrayList<Guerrier>();

		while (i < this.carreaux.size()) {
			if (this.carreaux.get(i).estBleu() & i < this.carreaux.size() - 1) {
				guerriersBleusTemp = this.carreaux.get(i).retirerGuerriersBleus();
			}

			this.carreaux.get(i).ajoutGuerriersBleus(guerriersBleusTemp);

			if (this.carreaux.get(i).estRouge() & i > 0) {
				this.carreaux.get(i-1).ajoutGuerriersRouges(this.carreaux.get(i).retirerGuerriersRouges());
			}
		}
	}
}
