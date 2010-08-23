package hPE.frontend.commandline.type;

import hPE.frontend.commandline.exception.ArgException;
import hPE.frontend.commandline.exception.CmdException;

public interface HpeGenericCmd {
	public void action(String args[]) throws ArgException, CmdException;
	public String help();
}
