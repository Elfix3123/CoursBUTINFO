/*package jeu;

public class TestGuerrier {
	public static void main(String[] args) {
		Guerrier guerrier1 = new Guerrier();
		Guerrier guerrier2 = new Guerrier();

		System.out.println("Guerrier 1 : " + guerrier1);
		System.out.println("Guerrier 2 : " + guerrier2);
		System.out.println();

		System.out.println("Attaque du guerrier 1 sur le guerrier 2...");
		guerrier1.attaquer(guerrier2);
		System.out.println("Guerrier 1 : " + guerrier1);
		System.out.println("Guerrier 2 : " + guerrier2);
		System.out.println();

		System.out.println("Combat à mort entre les deux guerriers...");
		int i = 0;
		while (guerrier1.estVivant() & guerrier2.estVivant()) {
			if (i % 2 == 1) {
				guerrier1.attaquer(guerrier2);
			}
			else {
				guerrier2.attaquer(guerrier1);
			}
			System.out.println("Guerrier 1 : " + guerrier1);
			System.out.println("Guerrier 2 : " + guerrier2);
			System.out.println();

			i++;
		}
	}
}
*/