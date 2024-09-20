import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompareRech {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);

		// ArrayList<Integer> vInt = new ArrayList<>(Arrays.asList(-45, -45, -10, 9, 10, 20, 30, 75, 90));
		ArrayList<Integer> vInt = Utilitaire.genVectSansDoublons(160);
		Utilitaire.triBulle_O(vInt);

		System.out.println(vInt + " : " + vInt.size() + " éléments");

		System.out.print("Saisissez un entier : ");
		int unInt = lecteur.nextInt(); 
		lecteur.nextLine();

		System.out.println("* Resultat de la recherche séquentielle itérative : " + Utilitaire.rechSeqIt_O(vInt, unInt));
		System.out.println("* Resultat de la recherche dichotomique itérative : " + Utilitaire.rechDichoIt_O(vInt, unInt));
		System.out.println("* Resultat de la recherche dichotomique récursive : " + Utilitaire.rechDichoRec_O(vInt, unInt));
	}
}
