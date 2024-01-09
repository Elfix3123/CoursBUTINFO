import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {
	public static int saisirIntMinMax(int min, int max) {
		// { min <= max } => { résultat = entier compris entre min et max }
		Scanner lecteur = new Scanner(System.in);

		System.out.print("Entrez un entier compris entre " + min + " et " + max + " : ");
		int entierSaisi = lecteur.nextInt();
		lecteur.nextLine();

		while(min > entierSaisi || entierSaisi > max){
			System.out.println("--> saisie invalide, recommencez...");
			System.out.print("Entrez un entier compris entre " + min + " et " + max + " : ");
			entierSaisi = lecteur.nextInt();
			lecteur.nextLine();
		}

		return entierSaisi;
	}

	public static int rechPremIndSeq(ArrayList<Polar> vPolar, int an, String aut) {
		// { vPolar trié dans l'ordre (annee, auteur) } =>
		// { * s'il y a dans vPolar au moins un élément d'année an et d'auteur aut,
		// résultat = indice du premier de ces éléments
		// * sinon, résultat = -1 }
		// LA RECHERCHE EST SÉQUENTIELLE !!!
		int i = 0;

		while(i < vPolar.size() && (an > vPolar.get(i).getAnnee() || aut.compareTo(vPolar.get(i).getAuteur()) > 0)){
			i++;
		}

		if(i < vPolar.size() && (an == vPolar.get(i).getAnnee() || aut.compareTo(vPolar.get(i).getAuteur()) == 0)){
			return i;
		}
		else{
			return -1;
		}
	}

	public static int rechPremIndDicho(ArrayList<Polar> vPolar, int an, String aut) {
		// { vPolar trié dans l'ordre (annee, auteur) } =>
		// { * s'il y a dans vPolar au moins un élément d'année an et d'auteur aut,
		// résultat = indice du premier de ces éléments
		// * sinon, résultat = -1 }
		// LA RECHERCHE EST DICHOTOMIQUE !!!
		if(vPolar.size() <= 0 || (an > vPolar.get(vPolar.size() - 1).getAnnee() || (an == vPolar.get(vPolar.size() - 1).getAnnee() && aut.compareTo(vPolar.get(vPolar.size()-1).getAuteur()) > 0))){
			return -1;
		}
		else{
			int inf = 0;
			int sup = vPolar.size()-1;
			int m;

			while(inf < sup){
				m = (inf+sup)/2;

				if(an < vPolar.get(m).getAnnee() || (an == vPolar.get(m).getAnnee() && aut.compareTo(vPolar.get(m).getAuteur()) <= 0)){
					sup = m;
				}
				else{
					inf = m+1;
				}
			}
			if(an == vPolar.get(inf).getAnnee() && aut.compareTo(vPolar.get(inf).getAuteur()) == 0){
				return inf;
			}
			else{
				return -1;
			}
		}
	}

	public static boolean existPolar(ArrayList<Polar> vPolar, int an1, int an2, String aut) {
		// { * vPolar non vide et trié dans l'ordre (annee, auteur)
		// * an1 <= an2
		// * an1 est >= à la plus petite valeur de l'attribut annee dans vPolar
		// * an2 est <= à la plus grande valeur de l'attribut année dans vPolar }
		// => { résultat = vrai s'il existe dans vPolar, au moins un roman
		// dont l'année est comprise entre an1 et an2 et d'auteur aut }

		int i = 0;

		while(i < vPolar.size() && vPolar.get(i).getAnnee() < an1){
			i++;
		}

		while(i < vPolar.size() && vPolar.get(i).getAnnee() <= an2 && !vPolar.get(i).getAuteur().equals(aut)){
			i++;
		}

		return i < vPolar.size() && vPolar.get(i).getAuteur().equals(aut);
	}

	public static void lesPolarsDe(ArrayList<Polar> vPolar, int an1, int an2, String aut) {
		// { * vPolar non vide et trié dans l'ordre (annee, auteur)
		// * an1 <= an2
		// * an1 est >= à la plus petite valeur de l'attribut annee dans vPolar
		// * an2 est <= à la plus grande valeur de l'attribut année dans vPolar }
		// * vPolar contient au moins un roman dont l'auteur est aut
		// et dont l'année est dans l'intervalle [an1, an2] }
		// => { chaque année A comprise entre an1 et an2 est affichée, suivie :
		// * de l'affichage ligne à ligne des titres des romans écrits l'année A
		// par aut (chaque titre précédé d'un tiret)
		// * d'un tiret, si aucun roman n'a été écrit l'année A par aut }

		if(existPolar(vPolar, an1, an2, aut)){
			int anneeEtudiee = an1;
			int i;
			while(anneeEtudiee <= an2){
				System.out.println("* année " + anneeEtudiee);
				i = rechPremIndDicho(vPolar, anneeEtudiee, aut);
				if(i == -1){
					System.out.println("-");
				}
				else{
					while(i < vPolar.size() && vPolar.get(i).getAnnee() == anneeEtudiee && vPolar.get(i).getAuteur().equals(aut)){
						System.out.println("- " + vPolar.get(i).getTitre());
						i++;
					}
				}

				anneeEtudiee++;
			}
		}
		else{
			System.out.println("Aucun roman de " + aut + " entre " + an1 + " et " + an2);
		}
	}
}