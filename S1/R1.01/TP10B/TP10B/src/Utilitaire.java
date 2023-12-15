public class Utilitaire {
	public static void afficheListeCat(ListeTrieeC<Categorie> lCategories) {
		// { } => { les éléments de lCategories ont été affichés }
		Cellule<Categorie> catCour = lCategories.getTete();
		System.out.println("LISTE DES CATEGORIES D'INSTRUMENTS");
		for (int i = 0; i < lCategories.getLongueur(); i++) {
		catCour.getInfo().afficheCat();
		System.out.println(" " + '↡');
		catCour = catCour.getCelluleSuivante();
		}
	}
}
