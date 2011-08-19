package hPE.ui.preferences;

/**
 * 
 * @author Juliano Efson Sales
 * @since 0.1.1
 *
 */
@SuppressWarnings("serial")
public class DuplicateLocationException extends Exception {

	protected static String defaultMessage = "This location name already exists.";

	@SuppressWarnings("unused")
	private DuplicateLocationException() {

	}

	public DuplicateLocationException(String name) {
		super(defaultMessage + ": " + name);
	}
}
