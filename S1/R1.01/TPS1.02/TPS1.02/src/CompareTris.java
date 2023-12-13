import java.util.ArrayList;
import java.util.Arrays;

public class CompareTris {
	public static void main(String[] args) {
		ArrayList<Integer> vIntBase;
		ArrayList<Integer> vInt;
		ArrayList<ArrayList<Integer>> cas = new ArrayList<>();
		/* 
		cas.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 12, 14, 17, 18)));
		cas.add(new ArrayList<>(Arrays.asList(12, 7, 9, 14, 5, 17, 6, 8, 18)));
		cas.add(new ArrayList<>(Arrays.asList(18, 17, 14, 12, 9, 8, 7, 6, 5)));
		cas.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 6, 7, 8, 9)));
		cas.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 9, 9, 9, 9)));
		cas.add(new ArrayList<>(Arrays.asList(18, 17, 16, 15, 0, 0, 0, 0, 0)));
		cas.add(new ArrayList<>(Arrays.asList(18, 18, 18, 15, 9, 4, 3, 0, -2)));
		cas.add(new ArrayList<>(Arrays.asList(18, 18, 18, 18, 18, 4, 3, 0, -2)));
		*/
		cas.add(Utilitaire.genVectSansDoublons(10));
		cas.add(Utilitaire.genVectSansDoublons(40));
		cas.add(Utilitaire.genVectSansDoublons(160));
		cas.add(Utilitaire.genVectSansDoublons(256));

		int i = 0;

		while(i < cas.size()){
			vIntBase = cas.get(i);
			vInt = new ArrayList<>(vIntBase);
			System.out.println("Cas " + (i+1) + " : " + vIntBase + ";\n Comparaisons du tri à bulles : " + Utilitaire.triBulle_O(vInt));
			vInt = new ArrayList<>(vIntBase);
			System.out.println("Cas " + (i+1) + " : " + vIntBase + ";\n Comparaisons du tri par insertion : " + Utilitaire.triInsert_O(vInt));
			vInt = new ArrayList<>(vIntBase);
			System.out.println("Cas " + (i+1) + " : " + vIntBase + ";\n Comparaisons du tri par selection: " + Utilitaire.triSelect_O(vInt));
			vInt = new ArrayList<>(vIntBase);
			System.out.println("Cas " + (i+1) + " : " + vIntBase + ";\n Comparaisons du tri partition-fusion: " + Utilitaire.triFusion_O(vInt, 0, vInt.size() - 1));

			i++;
		}
	}
}
