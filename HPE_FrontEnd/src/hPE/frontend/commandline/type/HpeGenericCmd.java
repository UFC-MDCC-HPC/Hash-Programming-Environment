package hPE.frontend.commandline.type;

import java.io.IOException;

import javax.xml.rpc.ServiceException;

import hPE.frontend.commandline.exception.ArgException;
import hPE.frontend.commandline.exception.CmdException;

public interface HpeGenericCmd {
	public void action(String args[]) throws ArgException, CmdException;
	public String help();
}
