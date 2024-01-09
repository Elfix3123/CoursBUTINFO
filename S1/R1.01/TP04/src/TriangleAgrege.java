import java.lang.Math;

public class TriangleAgrege {
	private Point somA;
	private Point somB;
	private Point somC;

	public TriangleAgrege(Point somA, Point somB, Point somC){
		this.somA = somA;
		this.somB = somB;
		this.somC = somC;
	}

	// Getters des attributs

	public Point getSomA(){
		return somA;
	}

	public Point getSomB(){
		return somB;
	}

	public Point getSomC(){
		return somC;
	}

	// Methodes mathématiques

	public double getCoteAB(){
		// { } => { résultat = longueur du côté d'extrémités somA et somB }
		return Math.sqrt(
			Math.pow((this.somB.getX() - this.somA.getX()), 2) +
			Math.pow((this.somB.getY() - this.somA.getY()), 2)
		);
	}

	public double getCoteAC(){
		// { } => { résultat = longueur du côté d'extrémités somA et somC }
		return Math.sqrt(
			Math.pow((this.somC.getX() - this.somA.getX()), 2) +
			Math.pow((this.somC.getY() - this.somA.getY()), 2)
		);
	}

	public double getCoteBC(){
		// { } => { résultat = longueur du côté d'extrémités somB et somC }
		return Math.sqrt(
			Math.pow((this.somC.getX() - this.somB.getX()), 2) +
			Math.pow((this.somC.getY() - this.somB.getY()), 2)
		);
	}

	public double getPerimetre() {
		// { } => { résultat = périmètre de ce Triangle }
		return getCoteAB()+getCoteAC()+getCoteBC();
	}

	public double getSurface(){
		// { } => { résultat = surface de ce Triangle }
		double a = getCoteAB(); 
		double b = getCoteBC();
		double c = getCoteAC();
		double p = (a + b + c)/2;

		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	public void deplacer(int dx, int dy) {
		// { } => { les sommets de ce Triangle sont déplacés
		// horizontalement de dx et verticalement de dy }
		this.somA.deplace(dx, dy);
		this.somB.deplace(dx, dy);
		this.somC.deplace(dx, dy);
	}

	@Override
	public String toString() {
		return "* Sommets : " + somA + " " + somB + " " + somC + " \n" +
		"* Périmètre : " + Math.round(100 * getPerimetre()) / 100.0 + "\n" +
		"* Surface : " + Math.round(100 * getSurface()) / 100.0;
	}
}
