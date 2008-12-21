
package hPE.frontend.commands.base;


import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.InputDialog;

import java.util.List;

import hPE.model.base.HLinkToReplicator;
import hPE.model.base.HReplicator;
import hPE.model.base.HReplicatorSplit;


public class JoinReplicatorCommand extends Command {
	
	List links;
	
	HReplicator replicator;
	
	InputDialog dialog = null;

	public void setDialog(InputDialog dialog) {
		this.dialog = dialog;
	}
	
    public void setLinks(List links) {
    	this.links = links;
    }
	
	public JoinReplicatorCommand(HLinkToReplicator link) {
		super();
		if (link == null) {
			throw new IllegalArgumentException();
		}
		setLabel("Join unit replicators");
	    this.replicator = link.getReplicator();
	}
	
	private String varName = null;
	private boolean cancel = false;
	
	public void execute() {		
		
		   new HReplicatorSplit("",links,null /* TODO: revise! */);
		
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
 