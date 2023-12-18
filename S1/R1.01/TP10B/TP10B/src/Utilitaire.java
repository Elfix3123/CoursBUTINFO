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

	public static Instrument chercheInstrument(ListeTrieeC<Categorie> lCategories, String nomCat, String nomInst) {
		// { } =>
		// { résultat = Instrument dont l'attribut nomInstrument est nomInst si trouvé,
		// null sinon }
		Cellule<Categorie> celluleActiveCategorie = lCategories.getTete();

		while (celluleActiveCategorie != null && (celluleActiveCategorie.getInfo().getNomCat().compareTo(nomCat) != 0)) {	// On commence par chercher la bonne catégorie
			celluleActiveCategorie = celluleActiveCategorie.getCelluleSuivante();
		}

		Cellule<Instrument> celluleActiveInstrument = celluleActiveCategorie.getInfo().getLInstruments().getTete();

		while () {
			
		}
	}
}
