package hPE.frontend.base.commands;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HReplicator;

public class FuseReplicatorCommand extends Command {

	private HReplicator rTop;
	private HReplicator r;
	
	public FuseReplicatorCommand(HReplicator r) {
		super();
		this.r = r;
	}

	public void setTop(HReplicator rTop) {
		this.rTop = rTop;
	}
	
	public void execute() {
		if (rTop != r)
		    rTop.join(r);
		else 
	    	rTop.newCurrentMyJoined((HComponent)rTop.getConfiguration().getTopConfiguration());

		return;
	}
	
	public void undo () {
		rTop.unjoin();
	}
	
	public void redo () {
		execute();
	}
	
	public boolean canExecute() {
		if (rTop.getName2().equals(r.getName2())) return true;
		else {
			JOptionPane.showMessageDialog(null, "Replicators must have the same ID","Join Replicator Error", JOptionPane.ERROR_MESSAGE);		
			return false;
		}
	}

}
