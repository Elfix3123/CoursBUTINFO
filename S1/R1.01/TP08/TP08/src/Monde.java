import java.util.ArrayList;
import java.util.Scanner;

public class Monde {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		ArrayList<Pays> leMonde = InitMonde.creerMonde();
		Utilitaire.triFusion(leMonde, 0, leMonde.size()-1);

		System.out.println(Utilitaire.verifTriContNom(leMonde));
	}
}
