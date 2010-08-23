package hPE.frontend.commandline.exception;

public class CmdException extends Exception{
 
	private static final long serialVersionUID = 1L;

	public CmdException(String string) {
		super(string);
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invalid Command";
	}	
}
