package tp02.contrainte;

public class TestContrainte {
	public static void main(String[] args) {
		ReelContraint reelContraint1 = new ReelContraint(0, 10);
		ReelContraint reelContraint2 = new ReelContraint(0, 20);
		ReelContraint reelContraint3 = new ReelContraint(10, 30);

		reelContraint1.setValeur(-10);
		reelContraint2.setValeur(30);
		reelContraint3.setValeur(20);

		System.out.println(reelContraint1.getValeur());
		System.out.println(reelContraint2);
		System.out.println(reelContraint3);

		Note note1 = new Note();
		Note note2 = new Note(10);

		Note note3 = ContrainteUtilitaire.saisir();
		System.out.println(note3);
	}
}
