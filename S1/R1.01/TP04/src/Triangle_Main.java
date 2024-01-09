import java.util.Scanner;

public class Triangle_Main {
	public static void main(String[] args) {
		Point ptA = new Point(1, 1);
		Point ptB = new Point(3, 5);
		Point ptC = new Point(5, 1);

		TriangleCompose tComp = new TriangleCompose(ptA, ptB, ptC);
		TriangleAgrege tAgr = new TriangleAgrege(ptA, ptB, ptC);

		int dx;
		int dy;

		System.out.println("----------------------------------------------------------------------------------------------------" +
		"\nCoordonnées initiales des points ptA, ptB et ptC : ptA" + ptA + " ptB" + ptB + " ptC" + ptC +
		"\n----------------------------------------------------------------------------------------------------");

		System.out.println("Triangle construit avec les points ptA, ptB et ptC en composition\n" + tComp);
		System.out.println("------------");
		System.out.println("Triangle construit avec les points ptA, ptB et ptC en agrégation\n" + tAgr);

		System.out.println("-----------------------------------------\n" +
		"DÉPLACEMENT DES TRIANGLES\n" +
		"-----------------------------------------");

		Scanner lecteur = new Scanner(System.in);
		
		System.out.println("Déplacement horizontal des sommets : ");
		dx = lecteur.nextInt();
		lecteur.nextLine();

		System.out.println("Déplacement vertical des sommets : ");
		dy = lecteur.nextInt();
		lecteur.nextLine();

		tComp.deplacer(dx, dy);

		System.out.println("======================================================================\n" + 
		"Après déplacement du triangle construit avec les points ptA, ptB et ptC en composition\n" + 
		"======================================================================");

		System.out.println("----------------------------------------------------------------------------------------------------" +
		"\nCoordonnées des points ptA, ptB et ptC : ptA" + ptA + " ptB" + ptB + " ptC" + ptC +
		"\n----------------------------------------------------------------------------------------------------");

		System.out.println("Caractéristiques du triangle :\n" + tComp);
		
		tAgr.deplacer(dx, dy);

		System.out.println("======================================================================\n" + 
		"Après déplacement du triangle construit avec les points ptA, ptB et ptC en agrégation\n" + 
		"======================================================================");

		System.out.println("----------------------------------------------------------------------------------------------------" +
		"\nCoordonnées des points ptA, ptB et ptC : ptA" + ptA + " ptB" + ptB + " ptC" + ptC +
		"\n----------------------------------------------------------------------------------------------------");

		System.out.println("Caractéristiques du triangle :\n" + tComp);
	}
}
