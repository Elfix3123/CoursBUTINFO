import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {
	public static int indContinent(ArrayList<String> vCont, String cont) {
		// { vCont trié } =>
		// { résultat = * -1 si cont est déjà dans vCont
		// * indice où il faudrait insérer cont dans VCont
		// pour conserver le tri de ce vecteur, sinon }
		if(vCont.size() == 0 || cont.compareTo(vCont.get(vCont.size()-1)) > 0){
			return vCont.size();
		}
		else{
			// Invariant : vCont[0..inf-1] < cont < vCont[sup..vCont.size()]
			int inf = 0;
			int sup = vCont.size() - 1;
			int m;
			while(inf < sup){
				m = (inf+sup)/2;
				if(vCont.get(m).compareTo(cont) >= 0){
					sup = m;	// Si cont <= vCont[m], alors cont n'est pas dans vCont[sup..vCont.size()] 
				}
				else{
					inf = m + 1;	// Sinon, cont n'est pas dans vCont[vCont.size()..inf] 
				}
			}
			// inf == sup : inf est l'endroit ou devrait se situer cont dans vCont
			if(cont.compareTo(vCont.get(inf)) == 0){
				return -1;
			}
			else{
				return inf;
			}
		}
	}
	
	public static boolean existString(ArrayList<String> vString, String uneString) {
		// { vString trié } =>
		// { résultat = vrai si uneString appartient à vString }
		int i = 0;
		// Invariant de boucle : uneString n'appartient pas à vString[0..i-1]
		while(i < vString.size() && vString.get(i).compareTo(uneString) < 0){
			i++;
		}
		// On a trouvé si et seulement si on s'est arrété à l'interieur de vString
		// et si vSize[i] est l'élément recherché
		return i < vString.size() && vString.get(i) == uneString;	
	}
	
	public static ArrayList<Pays> paysDeCont(ArrayList<Pays> vPays, String cont) {
		// { cont est le continent d'au moins un pays de vPays } =>
		// { résultat = vecteur contenant les pays de vPays
		// dont le continent est cont }
		int i = 0;
		ArrayList<Pays> resultat = new ArrayList<>();
		while(i < vPays.size()){
			if(vPays.get(i).getContinent().equals(cont)){
				resultat.add(vPays.get(i));
			}
			i++;
		}
		return resultat;
	}
	
	public static String saisieCont(ArrayList<String> vCont) {
		// { vCont trié, non vide } =>
		// { résultat = valeur d'un élément de vCont saisie par l'utilisateur }
		// LA SAISIE DOIT ÊTRE CONTRÔLÉE
		Scanner lecteur = new Scanner(System.in);
		System.out.print("Choisissez le nom d'un continent dans " + vCont + " : ");
		String entreeUtilisateur = lecteur.nextLine();
		while(indContinent(vCont, entreeUtilisateur) != -1){
			System.out.println("--> saisie invalide recommencez...");
			System.out.print("Choisissez le nom d'un continent dans " + vCont + " : ");
			entreeUtilisateur = lecteur.nextLine();
		}
		return entreeUtilisateur;
	}

	public static int rechPaysT(ArrayList<Pays> vPays, String nomP) {
		// { vPays trié sur le nom } =>
		// { résultat = indice dans vPays du pays de nom nomP s'il existe,
		// vPays.size() si pas de pays de nom nomP dans vPays }
		if(vPays.size() == 0 || nomP.compareTo(vPays.get(vPays.size()-1).getNom()) > 0){
			return vPays.size();
		}
		else{
			// Invariant : vPays[0..inf-1] < nomP < vPays[sup..vPays.size()]
			int inf = 0;
			int sup = vPays.size() - 1;
			int m;
			while(inf < sup){
				m = (inf+sup)/2;
				if(vPays.get(m).getNom().compareTo(nomP) >= 0){
					sup = m;	// Si nomP <= vPays[m], alors nomP n'est pas dans vPays[sup..vPays.size()] 
				}
				else{
					inf = m + 1;	// Sinon, nomP n'est pas dans vPays[vPays.size()..inf] 
				}
			}
			// inf == sup : inf est l'endroit ou devrait se situer nomP dans vPays
			if(nomP.compareTo(vPays.get(inf).getNom()) == 0){
				return inf;
			}
			else{
				return vPays.size();
			}
		}
	}
}
