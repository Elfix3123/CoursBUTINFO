import java.util.ArrayList;
import java.util.Scanner;

public class Monde {
	public static void main(String[] args) {
		ArrayList<Pays> leMonde = InitMonde.creerMonde();
		/* */
		ArrayList<String> lesContinents = new ArrayList<>();

		Scanner lecteur = new Scanner(System.in);
		
		int i = 0; 
		int indCont;
		String continentEtudie = "";

		while(i < leMonde.size()){
			continentEtudie = leMonde.get(i).getContinent();
			indCont = Utilitaire.indContinent(lesContinents, continentEtudie);
			if(indCont != -1){
				lesContinents.add(indCont, continentEtudie);
			}
			i++;
		}
		
		String unCont = Utilitaire.saisieCont(lesContinents);
		ArrayList<Pays> paysDuContinent = Utilitaire.paysDeCont(leMonde, unCont);

		System.out.println("----------------------\n" + //
				"\n- Premier pays de ce continent : " + paysDuContinent.get(0).getNom() + //
				"\n- Dernier pays de ce continent : " + paysDuContinent.get(1).getNom() + //
				"\n- Nombre de pays : " + paysDuContinent.size() + //
				"\n----------------------");
		
		System.out.print("Donnez le nom d'un pays :");
		String nomPays = lecteur.nextLine();
		int indicePays = Utilitaire.rechPaysT(paysDuContinent, nomPays);
		System.out.println(indicePays);
		if(indicePays == paysDuContinent.size()){
			System.out.println("Ce pays n'est pas dans le continent " + continentEtudie + "...");
		}
		else{
			System.out.println(paysDuContinent.get(indicePays));
		}
	}
}
