import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {

	public static float saisieConc(String unMois) {
		//{ } => { résultat = un float>=0 saisi par l'utilisateur, représentant
		// la concentration en NO2 pour le mois unMois }
		Scanner lecteur = new Scanner(System.in);

		System.out.print("* Concentration en dioxyde d'azote relevée en " + unMois + " ? ");
		Float concentration = lecteur.nextFloat();
		lecteur.nextLine();
		
		while(concentration < 0){
			System.out.println("Entrée invalide ! la concentration doit etre strictement superieure à 0.");
			System.out.print("* Concentration en dioxyde d'azote relevée en " + unMois + " ? ");
			concentration = lecteur.nextFloat();
			lecteur.nextLine();
		}

		return concentration;
	}

	public static ArrayList<ReleveMensuel> bilanSem(ArrayList<String> desMois) {
		// { desMois contient des noms de mois }
		// => { résultat = un vecteur de ReleveMensuel
		// Pour chaque élément du vecteur résultat:
		// * mois est le nom du mois de même indice dans desMois
		// * concentration est la concentration en NO2, saisie pour ce mois }

		int i = 0;
		ArrayList<ReleveMensuel> concSaisies = new ArrayList<>();

		// Invariant : concSaisies contient tous les relevés mensuels de mois appartenants à desMois[0; i] et de concentration saisie par l'utilisateur

		while(i < desMois.size()){

			// Invariant verifie en debut de boucle

			concSaisies.add(new ReleveMensuel(desMois.get(i), saisieConc(desMois.get(i))));

			i++;

			// Invariant verifie en fin de boucle
		}

		// Condition de sortie : i = desMois.size(); 
		// Invariant verifie en sortie de boucle

		return concSaisies;
	}

	public static float moyConc (ArrayList<ReleveMensuel> desReleves) {
		// { desReleves non vide } => { résultat = moyenne des concentrations des éléments
		// du vecteur desReleves }
		int i = 0;
		float totalDesValeurs = 0;

		while(i < desReleves.size()){
			totalDesValeurs += desReleves.get(i).getConcentration();
			
			i++;
		}

		return totalDesValeurs/desReleves.size();
	}

	public static float maxConc(ArrayList<ReleveMensuel> desReleves) {
		// { desReleves non vide } =>
		// { résultat = concentration la plus élevée dans desReleves }

		
		float valeurLaPlusHaute = desReleves.get(0).getConcentration();

		int i = 1;
		// Invariant : valeurLaPlusHaute = plus petite valeur de desReleves[0; i]

		while(i < desReleves.size()){
			// Invariant verifie en debut de boucle

			if(desReleves.get(i).getConcentration() > valeurLaPlusHaute){
				valeurLaPlusHaute = desReleves.get(i).getConcentration();
			}

			i++;

			// Invariant verifie en fin de boucle
		}

		// Condition de sortie : i = desReleves.size()
		// Invariant verifie en sortie de boucle

		return valeurLaPlusHaute;
	}

	public static float minConc(ArrayList<ReleveMensuel> desReleves) {
		// { des Releves non vide } =>
		// { résultat = concentration la moins élevée dans desReleves }

		float valeurLaPlusBasse = desReleves.get(0).getConcentration();
		int i = 1;

		// Invariant : valeurLaPlusBasse = plus petite valeur de desReleves[0; i]

		while(i < desReleves.size()){
			// Invariant verifie en debut de boucle

			if(desReleves.get(i).getConcentration() < valeurLaPlusBasse){
				valeurLaPlusBasse = desReleves.get(i).getConcentration();
			}

			i++;

			// Invariant verifie en fin de boucle
		}

		// Condition de sortie : i = desReleves.size()
		// Invariant verifie en sortie de boucle

		return valeurLaPlusBasse;
	}

	public static boolean estPollue(ReleveMensuel unReleve, float seuil) {
		// { unReleve } =>
		// { résultat = vrai si la concentration de unReleve > seuil }

		return unReleve.getConcentration() > seuil;
	}

	public static int nbPoll(ArrayList<ReleveMensuel> desReleves, float seuil) {
		// { desReleves non vide } => { résultat = nombre de mois pollués dans desReleves }

		int i = 0;
		int moisPollues = 0;

		// Invariant : ∀a <= i, moisPollues = nombre de desReleves[a-1].getConcentration() < seuil

		while(i < desReleves.size()){
			// Invariant verifie en debut de boucle

			if(estPollue(desReleves.get(i), seuil)){
				moisPollues++;
			}

			i++;

			// Invariant verifie en fin de boucle
		}

		// Condition de sortie : i = desReleves.size()
		// Invariant verifie en sortie de boucle

		return moisPollues;
	}

	public static String poll1(ArrayList<ReleveMensuel> desReleves, float seuil) {
		// { desReleves non vide } => { résultat = nom du premier mois pollué dans desReleves,
		// une chaîne vide s'il n'y en a pas }

		int i = 0;
		String premierMoisPollue = "";

		// Invariant : premierMoisPollue = dernier élément desReleves[0; i-1] si desReleves[i-1] >= seuil

		while(i < desReleves.size() && premierMoisPollue.equals("")){
			// Invariant verifie en debut de boucle

			if( estPollue(desReleves.get(i), seuil)){
				premierMoisPollue = desReleves.get(i).getMois();
			}

			i++;

			// Invariant verifie en fin de boucle
		}

		// Condition de sortie : i = desReleves.size() ou premierMoisPollue non nul
		// Invariant verifie en sortie de boucle

		return premierMoisPollue;
	}

	public static String niveauPol(ReleveMensuel unReleve) {
		// { unReleve } =>
		// { résultat = * "bon" si concentration <= 10
		// * "moyen" si concentration dans ]10, 25]
		// * "dégradé" si concentration dans ]25, 40]
		// * "mauvais" si concentration dans ]40, 55]
		// * "très mauvais" si concentration dans ]55, 70]
		// * "extrêmement mauvais" si concentration > 70 }
		if(unReleve.getConcentration() <= 10f){
			return "bon";
		}
		else if(unReleve.getConcentration() <= 25f){
			return "moyen";
		}
		else if(unReleve.getConcentration() <= 40f){
			return "dégradé";
		}
		else if(unReleve.getConcentration() <= 55f){
			return "mauvais";
		}
		else if(unReleve.getConcentration() <= 70f){
			return "très mauvais";
		}
		else{
			return "extrêmement mauvais";
		}
	}

	public static int compareReleves(ArrayList<ReleveMensuel> releves1,ArrayList<ReleveMensuel> releves2, float seuil) {
		// { releves1 et releves2 non vides et de même taille }
		// => { Résultat = * -1 si la moyenne des concentrations en NO2 de releves1
		// est inférieure à celle de releves2, ou si les moyennes
		// sont égales et le nombre de mois pollués de releves1
		// est inférieur à celui de releves2
		// * 0 si les moyennes des concentrations en NO2 sont égales
		// et si le nombre de mois pollués est identique
		// * 1 dans tous les autres cas }
		if((Utilitaire.moyConc(releves1) < Utilitaire.moyConc(releves2))||((Utilitaire.moyConc(releves1) == Utilitaire.moyConc(releves2))&&(Utilitaire.nbPoll(releves1, seuil) < Utilitaire.nbPoll(releves2, seuil)))){
			return -1;
		}
		else if((Utilitaire.moyConc(releves1) == Utilitaire.moyConc(releves2))&&(Utilitaire.nbPoll(releves1, seuil) == Utilitaire.nbPoll(releves2, seuil))){
			return 0;
		}
		else{
			return -1;
		}
	}
}
