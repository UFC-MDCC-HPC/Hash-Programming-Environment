package hPE.frontend.commandline.exception;

public class ArgException extends Exception{
 
	private static final long serialVersionUID = 1L;

	public ArgException(String string) {
		super(string);
	}

	public ArgException() {
		super();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invalid argument[s]: " + super.getMessage();
	}
}
