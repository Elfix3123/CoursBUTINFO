import java.util.Scanner;

public class Compare_Strings {
	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		
		String unChat = "chat";
		String unPetitChat = "chaton";
		String unChien = "chien";
		
		// 1 - Premiers tests
		System.out.println("------------------------------------------------------");
		System.out.println("Premiers tests de comparaison de chaînes");
		System.out.println("------------------------------------------------------");
		System.out.println("Chaînes comparées...");
		System.out.println("    unChat --> \"" + unChat + "\"");
		System.out.println("    unChien --> \"" + unChien + "\"");
		System.out.println("    unPetitChat --> \"" + unPetitChat + "\"");
		System.out.println("Comparaisons entre ces chaînes (casse prise en compte)");
		System.out.println("    unChat comparé à unChien --> " + unChat.compareTo(unChien));
		System.out.println("    unChien comparé à unPetitChat --> " + unChien.compareTo(unPetitChat));
		System.out.println("    unPetitChat comparé à unChat ---> " + unPetitChat.compareTo(unChat));
		System.out.println("    unPetitChat comparé à unPetitChat ---> " + unPetitChat.compareTo(unPetitChat));
		System.out.println("------------------------------------------------------");
		
		// 2 - Comparaisons entre des chaînes saisies par l'utilisateur
		/*
		Déclarations - À NE PAS MODIFIER
		(les variables sont initialisées pour que le code soit compilable)
		*/
		String ch1 ="", ch2=""; // pour les chaines à saisir
		int resComp = 0; // pour le résultat de la comparaison entre ch1 et ch2
		int nbCarCh1 = 0; // pour le nombre de caractères de ch1
		int nbCarCh2 = 0 ; // pour le nombre de caractères de ch2
		
		// initialisation par saisie de ch1 - À COMPLÉTER...
		System.out.print("Entrer une chaîne : ");
		ch1 = lecteur.nextLine(); 
		nbCarCh1 = ch1.length();
		
		// initialisation par saisie de ch2 - À COMPLÉTER...
		System.out.print("Entrer une autre chaîne : ");
		ch2 = lecteur.nextLine();
		nbCarCh2 = ch2.length();
		
		// nombre de caractères de ch1 - À COMPLÉTER...
		System.out.println("ch1 a " + ch1.length() + " caractères.");
		// nombre de caractères de ch2 - À COMPLÉTER...
		System.out.println("ch2 a " + ch2.length() + " caractères.");
		// SI ch1 ou ch2 est vide. : déterminer la valeur de resComp (cf. page 1)
		// - À COMPLÉTER...
		
		int i;
		
		if(ch1.isEmpty()|ch2.isEmpty()){
			
			if(ch2.isEmpty()){
				resComp = ch1.length();
			}
			if(ch1.isEmpty()){
				resComp = -ch2.length();
			}
		}
		else{
			// SINON...
			// 1 : position du dernier caractère pouvant être comparé dans ch1 et ch2
			// - À NE PAS MODIFIER !
			int indDerCarToCompare = Math.min(nbCarCh1, nbCarCh2)-1;
			// 2 : nouvelles déclarations jugées nécessaires et boucle while
			// - À COMPLÉTER...
			i = 0;
			while((i <= indDerCarToCompare)&(resComp == 0)){
				if(ch1.charAt(i) != ch2.charAt(i)){
					resComp = ch1.charAt(i) - ch2.charAt(i);
				}
				i++;
			}
			if(resComp == 0){
				resComp = ch1.length() - ch2.length();
			}
		}
		
		
		
		// 3 : en sortie de boucle, déterminer la valeur de resComp (cf. page 1)
		//  - À COMPLÉTER...
		
		
		
		/*
		Message pour l'utilisateur - À NE PAS MODIFIER !
		*/
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Comparaison entre les chaînes \"" + ch1 + "\" et \"" + ch2 + "\"");
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		System.out.println("Résultat de la comparaison de \"" + ch1 + "\" et \"" + ch2 + "\" par programme : " + resComp);
		System.out.println();
		System.out.println("Vérification...");
		System.out.println("Résultat de la comparaison de \"" +ch1 + "\" et \"" + ch2 + "\" avec compareTo : " + ch1.compareTo(ch2));
	}
}
