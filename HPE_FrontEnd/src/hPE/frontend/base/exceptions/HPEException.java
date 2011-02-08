package hPE.frontend.base.exceptions;

public class HPEException extends Exception {

	private static final long serialVersionUID = 8270500036949136072L;

	public HPEException(String message) {
		super(message);
	}

	public HPEException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
