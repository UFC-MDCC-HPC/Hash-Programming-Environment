package hPE.frontend.commandline.type;

import hPE.frontend.commandline.exception.ArgException;

public class HpeStoreCmd implements HpeGenericCmd{

	@Override
	public void action(String[] args) throws ArgException{
		// TODO Auto-generated method stub
		System.out.println("Action store " + args);
		
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "Help store";
	}

}
