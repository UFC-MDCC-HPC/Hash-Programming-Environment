package hPE.frontend.commands.base;

import org.eclipse.gef.commands.Command;

import hPE.model.base.HReplicator;

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
