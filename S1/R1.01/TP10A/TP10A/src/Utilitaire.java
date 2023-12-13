public class Utilitaire {
	public static ListeTrieeC<Integer> lCsansDoublons(ListeTrieeC<Integer> lC) {
		// { lC non vide, avec potentiellement des doublons } =>
		// { résultat = nouvelle liste triée croissante dont les cellules portent
		// les mêmes entiers que lC, mais sans doublons }
		ListeTrieeD<Integer> lDsd = new ListeTrieeD<>();
		lDsd.insereTrie(lC.getTete().getInfo());
		Cellule<Integer> celluleActive = lC.getTete().getCelluleSuivante();

		while (celluleActive != null) {
			if(lDsd.getTete().getInfo() != celluleActive.getInfo()){
				lDsd.insereTrie(celluleActive.getInfo());
			}
			celluleActive = celluleActive.getCelluleSuivante();
		}

		return lDsd.renverseListe();
	}
	
	public static boolean estDansListeC(ListeTrieeC<Integer> lC, int unEnt) {
		// { lC non vide, sans doublons } =>
		// { résultat = vrai s'il existe une cellule de lC portant l'entier unEnt,
		// faux sinon }
		return estDansListeC_wk(lC.getTete(), unEnt);
	}

	private static boolean estDansListeC_wk(Cellule<Integer> cellCour, int unEnt) {
		if(cellCour == null){
			return false;
		}
		else{
			return cellCour.getInfo() == unEnt || estDansListeC_wk(cellCour.getCelluleSuivante(), unEnt);
		}
	}

	public static ListeTrieeC<Integer> union(ListeTrieeC<Integer> lC1_sdb, ListeTrieeC<Integer> lC2_sdb) {
		// { lC1_sdb et lC2_sdb non vides, sans doublons } =>
		// { résultat = liste triée croissante, contenant, sans doublons,
		// les entiers portés par les cellules de lC1_sdb et
		// les entiers portés par les cellules de lC2_sdb }
		Cellule<Integer> celluleActive1 = lC1_sdb.getTete();
		Cellule<Integer> celluleActive2 = lC2_sdb.getTete();
		ListeTrieeD<Integer> listeUnion = new ListeTrieeD<>();

		while (celluleActive1 != null && celluleActive2 != null) {
			if(celluleActive1.getInfo() == celluleActive2.getInfo()){
				listeUnion.insereTrie(celluleActive1.getInfo());
				celluleActive1 = celluleActive1.getCelluleSuivante();
				celluleActive2 = celluleActive2.getCelluleSuivante();
			}
			else if (celluleActive1.getInfo() < celluleActive2.getInfo()) {
				listeUnion.insereTrie(celluleActive1.getInfo());
				celluleActive1 = celluleActive1.getCelluleSuivante();
			}
			else{
				listeUnion.insereTrie(celluleActive2.getInfo());
				celluleActive2 = celluleActive2.getCelluleSuivante();
			}
		}

		while (celluleActive1 != null) {
			listeUnion.insereTrie(celluleActive1.getInfo());
			celluleActive1 = celluleActive1.getCelluleSuivante();
		}

		while (celluleActive2 != null) {
			listeUnion.insereTrie(celluleActive2.getInfo());
			celluleActive2 = celluleActive2.getCelluleSuivante();
		}

		return listeUnion.renverseListe();
	}

	public static ListeTrieeC<Integer> intersect(ListeTrieeC<Integer> lC1_sdb, ListeTrieeC<Integer> lC2_sdb) {
		// { lC1_sdb et lC2_sdb non vides, sans doublons } =>
		// { résultat = liste triée croissante, contenant, sans doublons,
		// les entiers portés par les cellules de lC1_sdb qui sont
		// égaux à ceux portés par les cellules de lC2_sdb }
		Cellule<Integer> celluleActive1 = lC1_sdb.getTete();
		Cellule<Integer> celluleActive2 = lC2_sdb.getTete();
		ListeTrieeD<Integer> listeInter = new ListeTrieeD<>();

		while (celluleActive1 != null && celluleActive2 != null) {
			if(celluleActive1.getInfo() == celluleActive2.getInfo()){
				listeInter.insereTrie(celluleActive1.getInfo());
				celluleActive1 = celluleActive1.getCelluleSuivante();
				celluleActive2 = celluleActive2.getCelluleSuivante();
			}
			else if(celluleActive1.getInfo() > celluleActive2.getInfo()){
				celluleActive2 = celluleActive2.getCelluleSuivante();
			}
			else{
				celluleActive1 = celluleActive1.getCelluleSuivante();
			}
		}

		return listeInter.renverseListe();
	}
}
