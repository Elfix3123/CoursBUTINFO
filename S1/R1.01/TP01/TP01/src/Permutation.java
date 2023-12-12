import java.util.Scanner;

public class Permutation{
	public static void main(String[] args){
		int a, b, c, d, e, sauv;
		Scanner lecteur = new Scanner(System.in);
		System.out.print("saisir un entier  a : ");
		a = lecteur.nextInt();
		lecteur.nextLine();
		System.out.print("saisir un entier  b : ");
		b = lecteur.nextInt();
		lecteur.nextLine();
		System.out.print("saisir un entier  c : ");
		c = lecteur.nextInt();
		lecteur.nextLine();
		System.out.print("saisir un entier  d : ");
		d = lecteur.nextInt();
		lecteur.nextLine();
		System.out.print("saisir un entier  e : ");
		e = lecteur.nextInt();
		lecteur.nextLine();
		sauv = a;
		a = b;
		b = c;
		c = d;
		d = e;
		e = sauv;
		System.out.println("\na = " + a + "\nb = " + b + "\nc = " + c + "\nd = " + d + "\ne = " + e);
		lecteur.close();
	}
}