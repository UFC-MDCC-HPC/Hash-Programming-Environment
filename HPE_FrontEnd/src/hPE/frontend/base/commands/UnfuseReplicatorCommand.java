package hPE.frontend.base.commands;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.model.HReplicator;

public class UnfuseReplicatorCommand extends Command {

	HReplicator r;
	
	public UnfuseReplicatorCommand(HReplicator r) {
		super();
		this.r = r;
	}

	
	public void execute() {
	    r.unjoin();
		return;
	}
	
	public boolean canUndo () {
		return false;
	}
	
	
	public boolean canExecute() {
		return true;
	}

}
