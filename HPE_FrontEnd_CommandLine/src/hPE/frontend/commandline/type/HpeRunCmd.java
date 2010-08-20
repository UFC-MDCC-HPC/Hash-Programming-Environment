package hPE.frontend.commandline.type;

import hPE.frontend.commandline.exception.ArgException;

public class HpeRunCmd implements HpeGenericCmd{

	@Override
	public void action(String[] args) throws ArgException{
		// TODO Auto-generated method stub
		if(args == null)
			throw new ArgException();
		System.out.println("Action run " + args[3]);
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Help run";
	}

}
