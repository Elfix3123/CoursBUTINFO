import java.util.Scanner;

public class Moi {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		System.out.println("Saisissez votre nom :");
		String nom = lecteur.nextLine();
		System.out.println("Saisissez votre prenom :");
		String prenom = lecteur.nextLine();
		System.out.println("Saisissez votre age :");
		int age = lecteur.nextInt();
		lecteur.nextLine();
		System.out.println("Saisissez votre groupe de TP :");
		String groupe = lecteur.nextLine();

		System.out.println("-----------------------------------------------------------------\n" +
		"RENSEIGNEMENTS VOUS CONCERNANT\n" +
		"-----------------------------------------------------------------\n" +
		"Identité : " + prenom + " " + nom +
		"\nÂge : " + age +
		" ans\nGroupe de TP: " + groupe +
		"\n-----------------------------------------------------------------");

		lecteur.close();
	}
}
