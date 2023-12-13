import java.util.ArrayList;
import java.util.Arrays;

public class Pollution {
	public static void main(String[] args) {
		/*
		ArrayList<ReleveMensuel> testReleve = new ArrayList<>();
		
		testReleve.add(new ReleveMensuel("janvier", 20.6f));
		testReleve.add(new ReleveMensuel("mars", 40f));
		testReleve.add(1, new ReleveMensuel("fevrier", 45f));

		System.out.println(testReleve);
		*/

		ArrayList<String> semestre1 = new ArrayList<>(Arrays.asList("janvier", "février", "mars", "avril", "mai", "juin"));
		final float SEUIL_ALERTE = 40.0f;
		ArrayList<ReleveMensuel> bilanSem1;

		System.out.println("-------------------------------------\n" +
			"Bilan 1er semestre\n" +
			"-------------------------------------");
		bilanSem1 = Utilitaire.bilanSem(semestre1);
		System.out.println("-----------------------------------------------------------------------\n" +
			"Concentration en dioxyde d'azote sur le 1er semestre\n" +
			"-----------------------------------------------------------------------");
		System.out.println("* Taux moyen : " + Utilitaire.moyConc(bilanSem1));
		System.out.println("* Nombre de mois pollués : " + Utilitaire.nbPoll(bilanSem1, SEUIL_ALERTE));
		System.out.println("* Nom du premier mois pollué : " + Utilitaire.poll1(bilanSem1, SEUIL_ALERTE));
		System.out.println("* Taux maximal relevé : " + Utilitaire.maxConc(bilanSem1));
		System.out.println("* Taux minimal relevé : " + Utilitaire.minConc(bilanSem1));
		System.out.println("* Analyse par mois...");
		
		int i = 0;
		while(i < bilanSem1.size()){
			System.out.println(" -" + bilanSem1.get(i).getMois() + " : " + bilanSem1.get(i).getConcentration() + " --> "  + Utilitaire.niveauPol(bilanSem1.get(i)));
			i++;
		}

		ArrayList<String> semestre2 = new ArrayList<>(Arrays.asList("juillet", "août", "septembre", "octobre", "novembre", "décembre"));
		ArrayList<ReleveMensuel> bilanSem2;

		System.out.println("-------------------------------------\n" +
			"Bilan 2nd semestre\n" +
			"-------------------------------------");
		bilanSem2 = Utilitaire.bilanSem(semestre2);
		System.out.println("-----------------------------------------------------------------------\n" +
			"Concentration en dioxyde d'azote sur le 2nd semestre\n" +
			"-----------------------------------------------------------------------");
		System.out.println("* Taux moyen : " + Utilitaire.moyConc(bilanSem2));
		System.out.println("* Nombre de mois pollués : " + Utilitaire.nbPoll(bilanSem2, SEUIL_ALERTE));
		System.out.println("* Nom du premier mois pollué : " + Utilitaire.poll1(bilanSem2, SEUIL_ALERTE));
		System.out.println("* Taux maximal relevé : " + Utilitaire.maxConc(bilanSem2));
		System.out.println("* Taux minimal relevé : " + Utilitaire.minConc(bilanSem2));
		System.out.println("* Analyse par mois...");
		
		i = 0;
		while(i < bilanSem2.size()){
			System.out.println(" -" + bilanSem2.get(i).getMois() + " : " + bilanSem2.get(i).getConcentration() + " --> "  + Utilitaire.niveauPol(bilanSem2.get(i)));
			i++;
		}

		System.out.println("-----------------------------------------------------------------------\n" +
			"Comparaison entre les 2 semestres\n" +
			"-----------------------------------------------------------------------\n");
		
		int evolutionSemestres = Utilitaire.compareReleves(bilanSem2, bilanSem1, SEUIL_ALERTE);

		if(evolutionSemestres == 1){
			System.out.println("Amélioration de l'émission de NO2 sur le second semestre");
		}
		else if	(evolutionSemestres == -1){
			System.out.println("Dégradation de l'émission de NO2 sur le second semestre");
		}
		else {
			System.out.println("Stagnation de l'émission de NO2 sur le second semestre");
		}
	}
}