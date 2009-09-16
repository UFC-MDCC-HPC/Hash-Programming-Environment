
package hPE.frontend.base.commands;


import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.InputDialog;

import java.util.List;

import javax.swing.JOptionPane;

import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;


public class SetReplicatorFactorCommand extends Command {
		
	private HReplicator replicator;
	
	private InputDialog dialog = null;

	public void setDialog(InputDialog dialog) {
		this.dialog = dialog;
	}
	
	public SetReplicatorFactorCommand(HReplicator replicator) {
		super();
		if (replicator == null) {
			throw new IllegalArgumentException();
		}
		setLabel("Replicator factor");
	    this.replicator = replicator;
	}
	
	private String varName = null;
	private boolean cancel = false;
	
	public void execute() {
	
		if (!replicator.getVarId().equals("*")) {
           replicator.setFactor(1);
		} else {
		  JOptionPane.showMessageDialog(null, "Give an id to the enumerator.", "Forbidden Operation", JOptionPane.ERROR_MESSAGE);
		}
		
		
//	   dialog.open();
//	   int r = dialog.getReturnCode();
	   
//	   if (r == 0) {
//	      varName = dialog.getValue();
//	      int factor = Integer.parseInt(varName);
//	      if (factor > 0) {
//	              replicator.setFactor(factor);
//		      } else {
//		    	  replicator.setUndeterminedFactor();
//		      }
//	   }
//	   else {
//		   cancel = true;
//	   }
		
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
 