package tp04.dalton;

import java.util.Comparator;

public class ComparateurNom implements Comparator<Dalton>{
	@Override
	public int compare(Dalton d1, Dalton d2) {
		return d1.getNom().compareTo(d2.getNom());
	}
}
