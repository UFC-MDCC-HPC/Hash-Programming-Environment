package hPE.frontend.commandline.type;

import hPE.frontend.commandline.exception.ArgException;

public class HpeRegisterCmd implements HpeGenericCmd{

	@Override
	public void action(String[] args) throws ArgException{
		// TODO Auto-generated method stub
		System.out.println("Action register " +args);
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Help register";
	}

}
