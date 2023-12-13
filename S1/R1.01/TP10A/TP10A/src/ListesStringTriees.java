public class ListesStringTriees {
	private static void tryGet(ListeTrieeC<String> lis, int pos){
		try{
			System.out.println(lis.getInfoAtPosit(pos));
		}
		catch(ExceptionMauvaisIndice e){
			System.out.println("Error at pos " + pos + " : " + e);
		}
	}

	private static void trySet(ListeTrieeC<String> lis, int pos, String info){
		try{
			lis.setInfoAtPosit(pos, info);
		}
		catch(ExceptionMauvaisIndice|ExceptionViolationTri e){
			System.out.println("Error at pos " + pos + " for insert " + info + " : " + e);
		}
	}

	public static void main(String[] args) {
		ListeTrieeC<String> listStringC = new ListeTrieeC<>();
		listStringC.insereTrie("milou");
		listStringC.insereTrie("tintin");
		listStringC.insereTrie("rantanplan");

		listStringC.afficheGD();

		tryGet(listStringC, 1);
		tryGet(listStringC, 3);
		tryGet(listStringC, 10);

		trySet(listStringC, 1, "bécassine");
		trySet(listStringC, 1, "zorro");
		trySet(listStringC, 2, "spirou");
		trySet(listStringC, 2, "fantasio");
		trySet(listStringC, 4, "bécassine");
	}
}
