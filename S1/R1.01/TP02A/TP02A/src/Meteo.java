import java.util.Scanner;

public class Meteo {
	public static void main(String[] args){
		Scanner lecteur = new Scanner(System.in);

		System.out.print("Est-ce qu'il pleut ? (true ou false) ");
		boolean pluie = lecteur.nextBoolean();
		lecteur.nextLine();

		System.out.print("Avez-vous un chapeau ? (true ou false) ");
		boolean chapeau = lecteur.nextBoolean();
		lecteur.nextLine();

		System.out.print("Avez-vous un parapluie ? (true ou false) ");
		boolean parapluie = lecteur.nextBoolean();
		lecteur.nextLine();

		System.out.print("Portez-vous des tongs ? (true ou false) ");
		boolean tongs = lecteur.nextBoolean();
		lecteur.nextLine();

		boolean bonEquipement = (!pluie)|((parapluie|chapeau)&(!tongs));

		if(bonEquipement){
			System.out.println("\nVous êtes bien équipés !");
		}
		else{
			System.out.println("\nVous n'êtes pas bien équipés !");
		}

		lecteur.close();
	}
}
