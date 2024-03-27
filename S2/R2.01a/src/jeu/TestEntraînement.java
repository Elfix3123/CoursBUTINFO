import elements.Chateau;
import elements.Couleur;
import guerriers.*;
import test.jeu.elements.*;

public class TestEntraînement {
	public static void main(String[] args) {
		// Création d'un château
		Chateau chateauRouge = new Chateau(Couleur.ROUGE);
		
		// Création des guerriers
		Guerrier guerrier = new Nain();
		Elfe elfe = new Elfe();
		ChefNain chefNain = new ChefNain();

		// Ajout des guerriers aux châteaux
		guerrier.setChateau(chateauRouge);
		elfe.setChateau(chateauRouge);
		chefNain.setChateau(chateauRouge);

		// Entrainement des guerriers
		System.out.println(chateauRouge.entrainer());
	}
}
