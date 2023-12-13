import java.util.Scanner;

public class Util{
	public static float saisieFloatPos(){
		// { } => { résultat = un réel (float) strictement positif }
		Scanner lecteur = new Scanner(System.in);
		System.out.print("Veuillez entrer un réel strictement positif : ");
		float entree = lecteur.nextFloat();
		lecteur.nextLine();
		while(entree <= 0){
			System.out.print("Réel non valide ! Veuillez entrer un réel strictement positif : ");
			entree = lecteur.nextFloat();
			lecteur.nextLine();
		}
		return entree;
	}

	public static float saisieFloatPosMinMax(float min, float max){
		// { 0 <= min < max } => { résultat = réel strictement positif compris entre min et max saisi par l'utilisateur }
		Scanner lecteur = new Scanner(System.in);
		System.out.print("Veuillez entrer un réel strictement compris entre " + min + " et " + max + " : ");
		float entree = lecteur.nextFloat();
		lecteur.nextLine();
		while((entree < min)|(entree > max)){
			System.out.print("Réel non valide ! Veuillez entrer un réel strictement compris entre " + min + " et " + max + " : ");
			entree = lecteur.nextFloat();
			lecteur.nextLine();
		}
		return entree;
	}
	public static float troisiemeCoteTriangle(float cote1, float cote2) {
		// { cote1 et cote2 > 0 } =>
		// { le résultat est un float strictement positif, tel qu'un triangle dont
		// les côtés seraient cote1, cote2 et le float saisi puisse être construit }
		return saisieFloatPosMinMax(Math.max(cote1, cote2) - Math.min(cote1, cote2), cote1 + cote2);
	}
	public static Rectangle saisirRectangle() {
		// { } => { résultat = un objet de type Rectangle dont les attributs sont saisis par l'utilisateur }
		System.out.println("Saisie des longueurs et largeurs du rectangle :");
		System.out.println("- Longueur du rectangle");
		float cote1 = Util.saisieFloatPos();
		System.out.println("- Largeur du rectangle");
		float cote2 = Util.saisieFloatPos();
		return new Rectangle(cote1, cote2);
	}
	
	public static Cercle saisirCercle() {
		// { } => { résultat = un nouvel objet de type Cercle dont le rayon est saisi par l'utilisateur }
		System.out.println("Saisie du rayon du cercle :");
		System.out.println("- Rayon");
		float rayon = Util.saisieFloatPos();
		return new Cercle(rayon);
	}

	public static Triangle saisirTriangle() {
		// { } => { résultat = un objet de type Triangle dont les attributs sont saisis par l'utilisateur }
		System.out.println("Saisie des cotés du triangle :");
		System.out.println("- Coté 1");
		float cote1 = Util.saisieFloatPos();
		System.out.println("- Coté 2");
		float cote2 = Util.saisieFloatPos();
		System.out.println("- Coté 3");
		float cote3 = Util.troisiemeCoteTriangle(cote1, cote2);
		return new Triangle(cote1, cote2, cote3);
	}
}