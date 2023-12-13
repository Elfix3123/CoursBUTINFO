import java.util.ArrayList;
import java.util.Arrays;

public class ListesIntegerTriees {
	public static void main(String[] args) {
		ArrayList<Integer> vIntTest = new ArrayList<>(Arrays.asList(31, 1, 46, 35, 5, 32, 14, 49, 19, 28, 2, 30, 32, 12, 20));
		ListeTrieeD<Integer> listIntD = new ListeTrieeD<>();

		int i = 0;
		// Invariant de boucle : listIntD toujours trié
		while (i < vIntTest.size()) {	// On fait un parcours complet de vIntTest
			listIntD.insereTrie(vIntTest.get(i));	// On insère dans l'ordre chaque valeur de vIntTest
			i++;
		}

		listIntD.afficheGD();	// On affiche la liste triée

		ArrayList<Integer> vIntRandom1 = new ArrayList<>();

		i = 0;

		while (i < 20) {	// On ajoute 20 entier aléatoires compris entre 0 et 40 dans vIntRandom1
			vIntRandom1.add((int)(Math.random()*40));
			i++;
		}

		System.out.println(vIntRandom1);

		ArrayList<Integer> vIntRandom2 = new ArrayList<>();

		i = 0;

		while (i < 15) {	// On ajoute 15 entier aléatoires compris entre 0 et 40 dans vIntRandom1
			vIntRandom2.add((int)(Math.random()*40));
			i++;
		}

		System.out.println(vIntRandom2);

		ListeTrieeC<Integer> listIntC1 = new ListeTrieeC<>();

		i = 0;
		// Invariant de boucle : listIntD toujours trié
		while (i < vIntRandom1.size()) {	// On fait un parcours complet de vIntTest
			listIntC1.insereTrie(vIntRandom1.get(i));	// On insère dans l'ordre chaque valeur de vIntTest
			i++;
		}

		ListeTrieeC<Integer> listIntC2 = new ListeTrieeC<>();
		
		i = 0;
		// Invariant de boucle : listIntD toujours trié
		while (i < vIntRandom2.size()) {	// On fait un parcours complet de vIntTest
			listIntC2.insereTrie(vIntRandom2.get(i));	// On insère dans l'ordre chaque valeur de vIntTest
			i++;
		}

		listIntC1.afficheGD();
		listIntC2.afficheGD();

		ListeTrieeC<Integer> listIntC1_sdb = Utilitaire.lCsansDoublons(listIntC1);
		listIntC1_sdb.afficheGD();

		ListeTrieeC<Integer> listIntC2_sdb = Utilitaire.lCsansDoublons(listIntC2);
		listIntC2_sdb.afficheGD();
	}
}
