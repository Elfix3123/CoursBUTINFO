import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PaysDesContinents {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);

		ArrayList<Pays> mondeT = new ArrayList<>(InitMondeT.creerMondeT());
		ArrayList<String> vContinents = new ArrayList<>(Arrays.asList("Afrique", "Amériques", "Antarctique", "Asie", "Europe", "Océanie"));
		ListeChainee<PaysDeCont> listeAfrique = Utilitaire.countries(mondeT, vContinents.get(0));
		
		System.out.println(listeAfrique.getLongueur());
		ListeChainee<PaysDeCont> listeAmeriques = Utilitaire.countries(mondeT, vContinents.get(1));
		System.out.println(listeAmeriques.getLongueur());
		ListeChainee<PaysDeCont> listeAntarctique = Utilitaire.countries(mondeT, vContinents.get(2));
		System.out.println(listeAntarctique.getLongueur());
		ListeChainee<PaysDeCont> listeAsie = Utilitaire.countries(mondeT, vContinents.get(3));
		System.out.println(listeAsie.getLongueur());
		ListeChainee<PaysDeCont> listeEurope = Utilitaire.countries(mondeT, vContinents.get(4));
		System.out.println(listeEurope.getLongueur());
		ListeChainee<PaysDeCont> listeOceanie = Utilitaire.countries(mondeT, vContinents.get(5));
		System.out.println(listeOceanie.getLongueur());

		ArrayList<ListeChainee<PaysDeCont>> vListesPdeC = new ArrayList<>();
		vListesPdeC.add(listeAfrique);
		vListesPdeC.add(listeAmeriques);
		vListesPdeC.add(listeAntarctique);
		vListesPdeC.add(listeAsie);
		vListesPdeC.add(listeEurope);
		vListesPdeC.add(listeOceanie);

		int indContinent = Utilitaire.indString(lecteur, vContinents);

		System.out.println("------------------------------------------------------------------\n" +
				"Pays du continent " + vContinents.get(indContinent) +
				"\n------------------------------------------------------------------");
		
		Utilitaire.affichePaysDeCont(vListesPdeC.get(indContinent));

		Utilitaire.contExtremes(vContinents, vListesPdeC);

		ListeChainee<String> lNomPaysDuMonde = Utilitaire.listeNomsPaysDuMonde(vContinents, vListesPdeC);
		Cellule<String> celluleActive = lNomPaysDuMonde.getTete();

		int i = 1;

		while (i <= 10) {
			System.out.println(celluleActive.getInfo());
			celluleActive = celluleActive.getCelluleSuivante();
			i++;
		}

		Utilitaire.lexiquePaysDuMonde(lNomPaysDuMonde);
	}
}
