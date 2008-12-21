
package hPE.frontend.commands.base;


import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.InputDialog;

import java.util.List;

import javax.swing.JOptionPane;

import hPE.model.base.HLinkToReplicator;
import hPE.model.base.HReplicator;


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
		
	   dialog.open();
	   int r = dialog.getReturnCode();
	   
	   if (r == 0) {
	      varName = dialog.getValue();
	      int factor = Integer.parseInt(varName);
	      //if (replicator.isNewFactorValid(factor)) {
		      if (factor > 0) {
	              replicator.setFactor(factor);
		      } else {
		    	  replicator.setUndeterminedFactor();
		      }
	      //} else {
		//	   JOptionPane.showMessageDialog(null, "Cardinality of enumerators with the same id must be the same !", "Cardinality Updating Error", JOptionPane.ERROR_MESSAGE);   
	     // }
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
 