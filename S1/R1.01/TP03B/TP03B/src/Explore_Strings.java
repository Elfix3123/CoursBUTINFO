public class Explore_Strings {
	private static int nbOccCar(String uneChaine, char unCar) {
		// { } => { résultat = nombre de fois où le caractère unCar apparaît dans la chaîne uneChaine }
		int nombreOccurences = 0;
		int indiceChar = 0;
		while(indiceChar < uneChaine.length()){
			if(uneChaine.charAt(indiceChar) == unCar){
				nombreOccurences++;
			}
			indiceChar++;		// NOTE : un mot est constitué de lettres de l'alphabet
		}
		return nombreOccurences;
	}

	private static int nbLettresMajSansAccent(String uneChaine) {
		// { } => { résultat = nombre de lettres majuscules non accentuées dans uneChaine }
		int nombreOccurences = 0;
		int indiceChar = 0;
		while(indiceChar < uneChaine.length()){
			if((uneChaine.charAt(indiceChar) >= 65)&(uneChaine.charAt(indiceChar) <= 90)){
				nombreOccurences++;
			}
			indiceChar++;
		}
		return nombreOccurences;
	}

	private static int nbMots(String uneChaine) {
		// { uneChaine ne contient que :
		// * des lettres de l'alphabet (accentuées ou non)
		// * des espaces
		// * un point final }
		// => { résultat = nombre de mots dans uneChaine }
		return nbOccCar(uneChaine.trim(), ' ') + 1;
	}
	
	private static int nbCarMax(String uneChaine) {
		// { uneChaine ne contient que :
		// * des lettres de l'alphabet (accentuées ou non)
		// * des espaces
		// * un point final }
		// => { résultat = plus grand nombre de caractères
		// d'un mot de uneChaine }
		// NOTE : un mot est constitué de lettres de l'alphabet
		uneChaine = uneChaine.trim().toUpperCase();
		int tailleMotMax = 0;
		int tailleMot = 0;
		int indiceChar = 0;
		while(indiceChar < uneChaine.length()){
			if((uneChaine.charAt(indiceChar) == ' ')){
				tailleMot = 0;
			}
			else if((uneChaine.charAt(indiceChar) >= 65)&(uneChaine.charAt(indiceChar) <= 90)){
				tailleMot++;
			}
			indiceChar++;
			if(tailleMot > tailleMotMax){
				tailleMotMax = tailleMot;
			}
		}
		return tailleMotMax;
	}

	public static void main(String[] args) {
	String lipogramme = "Un rond pas tout à fait clos, fini par un trait horizontal";
	String lesVoyellesSansAccent = "aeiouy";
	int i = 0;
	while(i < lesVoyellesSansAccent.length()){
		System.out.println("Il y a " + nbOccCar(lipogramme, lesVoyellesSansAccent.charAt(i)) + " '" + lesVoyellesSansAccent.charAt(i) + "' dans la chaine \"" + lipogramme + "\"");
		i++;
		}

	String ch1 = "Il y a huit mots dans cette phrase.";
	String ch2 = "CE TP GAGNERAIT À ÊTRE TERMINÉ.";

	System.out.println("\nNombre de mots dans la chaîne \"" + ch1 + "\" : " + nbMots(ch1));
	System.out.println("Nombre de mots dans la chaîne \"" + ch2 + "\" : " + nbMots(ch2));

	System.out.println("\nNombre de majuscules non accentuées dans la chaîne \"" + ch1 + "\" : " + nbLettresMajSansAccent(ch1));
	System.out.println("Nombre de majuscules non accentuées dans la chaîne \"" + ch2 + "\" : " + nbLettresMajSansAccent(ch2));

	System.out.println("\nNombre maximal de caractères d'un mot de la chaîne \"" + ch1 + "\" : " + nbCarMax(ch1));
	System.out.println("Nombre maximal de caractères d'un mot de la chaîne \"" + ch2 + "\" : " + nbCarMax(ch2));
	}
}
