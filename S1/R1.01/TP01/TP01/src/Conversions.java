import  java.util.Scanner;

public class Conversions {
	public static void main(String[] args) {
		float dollars, euros;
		final float ratioDE = 0.89f;
		Scanner lecteur = new Scanner(System.in);

		System.out.println("Saisissez un montant en dollars à convertir");
		dollars = lecteur.nextFloat();
		lecteur.nextLine();
		euros = dollars * ratioDE;
		System.out.println(dollars + " converti en euros avec le taux de 1 dollar = " + ratioDE + " euros est " + euros);

		System.out.println("Saisissez un montant en euros à convertir");
		euros = lecteur.nextFloat();
		lecteur.nextLine();
		dollars = euros / ratioDE;
		System.out.println(euros + " converti en dollars avec le taux de 1 euro = " + 1/ratioDE + " dollars est " + dollars);

		lecteur.close();
	}
}
