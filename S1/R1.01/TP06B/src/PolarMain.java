import java.util.ArrayList;
import java.util.Scanner;

public class PolarMain {
	public static void main(String[] args) {
		
		Scanner lecteur = new Scanner(System.in);

		ArrayList<Polar> lesPolars = InitBibPolars.lesPolars();
		ArrayList<Polar> lesPolarsVide = new ArrayList<>();

		int i = 0;
		int anMin = lesPolars.get(i).getAnnee();
		int anMax = lesPolars.get(i).getAnnee();

		while(i < lesPolars.size()){
			if(lesPolars.get(i).getAnnee() < anMin){
				anMin = lesPolars.get(i).getAnnee();
			}
			if(lesPolars.get(i).getAnnee() > anMax){
				anMax = lesPolars.get(i).getAnnee();
			}
			i++;
		}
		/* 
		int anTest = Utilitaire.saisirIntMinMax(anMin, anMax);
		
		System.out.print("Donnez le nom d'un auteur : ");
		String auteurTest = lecteur.nextLine();

		System.out.println("RECHERCHE SÉQUENTIELLE D'UN ROMAN ÉCRIT PAR " + auteurTest + " en " + anTest);
		int premierIndice = Utilitaire.rechPremIndSeq(lesPolars, anTest, auteurTest);
		if(premierIndice == -1){
			System.out.println("* Aucun roman de " + auteurTest + " pour " + anTest);
		}
		else{
			System.out.println("* Roman trouvé à l'indice " + premierIndice + " dans le vecteur - titre : " + lesPolars.get(premierIndice).getTitre());
		}
		System.out.println("RECHERCHE SÉQUENTIELLE DANS LE VECTEUR VIDE D'UN ROMAN ÉCRIT PAR " + auteurTest + " en " + anTest);
		int premierIndiceVide = Utilitaire.rechPremIndSeq(lesPolarsVide, anTest, auteurTest);
		if(premierIndiceVide == -1){
			System.out.println("* Aucun roman de " + auteurTest + " pour " + anTest + " (vecteur vide)");
		}
		else{
			System.out.println("* Roman trouvé à l'indice " + premierIndiceVide + " dans le vecteur vide - titre : " + lesPolarsVide.get(premierIndiceVide).getTitre());
		}

		System.out.println("RECHERCHE DICHOTOMIQUE D'UN ROMAN ÉCRIT PAR " + auteurTest + " en " + anTest);
		premierIndice = Utilitaire.rechPremIndDicho(lesPolars, anTest, auteurTest);
		if(premierIndice == -1){
			System.out.println("* Aucun roman de " + auteurTest + " pour " + anTest);
		}
		else{
			System.out.println("* Roman trouvé à l'indice " + premierIndice + " dans le vecteur - titre : " + lesPolars.get(premierIndice).getTitre());
		}
		System.out.println("RECHERCHE DICHOTOMIQUE DANS LE VECTEUR VIDE D'UN ROMAN ÉCRIT PAR " + auteurTest + " en " + anTest);
		premierIndiceVide = Utilitaire.rechPremIndDicho(lesPolarsVide, anTest, auteurTest);
		if(premierIndiceVide == -1){
			System.out.println("* Aucun roman de " + auteurTest + " pour " + anTest + " (vecteur vide)");
		}
		else{
			System.out.println("* Roman trouvé à l'indice " + premierIndiceVide + " dans le vecteur vide - titre : " + lesPolarsVide.get(premierIndiceVide).getTitre());
		
		}
	*/

	int an1 = Utilitaire.saisirIntMinMax(anMin, anMax);
	int an2 = Utilitaire.saisirIntMinMax(an1, anMax);

	System.out.println("----------------------------------");

	System.out.print("Donnez le nom d'un auteur : ");
	String auteurTest = lecteur.nextLine();

	System.out.println("----------------------------------");

	// System.out.println(Utilitaire.existPolar(lesPolars, an1, an2, auteurTest));

	Utilitaire.lesPolarsDe(lesPolars, an1, an2, auteurTest);
	}
}
