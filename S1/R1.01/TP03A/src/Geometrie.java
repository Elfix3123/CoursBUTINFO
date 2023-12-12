public class Geometrie{
	public static void main(String[] args) {
		Rectangle cunegondeLeRectangle;
		cunegondeLeRectangle = Util.saisirRectangle();
		System.out.println(cunegondeLeRectangle);
		System.out.println("Cercle inscrit dans ce rectangle");
		System.out.println(cunegondeLeRectangle.cercleInscrit());
		System.out.println("Cercle circonscrit à ce rectangle");
		System.out.println(cunegondeLeRectangle.cercleCirconscrit());
		/*
		Cercle antegoneLeCercle;
		antegoneLeCercle = Util.saisirCercle();
		System.out.println(antegoneLeCercle);
		*/
		/*
		Triangle seraphinLeTriangle;
		seraphinLeTriangle = Util.saisirTriangle();
		System.out.println(seraphinLeTriangle);
		*/
	}
}