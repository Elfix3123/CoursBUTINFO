public class TestPile {
	public static void main(String[] args) {
		PileFloat maPile = new PileFloat(4);

		try {
			maPile.empile(3.14f);
			maPile.empile(1.59f);
			maPile.empile(2.65f);
			System.out.println(maPile.depile());
			System.out.println(maPile.depile());
			maPile.empile(3.58f);
			maPile.empile(9.79f);
			maPile.empile(3.23f);
		}
		catch (EPilePleine|EPileVide e){
			System.out.println("Erreur non prévue ! \n --> " + e);
		}

		try {
			maPile.empile(8.46f);
		}
		catch (EPilePleine e) {
			System.out.println("Erreur prévue ! \n --> " + e);
		}

		try {
			System.out.println(maPile.depile());
			System.out.println(maPile.depile());
			System.out.println(maPile.depile());
			System.out.println(maPile.depile());
		}
		catch (EPileVide e) {
			System.out.println("Erreur non prévue ! \n --> " + e);
		}

		try {
			System.out.println(maPile.depile());
		}
		catch (EPileVide e) {
			System.out.println("Erreur prévue ! \n --> " + e);
		}
	}
}
