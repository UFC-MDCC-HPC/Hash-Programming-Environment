package hPE.frontend.commandline.type;

import hPE.frontend.commandline.exception.ArgException;

public class HpeDeployCmd implements HpeGenericCmd{

	@Override
	public void action(String[] args) throws ArgException{
		// TODO Auto-generated method stub
		System.out.println("Action deploy " + args);
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Help deploy";
	}

}
