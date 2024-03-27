package tp06;

public class PrixInvalideException extends RuntimeException {
	public PrixInvalideException(String e) {
		super(e);
	}

	public PrixInvalideException() {
		super();
	}
}
