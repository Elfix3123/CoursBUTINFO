import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VecteursDeString {
	private static int nbChEgales(ArrayList<String> v1, ArrayList<String> v2) {
		// { v1 non vide, sans doublons, de même taille que v2 } =>
		// { résultat = nombre d'éléments de v1 dont la valeur est égale
		// à celle de l'élément de même indice dans v2 }
		int i = 0;
		int nbrEltEgaux = 0;
		// Invariant : nbrEltEgaux = nombre d'indices de k de 0 à i-1 tels que v1[k] = v2[k]
		while(i < v1.size()){
			if(v1.get(i).equals(v2.get(i))){
				nbrEltEgaux++;
			}
			i++;
			// invariant vérifié en fin de boucle
		}
		// i = v1.size() : sortie de boucle
		// invariant vérifié en sortie de boucle
		return nbrEltEgaux;
	}
	
	public static String equiv(String uneChaine, ArrayList<String> v1, ArrayList<String> v2) {
		// { v1 non vide, sans doublons, de même taille que v2 } =>
		// { résultat = * chaîne du vecteur v2, ayant le même indice que
		// uneChaine dans v1 si uneChaine est un élément de v1,
		// * chaîne vide sinon }
		int i = 0;
		String traduction = "";
		// Invariant : traduction = v2[indice de uneChaine dans v1[0..i-1]] si uneChaine appartient à v1[0..i-1], "" sinon
		while((i < v1.size())&&(traduction.equals(""))){
			if(v1.get(i).equals(uneChaine)){
				traduction = v2.get(i);
			}
			i++;
			// invariant vérifié en fin de boucle
		}
		// i = v1.size() ou traduction pas vide : sortie de boucle
		// invariant vérifié en sortie de boucle
		return traduction;
	}
		
		public static void main(String[] args) {
			ArrayList<String> couleursFR = new ArrayList<String>(Arrays.asList("rouge", "orange", "jaune", "vert", "bleu", "indigo", "violet"));
			ArrayList<String> couleursEN = new ArrayList<String>(Arrays.asList("red", "orange", "yellow", "green", "blue", "indigo", "purple"));
			
			System.out.println("Couleurs de l'arc en cien en francais : " + couleursFR);
			System.out.println("Couleurs de l'arc en cien en englais : " + couleursEN);
			System.out.println("----------------------------");
			System.out.println("Nombre de couleurs de même nom : " + nbChEgales(couleursFR, couleursEN));
			System.out.println("----------------------------");

			Scanner lecteur = new Scanner(System.in);
			String continuerChoix = "o";
			String couleurSaisie;
			String traduction;

			while(continuerChoix.equals("o")){
				System.out.print("Entrez le nom français d'une des 7 couleurs de l'arc en ciel : ");
				couleurSaisie = lecteur.nextLine();
				traduction = equiv(couleurSaisie, couleursFR, couleursEN);

				if(traduction.equals("")){
					System.out.println("--> la couleur " + couleurSaisie + " ne fait pas partie des 7 couleurs de l'arc en ciel en français");
				}
				else{
					System.out.println("--> l'équivalent de " + couleurSaisie + " parmi les noms des 7 couleurs de l'arc en ciel en anglais est : " + traduction);
				}

				System.out.println("*** Recommencer (o pour continuer / n pour arrêter) ? ");
				continuerChoix = lecteur.nextLine();
			}
		}
	}
	