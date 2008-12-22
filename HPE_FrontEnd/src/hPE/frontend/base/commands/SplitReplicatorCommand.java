
package hPE.frontend.base.commands;


import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.InputDialog;

import java.util.List;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;


public class SplitReplicatorCommand extends Command {
	
	private List<HLinkToReplicator> links;
	
	private HReplicator replicator;
	
	private InputDialog dialog = null;

	public void setDialog(InputDialog dialog) {
		this.dialog = dialog;
	}
	
    public void setLinks(List<HLinkToReplicator> links) {
    	this.links = links;
    }
	
	public SplitReplicatorCommand(HLinkToReplicator link) {
		super();
		if (link == null) {
			throw new IllegalArgumentException();
		}
		setLabel("Unreplicate an element");
		
	    this.replicator = link.getReplicator();
	    while (this.replicator.isJoined()) {
	    	this.replicator = this.replicator.getJoined();
	    }
	    
	}
	
	private String varName = null;
	private boolean cancel = false;
	
	public void execute() {
		
	   dialog.open();
	   int r = dialog.getReturnCode();
	   
	   if (r == 0) {
	      varName = dialog.getValue();
	      int factor = Integer.parseInt(varName);
	      if (factor > 1) {
             replicator.split(factor,"",links,(HComponent)replicator.getConfiguration().getTopConfiguration(),null);
	      }
	   }
	   else {
		   cancel = true;
	   }
		
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
 