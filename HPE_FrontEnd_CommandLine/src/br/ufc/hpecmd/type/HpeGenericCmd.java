package br.ufc.hpecmd.type;

import br.ufc.hpecmd.exception.ArgException;

public interface HpeGenericCmd {
	public void action(String args[]) throws ArgException;
	public String help();
}
