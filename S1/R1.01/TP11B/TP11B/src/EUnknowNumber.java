public class EUnknowNumber extends Exception{
	// constructeur par défaut
	public EUnknowNumber() { super(); }

	// constructeur avec paramètre de type string
	// s : est un message d'erreur associé à l'exception
	public EUnknowNumber(String s) {
		super(s);
	}
}
