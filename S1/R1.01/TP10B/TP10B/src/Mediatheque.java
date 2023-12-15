public class Mediatheque {
	public static void main(String[] args) {
		ListeTrieeC<Categorie> lCategories = new ListeTrieeC<>();
		Categorie casserolerie = new Categorie("casserolerie");
		Categorie vaisselle = new Categorie("vaisselle");

		lCategories.insereTrie(vaisselle);
		lCategories.insereTrie(casserolerie);

		casserolerie.getLInstruments().insereTrie(new Instrument("wok", 3));
		vaisselle.getLInstruments().insereTrie(new Instrument("verre ballon", 10));
		vaisselle.getLInstruments().insereTrie(new Instrument("assiette", 5));

		Utilitaire.afficheListeCat(lCategories);

		try{
			casserolerie.getLInstruments().getInfoAtPosit(1).retraitExemplaires(2);
		}
		catch(ExceptionDefautDispo|ExceptionMauvaisIndice e){
			System.out.println(e);
		}
		try{
			vaisselle.getLInstruments().getInfoAtPosit(2).retraitExemplaires(15);
		}
		catch(ExceptionDefautDispo|ExceptionMauvaisIndice e){
			System.out.println(e);
		}
		try{
			casserolerie.getLInstruments().getInfoAtPosit(1).renduExemplaires(1);
		}
		catch(ExceptionMauvaisIndice e){
			System.out.println(e);
		}

		Utilitaire.afficheListeCat(lCategories);
	}
}