package tp04.tabledemultiplication;

import java.util.Scanner;

public class TestTableDeMultiplication {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		System.out.print("Donner un nombre pour la table de multiplication entre 1 et 10 : ");
		int nombreTable = lecteur.nextInt();

		while (!(1 <= nombreTable & nombreTable <= 10)) {
			System.out.print("Merci de répondre entre 1 et 10 ? ");
			nombreTable = lecteur.nextInt();
		}

		System.out.print("Entrainement 1 ou exercice 2 ? ");
		int choix = lecteur.nextInt();
		while (!(choix == 1 | choix == 2)) {
			System.out.print("Merci de répondre par 1 ou 2 ? ");
			choix = lecteur.nextInt();
		}

		System.out.print("Mode sans erreur true ou false ? ");
		boolean modeSansErreur = lecteur.nextBoolean();

		System.out.println("Donner les réponses aux multiplications :");

		TableDeMultiplication table = new TableDeMultiplication(nombreTable, choix == 2, modeSansErreur);
		int i = 0;


		while (i < table.getNombreDeMultiplications()) {
			System.out.print(table.getMultiplication(i).toString());
			try {
				table.getMultiplication(i).setReponseUtilisateur(lecteur.nextInt());
			}
			catch (ErreurMultiplicationException e) {
				System.out.println("Votre réponse n'est pas correcte, réessayer !");
				i--;
			}
			i++;
		}

		if (!modeSansErreur) {
			System.out.println("Nombre de réponses justes : " + table.getNombreReponsesJustes());
		}
	}
}
