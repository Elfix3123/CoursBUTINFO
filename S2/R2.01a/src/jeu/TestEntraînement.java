package jeu;

public class TestEntraînement {
	public static void main(String[] args) {
		// Création d'un château
		Chateau chateauRouge = new Chateau(Couleur.ROUGE);
		
		// Création des guerriers
		Guerrier guerrier = new Guerrier();
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
