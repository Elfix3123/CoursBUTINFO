import java.util.Scanner;

public class ConversionsBis {
	public static void main(String[] args) {
		final float EURTOUSD = 1.07f;
		final float EURTOCHF = 0.96f;
		final float EURTOGPB = 0.86f;

		Scanner lecteur = new Scanner(System.in);

		System.out.println("Saisissez un montant en EUR à convertir :");
		float eur = lecteur.nextFloat();
		lecteur.nextLine();
		System.out.println("Saisissez en quelle devise convertir :");
		String devise = lecteur.nextLine();

		lecteur.close();

		if(devise.equals("USD")){
			System.out.println(eur + "EUR se converti en " + (eur * EURTOUSD) + "USD");
		}
		else if(devise.equals("CHF")){
			System.out.println(eur + "EUR se converti en " + (eur * EURTOCHF) + "CHF");
		}
		else if(devise.equals("GPB")){
			System.out.println(eur + "EUR se converti en " + (eur * EURTOGPB) + "GPB");
		}
		else{
			System.out.println("Devise non valide !");
		}
	}
}
