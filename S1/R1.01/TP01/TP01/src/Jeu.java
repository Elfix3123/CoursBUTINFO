import java.util.Scanner;

public class Jeu {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		int resultat;
		System.out.print("BONJOUR !\nDonnez votre nom : ");
		final String nom = lecteur.nextLine();
		System.out.print("Donnez votre année de naissance : ");
		final int annee = lecteur.nextInt();
		lecteur.nextLine();
		System.out.print("Donnez votre pointure : ");
        final int pointure = lecteur.nextInt();
		lecteur.nextLine();
		resultat = pointure * 5;
		System.out.println("(1) On multiplie votre pointure par 5 : " + resultat);
		resultat += 50;
		System.out.println("(2) On ajoute 50 : " + resultat);
		resultat *= 20;
		System.out.println("(3) On multiplie par 20 : " + resultat);
		resultat += 1022;
		System.out.println("(4) On ajoute 1022 : " + resultat);
		resultat -= annee;
		System.out.println("(1) On soustrait votre année de naissance :\n----------------\nRESULTAT = " + resultat + 
		"\n----------------\nLes 2 premiers chiffres sont : " + resultat/100 + 
		"\n> C'est votre pointure !!!\nLes 2 derniers chiffres sont : " + resultat%100 +
		"\n> C'est l'âge que vous atteignez cette année !!!\nAU REVOIR " + nom + " !");
		lecteur.close();
	}
}
