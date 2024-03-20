package tp04.dalton;

import java.util.Comparator;

public class ComparateurTaille implements Comparator<Dalton>{
	@Override
	public int compare(Dalton d1, Dalton d2) {
		return d1.getTaille().ordinal() - d2.getTaille().ordinal();
	}
}
