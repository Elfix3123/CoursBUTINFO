import java.util.Scanner;

public class TestListInt {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);

		ListeChainee<Integer> listInt = new ListeChainee<Integer>();

		int i = 0;
		while (i < 15) {
			listInt.insereTete((int)(Math.random()*100));
			i++;
		}

		System.out.println(listInt.getLongueur());
		listInt.afficheGaucheDroiteRec();

		System.out.println(Utilitaire.sumIter(listInt));
		System.out.println(Utilitaire.sumRec(listInt));

		int entree = Utilitaire.getInt_NFE(lecteur);
		System.out.println(Utilitaire.existIntRec(listInt, entree));
		int indiceSup = Utilitaire.posFirstSup(listInt, entree);
		if (indiceSup == 0) {
			System.out.println(indiceSup + " : ");
		}
		else{
			try{
				System.out.println(indiceSup + " : " + listInt.getInfoAtPosit(indiceSup));
			}
			catch(ExceptionMauvaisIndice e){}
		}

		System.out.println(Utilitaire.bigger(listInt));
		System.out.println(listInt.getTete().getInfo());

		int pos = Utilitaire.getIntMinMax_IME(lecteur, 1, listInt.getLongueur());

		ListeChainee<Integer> subList = Utilitaire.subList(listInt, pos);

		subList.afficheGaucheDroiteRec();
		System.out.println(Utilitaire.nbMult2(subListw));
	}
}
