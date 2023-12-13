import java.util.Scanner;

public class Triangle_Utilitaire {
	public static Point saisirPoint() {
		// { } => {résultat = un Point dont les coordonnées
		// sont saisies par l'utilisateur}
		Scanner lecteur = new Scanner(System.in);

		System.out.println("* Abscisse ? ");
		int pointX = lecteur.nextInt();
		lecteur.nextLine();

		System.out.println("* Ordonnée ? ");
		int pointY = lecteur.nextInt();
		lecteur.nextLine();

		return new Point(pointX, pointY);
	}

	public static Point saisirPointNonConfondu(Point lePoint) {
		// { } => {résultat = un Point non confondu avec lePoint,
		// dont les coordonnées sont saisies par l'utilisateur}
		Scanner lecteur = new Scanner(System.in);

		System.out.println("Saisie d'un point non confondu avec le point " + lePoint);

		System.out.println("* Abscisse ? ");
		int pointX = lecteur.nextInt();
		lecteur.nextLine();

		System.out.println("* Ordonnée ? ");
		int pointY = lecteur.nextInt();
		lecteur.nextLine();

		while((pointX == lePoint.getX())&(pointY == lePoint.getY())){
			System.out.println("--> Point confondu avec " + lePoint + ", recommencez...");

			System.out.println("* Abscisse ? ");
			pointX = lecteur.nextInt();
			lecteur.nextLine();

			System.out.println("* Ordonnée ? ");
			pointY = lecteur.nextInt();
			lecteur.nextLine();
		}

		return new Point(pointX, pointY);
	}

	public static Point saisirPointNonAligneP1P2(Point P1, Point P2) {
		// { } => { résultat = un Point saisi par l'utilisateur, différent de P1 et
		// et de P2 et non aligné avec P1 et P2 }
		Scanner lecteur = new Scanner(System.in);

		System.out.println("Saisie d'un point non aligné avec les points " + P1 + " et " + P2);

		System.out.println("* Abscisse ? ");
		int pointX = lecteur.nextInt();
		lecteur.nextLine();

		System.out.println("* Ordonnée ? ");
		int pointY = lecteur.nextInt();
		lecteur.nextLine();

		boolean confonduP1 = (pointX == P1.getX())&(pointY == P1.getY());
		boolean confonduP2 = (pointX == P2.getX())&(pointY == P2.getY());
		boolean aligneHorizontal = ((P1.getX() == P2.getX())&(P1.getX() == pointX));
		boolean aligneVertical = ((P1.getY() == P2.getY())&(P1.getY() == pointY));
		boolean aligneDiagonal = false;
		
		if ((P2.getX() != P1.getX())&(pointX != P1.getX())){
			aligneDiagonal = ((P2.getY() - P1.getY())/(P2.getX() - P1.getX()) == (pointY - P1.getY())/(pointX - P1.getX()));
		}

		while(confonduP1|confonduP2|aligneHorizontal|aligneVertical|aligneDiagonal){
			if(confonduP1){
				System.out.println("--> Point confondu avec " + P1 + ", recommencez...");
			}
			else if(confonduP2){
				System.out.println("--> Point confondu avec " + P2 + ", recommencez...");
			}
			else{
				System.out.println("--> Point aligné avec les points " + P1 + " et " + P2 + ", recommencez...");
			}

			System.out.println("* Abscisse ? ");
			pointX = lecteur.nextInt();
			lecteur.nextLine();

			System.out.println("* Ordonnée ? ");
			pointY = lecteur.nextInt();
			lecteur.nextLine();

			confonduP1 = (pointX == P1.getX())&(pointY == P1.getY());
			confonduP2 = (pointX == P2.getX())&(pointY == P2.getY());
			aligneHorizontal = ((P1.getX() == P2.getX())&(P1.getX() == pointX));
			aligneVertical = ((P1.getY() == P2.getY())&(P1.getY() == pointY));
			aligneDiagonal = false;

			if ((P2.getX() != P1.getX())&(pointX != P1.getX())){
				aligneDiagonal = ((P2.getY() - P1.getY())/(P2.getX() - P1.getX()) == (pointY - P1.getY())/(pointX - P1.getX()));
			}
		}

		return new Point(pointX, pointY);
	}

	public static TriangleCompose symetriqueH(TriangleCompose tComp) {
		// { } =>
		// { résultat = nouveau TriangleCompose dont les sommets sont obtenus par
		// symétrie des sommets de tComp par rapport à l'axe horizontal }
			return new TriangleCompose(new Point(tComp.getSomA().getX(), -tComp.getSomA().getY()), 
				new Point(tComp.getSomB().getX(), -tComp.getSomB().getY()), 
				new Point(tComp.getSomC().getX(), -tComp.getSomC().getY()));
	}

	public static TriangleCompose symetriqueV(TriangleCompose tComp) {
		// { } =>
		// { résultat = nouveau TriangleCompose dont les sommets sont obtenus par
		// symétrie des sommets de tComp par rapport à l'axe vertical }
			return new TriangleCompose(new Point(-tComp.getSomA().getX(), tComp.getSomA().getY()), 
				new Point(-tComp.getSomB().getX(), -tComp.getSomB().getY()), 
				new Point(-tComp.getSomC().getX(), tComp.getSomC().getY()));
	}
}
