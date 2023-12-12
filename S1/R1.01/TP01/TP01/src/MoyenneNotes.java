import java.util.Scanner;

public class MoyenneNotes {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		
		System.out.println("De combien de accumulateur souhaitez-vous calculer la moyenne ?");
		int nbNotes = lecteur.nextInt();
		lecteur.nextLine();
		float accumulateur = 0;

		for(int i = 0; i < nbNotes; i++){
			System.out.println("Saisissez la note numero " + i);
			accumulateur += lecteur.nextFloat();
			lecteur.nextLine();
		}

		System.out.println("La moyenne de toutes les notes est " + accumulateur/nbNotes);
		lecteur.close();
	}
}
