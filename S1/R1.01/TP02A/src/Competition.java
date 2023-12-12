import java.util.Scanner;

public class Competition {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		float accumulateur = 0f;
		float temps;
		float min = 21;
		float max = 0;

		System.out.print("Nombre de juges ? ");
		int nbJuges = lecteur.nextInt();
		lecteur.nextLine();

		for(int i = 1; i <= nbJuges; i++){
			System.out.print("Temps estimé par le juge n°" + i + "? ");
			temps = lecteur.nextFloat();
			if(temps > 20f){System.out.println(">>> Saisie invalide, recommencez...");i--;}
			else{
				accumulateur+=temps;
				if(temps < min){min = temps;}
				if(temps > max){max = temps;}
			}
			lecteur.nextLine();
		}

		System.out.println("La moyenne de temps des juges est de " + accumulateur/nbJuges + " avec un minimum de " + min + " et un maximum de " + max);

		lecteur.close();
	}
}
