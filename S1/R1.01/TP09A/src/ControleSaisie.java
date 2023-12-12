import java.util.Scanner;

public class ControleSaisie {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		System.out.println(Utilitaire.getInt_IME(lecteur));
		System.out.println(Utilitaire.getIntMinMax_IME(lecteur, 0, 10));
		System.out.println(Utilitaire.getInt_NFE(lecteur));
		System.out.println(Utilitaire.getFloat_NFE(lecteur));
	}
}
