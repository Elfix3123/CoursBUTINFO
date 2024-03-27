package tp06;

public class StockInsuffisantException extends RuntimeException {
	public StockInsuffisantException(String e) {
		super(e);
	}

	public StockInsuffisantException() {
		super();
	}
}
