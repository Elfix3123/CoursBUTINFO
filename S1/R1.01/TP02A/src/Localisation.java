import java.util.Scanner;

public class Localisation {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		boolean jeu = true;

		while(jeu){
			System.out.println("Nous allons déterminer votre position géographique par rapport à un point de référence ...");
			System.out.print("* Abscisse de votre position ? ");
			int x = lecteur.nextInt();
			lecteur.nextLine();

			System.out.print("* Ordonnée de votre position ? ");
			int y = lecteur.nextInt();
			lecteur.nextLine();

			String position = "";

			if(y > 0){position = "Nord-";}
			else if(y<0){position = "Sud-";}

			if(x < 0){position += "Ouest";}
			else if(x > 0){position += "Est";}

			if((x == 0)&(y == 0)){position = "Centre";}

			System.out.println("Position : " + position);

			System.out.println("Continuer à jouer ? (true ou false)");
			jeu = lecteur.nextBoolean();
		}
		lecteur.close();
	}	
}
