import java.util.ArrayList;

public class PolarsEtTris {
	public static void affichePolars(ArrayList<Polar> vPolars){
		int i = 0;
		while(i < vPolars.size()){
			System.out.println("- Polar n°" + (i+1) + " : " + vPolars.get(i));
			i++;
		}
	}

	public static void main(String[] args) {
		ArrayList<Polar> lesPolars = CreationBib.lesPolars();

		/*		
		if(Utilitaire.verifTri(lesPolars)){
			System.out.println("lesPolars est trié par ordre strictement croissant");
		}
		else{
			System.out.println("lesPolars n'est pas trié par ordre strictement croissant");
		}
		
		int i = 0;
		while(i < lesPolars.size()){
			System.out.println("- Polar n°" + (i+1) + " : " + lesPolars.get(i));
			i++;
		}
		*/

		/* 
		// Intermède : vérification du code de compareTo et de toString
		Polar pol1 = new Polar(2000, "AUTEUR1", "Une oeuvre");
		Polar pol2 = new Polar(2000, "AUTEUR2", "Mon oeuvre");
		Polar pol3 = new Polar(1998, "AUTEUR1", "Oeuvre sans nom");
		System.out.print("pol1 : "); System.out.println(pol1);
		System.out.print("pol2 : "); System.out.println(pol2);
		System.out.print("pol3 : "); System.out.println(pol3);
		System.out.println("* pol1 comparé à pol2 : " + pol1.compareTo(pol2));
		System.out.println("* pol1 comparé à pol1 : " + pol1.compareTo(pol1));
		System.out.println("* pol1 comparé à pol3 : " + pol1.compareTo(pol3));
		*/

		/* 
		System.out.println("Le vecteur va être trié selon l'ordre (auteur, annee) par la méthode du tri par sélection");

		Utilitaire.triSelect(lesPolars);

		affichePolars(lesPolars);
		*/

		/* 
		System.out.println("Le vecteur va être trié selon l'ordre (auteur, annee) par la méthode du tri à bulles amélioré");

		Utilitaire.triBulle(lesPolars);

		affichePolars(lesPolars);
		*/

		
		System.out.println("Le vecteur va être trié selon l'ordre (auteur, annee) par la méthode du tri par insertion");

		Utilitaire.triInsertion(lesPolars);

		affichePolars(lesPolars);
		
		// Utilitaire.nbPolarAuteur(lesPolars);

		System.out.println(Utilitaire.auteursDeAn(lesPolars, 2001));
	}
}
