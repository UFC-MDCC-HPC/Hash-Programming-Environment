package hPE.frontend.commandline.type;

import hPE.frontend.commandline.exception.ArgException;

public interface HpeGenericCmd {
	public void action(String args[]) throws ArgException;
	public String help();
}
