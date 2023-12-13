import java.util.Scanner;

public class Triangle_Main2 {
	public static void main(String[] args) {
		Point ptA;
		Point ptB;
		Point ptC;

		System.out.println("---------------------------------------------------------------------\n" +
		"Saisie des trois sommets ptA, ptB et ptC d'un triangle\n" +
		"---------------------------------------------------------------------");

		System.out.println("(1) Coordonnées du sommet ptA");
		ptA = Triangle_Utilitaire.saisirPoint();

		System.out.println("(2) Coordonnées du sommet ptB");
		ptB = Triangle_Utilitaire.saisirPointNonConfondu(ptA);

		System.out.println("(3) Coordonnées du sommet ptC");
		ptC = Triangle_Utilitaire.saisirPointNonAligneP1P2(ptA, ptB);

		System.out.println("--------------------------------------------------------------------------------------------------\n" + 
		"Coordonnées initiales des points ptA, ptB et ptC : ptA(3, 2) B(3, -2) ptC(5, 2)\n" + 
		"--------------------------------------------------------------------------------------------------");

		TriangleCompose tComp = new TriangleCompose(ptA, ptB, ptC);

		TriangleCompose tCompH = Triangle_Utilitaire.symetriqueH(tComp);
		TriangleCompose tCompV = Triangle_Utilitaire.symetriqueV(tComp);

		System.out.println("Triangle construit avec les points ptA, ptB et ptC en composition");
		System.out.println(tComp);

		System.out.println("Triangle symétrique par rapport à l'axe horizontal");
		System.out.println(tCompH);

		System.out.println("Triangle symétrique par rapport à l'axe vertical");
		System.out.println(tCompV);

		System.out.println("---------------------------------------------------------\n" +
				"DÉPLACEMENT DU TRIANGLE (ptA,ptB,ptC)\n" +
				"---------------------------------------------------------");
		
		Scanner lecteur = new Scanner(System.in);

		System.out.println("Déplacement horizontal des sommets : ");
		int dx = lecteur.nextInt();
		lecteur.nextLine();

		System.out.println("Déplacement vertical des sommets : ");
		int dy = lecteur.nextInt();
		lecteur.nextLine();

		tComp.deplacer(dx, dy);

		System.out.println("======================================================================\n" +
				"Après déplacement du triangle construit avec les points ptA, ptB et ptC en composition\n" +
				"======================================================================");
		
		System.out.println("Triangle construit avec les points ptA, ptB et ptC en composition");
		System.out.println(tComp);

		System.out.println("Triangle symétrique par rapport à l'axe horizontal");
		System.out.println(tCompH);

		System.out.println("Triangle symétrique par rapport à l'axe vertical");
		System.out.println(tCompV);
	}
}
