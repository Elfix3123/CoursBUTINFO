import java.util.ArrayList;
import java.util.Scanner;

public class Comparaisons {
	public static void main(String[] args) {
		ArrayList<Polar> mesPolars = CreationBib.lesPolars();
		System.out.println(Utilitaire.triSelectNbComp(mesPolars));

		/*
		System.out.println("Nombre de comparaisons pour le tri par selection :");
		System.out.println(Utilitaire.triSelectNbComp(mesPolars));

		mesPolars = CreationBib.lesPolars();

		System.out.println("Nombre de comparaisons pour le tri par insertion :");
		System.out.println(Utilitaire.triInsertionNbComp(mesPolars));
		*/
		
		Scanner lecteur = new Scanner(System.in);

		String auteurTest;
		int anneeTest;

		System.out.print("Entrez le nom d'un auteur (chaine en majuscules) : ");
		auteurTest = lecteur.nextLine();

		System.out.print("Entrez une année (un entier) : ");
		anneeTest = lecteur.nextInt();

		PaireResultatCompteur<Integer> paireResultatSeq = Utilitaire.rechSeqT_O(mesPolars, anneeTest, auteurTest);
		System.out.println("Recherche séquentielle du premier roman policier écrit par " + auteurTest + " en " + anneeTest);
		if(paireResultatSeq.getRes() == -1){
			System.out.println("* Aucun roman trouvé...");
		}
		else{
		System.out.println("* " + mesPolars.get(paireResultatSeq.getRes()).getTitre() + " (trouvé à l'indice " + paireResultatSeq.getRes() + ")");
		}
		System.out.println("* Nombre de comparaisons effectuées : " + paireResultatSeq.getCompteur());

		PaireResultatCompteur<Integer> paireResultatDicho = Utilitaire.rechDicho_O(mesPolars, anneeTest, auteurTest);
		System.out.println("Recherche dichotomique du premier roman policier écrit par " + auteurTest + " en " + anneeTest);
		if(paireResultatDicho.getRes() == -1){
			System.out.println("* Aucun roman trouvé...");
		}
		else{
		System.out.println("* " + mesPolars.get(paireResultatDicho.getRes()).getTitre() + " (trouvé à l'indice " + paireResultatDicho.getRes() + ")");
		}
		System.out.println("* Nombre de comparaisons effectuées : " + paireResultatDicho.getCompteur());
	}
}
