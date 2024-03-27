package tp06;

public class StockInvalideException extends RuntimeException {
	public StockInvalideException(String e) {
		super(e);
	}

	public StockInvalideException() {
		super();
	}
}
