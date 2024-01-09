import java.util.ArrayList;

public class TestTriFusion {
	public static void triFusion(ArrayList<Integer> vInt, int inf, int sup) {
		// { vInt[inf..sup] non vide } => { vInt[inf..sup] trié }
		if (inf < sup) {
			int m = (inf + sup) / 2;
			triFusion(vInt, inf, m); // appel récursif sur tranche gauche
			triFusion(vInt, m + 1, sup); // appel récursif sur tranche droite
			fusionTabGTabD(vInt, inf, m, sup); // appel du worker : tri de inf à sup
		}
	}

	public static void fusionTabGTabD(ArrayList<Integer> vInt, int inf, int m, int sup) {
		// { inf <= sup, m = (inf+sup)/2, vInt[inf..m] trié, vInt[m+1..sup] trié }
		// => { VInt[inf..sup] trié }
		ArrayList<Integer> vTemp = new ArrayList<>();
		int iGauche = inf;
		int iDroite = m+1;

		while(iGauche <= m && iDroite <= sup){
			if(vInt.get(iGauche) < vInt.get(iDroite)){
				vTemp.add(vInt.get(iGauche));
				iGauche-=-1;
			}
			else{
				vTemp.add(vInt.get(iDroite));
				iDroite-=-1;
			}
		}
		
		while(iGauche <= m){
			vTemp.add(vInt.get(iGauche));
			iGauche-=-1;
		}

		while(iDroite <= sup){
			vTemp.add(vInt.get(iDroite));
			iDroite-=-1;
		}

		int i = inf;

		while(i <= sup){
			vInt.set(i, vTemp.get(i-inf));
			i-=-1;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrayTest = new ArrayList<>();
		arrayTest.add(654);
		arrayTest.add(541);
		arrayTest.add(975);
		arrayTest.add(194);
		arrayTest.add(037);
		arrayTest.add(645);
		arrayTest.add(841);
		arrayTest.add(871);
		arrayTest.add(501);
		arrayTest.add(641);
		arrayTest.add(650);
		System.out.println(arrayTest);
		triFusion(arrayTest, 0, arrayTest.size()-1);
		System.out.println(arrayTest);
	}
}
