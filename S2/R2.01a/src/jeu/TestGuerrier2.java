import guerriers.*;;

public class TestGuerrier2 {
	public static void main(String[] args) {
		Nain nain = new Nain();
		Elfe elfe = new Elfe();
		Nain chefNain = new ChefNain();
		Elfe chefElfe = new ChefElfe();

		System.out.println("Nain : " + nain);
		System.out.println("Elfe : " + elfe);
		System.out.println("ChefNain : " + chefNain);
		System.out.println("ChefElfe : " + chefElfe);
		System.out.println();

		System.out.println("Ataque de chefElfe vers elfe...");
		chefElfe.attaquer(elfe);
		System.out.println("Nain : " + nain);
		System.out.println("Elfe : " + elfe);
		System.out.println("ChefNain : " + chefNain);
		System.out.println("ChefElfe : " + chefElfe);
		System.out.println();

		System.out.println("Ataque de nain vers chefNain...");
		nain.attaquer(chefNain);
		System.out.println("Nain : " + nain);
		System.out.println("Elfe : " + elfe);
		System.out.println("ChefNain : " + chefNain);
		System.out.println("ChefElfe : " + chefElfe);
		System.out.println();

		System.out.println("Ataque de chefElfe vers chefNain...");
		chefElfe.attaquer(chefNain);
		System.out.println("Nain : " + nain);
		System.out.println("Elfe : " + elfe);
		System.out.println("ChefNain : " + chefNain);
		System.out.println("ChefElfe : " + chefElfe);
		System.out.println();

		System.out.println("Ataque de nain vers elfe...");
		nain.attaquer(elfe);
		System.out.println("Nain : " + nain);
		System.out.println("Elfe : " + elfe);
		System.out.println("ChefNain : " + chefNain);
		System.out.println("ChefElfe : " + chefElfe);
		System.out.println();
	}
}
