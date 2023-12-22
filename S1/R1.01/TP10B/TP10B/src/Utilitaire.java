import java.util.ArrayList;

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

		while (celluleActiveInstrument != null && (celluleActiveInstrument.getInfo().getNomInstrument().compareTo(nomInst) != 0)) {	// On cherche le bon instrument dans la catégorie
			celluleActiveInstrument = celluleActiveInstrument.getCelluleSuivante();
		}

		return celluleActiveInstrument.getInfo();
	}

	public static ArrayList<String> vNomsDesCat(ListeTrieeC<Categorie> lCategories) {
		// { } =>
		// { résultat = vecteur de chaînes trié croissant, contenant les valeurs de
		// l'attribut nomCat de chaque élément de lCategories }
		ArrayList<String> nomsCat = new ArrayList<>();
		Cellule<Categorie> celluleActive = lCategories.getTete();

		while (celluleActive != null) {
			celluleActive = celluleActive.getCelluleSuivante();
		}
	}
}
