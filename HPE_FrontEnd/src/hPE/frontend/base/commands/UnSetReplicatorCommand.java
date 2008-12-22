
package hPE.frontend.base.commands;


import org.eclipse.gef.commands.Command;

import hPE.frontend.base.model.HLinkToReplicator;


public class UnSetReplicatorCommand extends Command {
	
	HLinkToReplicator link;
	
	public UnSetReplicatorCommand(HLinkToReplicator link) {
		super();
		if (link == null) {
			throw new IllegalArgumentException();
		}
		setLabel("Unreplicate an element");
		this.link = link;
	}
	
	public void execute() {
		this.link.getReplicated().unSetReplicator(link.getReplicator());
	}
	
	public boolean canUndo() {
		return false;
	}
	
	public boolean canRedo() {
	    return false;
	}
	
	public boolean canExecute() {
		return true;
	}

}