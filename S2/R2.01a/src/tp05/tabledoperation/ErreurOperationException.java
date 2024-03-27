package tp05.tabledoperation;

public class ErreurOperationException extends Exception{
	public ErreurOperationException(String message) {
		super(message);
	}

	public ErreurOperationException() {
		super();
	}
}
