import java.util.Scanner;

public class Es {
	public static void main(String[] args) {
		int n;
		float r;
		char car;
		String ch;
		// création d'un lecteur sur la console
		Scanner lecteur = new Scanner(System.in);

		System.out.print("saisir un entier  : ");
		n = lecteur.nextInt();
		lecteur.nextLine();
		System.out.print("saisir un réel (avec une virgule comme séparateur décimal) : ");
		r = lecteur.nextFloat();
		lecteur.nextLine();
		System.out.print("saisir une chaîne de caractères  : ");
		ch = lecteur.nextLine();
		System.out.print("Saisir un caractère  : ");
		car = lecteur.next().charAt(0);
		lecteur.nextLine();
		System.out.println("n = " + n + "\nr = " + r + "\ncar = " + car + "\nch = " + ch);

		lecteur.close();
	}
}
