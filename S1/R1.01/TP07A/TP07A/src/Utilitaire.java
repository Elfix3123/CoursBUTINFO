import java.util.ArrayList;

public class Utilitaire{
	public static boolean verifTri(ArrayList<Polar> vPolar) {
		// { } =>
		// { résultat = vrai si vPolar est trié par titre strictement croissant }
		int i = 0;

		while(i < vPolar.size()-1 && vPolar.get(i).compareTo(vPolar.get(i+1)) < 0){
			i++;
		}
		System.out.println(i);
		return i == vPolar.size();
	}

	public static int indMin(ArrayList<Polar> vPolar, int inf, int sup){
		// { } => { resultat : indice du min de vPolar }
		int i = inf+1;
		Polar polarMin = vPolar.get(inf);
		int iPolarMin = inf;

		while(i <= sup){
			if(vPolar.get(i).compareTo(polarMin) < 0){
				polarMin = vPolar.get(i);
				iPolarMin = i;
			}
			i++;
		}

		return iPolarMin;
	}

	public static void triSelect(ArrayList<Polar> vPolar) {
		// { } => { vPolar a été trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI PAR SÉLECTION }
		int i = 0;
		int iPolarMin;
		Polar temp;

		while(i < vPolar.size()-1){
			iPolarMin = indMin(vPolar, i, vPolar.size()-1);
			if(iPolarMin != i){
				temp = vPolar.get(i);
				vPolar.set(i, vPolar.get(iPolarMin));
				vPolar.set(iPolarMin, temp);
			}
			i++;
		}
	}

	public static void triBulle(ArrayList<Polar> vPolar) {
		// { } => { vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI À BULLES AMÉLIORÉ }
		int i = 0;
		int j;
		Polar temp;
		boolean onAPermute = true; 

		while(onAPermute){
			onAPermute = false;
			j = vPolar.size()-1;

			while(j > i){
				if(vPolar.get(j).compareTo(vPolar.get(j-1)) < 0){
					temp = vPolar.get(j);
					vPolar.set(j,vPolar.get(j-1));
					vPolar.set(j-1, temp);
					onAPermute = true;
				}

				j--;
			}

			i++;
		}
	}

	public static void triInsertion(ArrayList<Polar> vPolar) {
		// { } => { vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI PAR INSERTION }
		int i = 1;
		int j;
		Polar temp;

		while(i < vPolar.size()){
			j = i;
			temp = vPolar.get(i);

			while(j > 0 && vPolar.get(j-1).compareTo(temp) > 0){
				vPolar.set(j, vPolar.get(j-1));
				j--;
			}

			vPolar.set(j, temp);

			i++;
		}
	}

	public static void nbPolarAuteur(ArrayList<Polar> vPolar) {
		// { vPolar non vide, trié selon l'ORDRE(auteur, année) } =>
		// { le nombre de romans écrits par chaque auteur a été affiché
		// ligne à ligne, chaque ligne ayant la forme :
		// * Nombre de romans écrits par XXX : nbR
		// (nbR étant le nombre de romans de l'auteur de nom XXX} }
		int i = 0;
		int nbPolar = 0;

		while(i < vPolar.size()-1){
			nbPolar++;
			if(i+1 < vPolar.size() && vPolar.get(i).getAuteur().compareTo(vPolar.get(i+1).getAuteur()) != 0){
				System.out.println("* Nombre de romans écrits par " + vPolar.get(i).getAuteur() + " : " + nbPolar);
				nbPolar = 0;
			}
			i++;
		}
		System.out.println("* Nombre de romans écrits par " + vPolar.get(i).getAuteur() + " : " + nbPolar);
	}

	public static ArrayList<String> auteursDeAn(ArrayList<Polar> vPolar, int an) {
		// { vPolar non vide, trié selon l'ORDRE(auteur, annee) } =>
		// { résultat = vecteur contenant les noms des auteurs ayant écrit au
		// moins un roman l'année an }
		int i = 0;
		int j = 0;
		String auteurAAjouter;
		boolean ajout;
		ArrayList<String> lesAuteurs = new ArrayList<>();

		while(i < vPolar.size()){
			if(vPolar.get(i).getAnnee() == an){
				auteurAAjouter = vPolar.get(i).getAuteur();
				ajout = true;
				while(j < lesAuteurs.size()){
					if(lesAuteurs.get(j).compareTo(auteurAAjouter) == 0){
						ajout = false;
					}

					j++;
				}

				j = 0;
				
				if(ajout){
					lesAuteurs.add(vPolar.get(i).getAuteur());
				}
			}

			i++;
		}
		return lesAuteurs;
	}
}