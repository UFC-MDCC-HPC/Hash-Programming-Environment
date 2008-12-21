
package hPE.frontend.commands.base;


import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.model.base.HBinding;
import hPE.model.base.HPrimUnitStub;
import hPE.model.base.HReplicator;
import hPE.model.base.IHPrimUnit;
import hPE.model.base.IReplicatedElement;
import hPE.model.base.exceptions.HPEUnmatchingEnumeratorsException;


public class SetReplicatorCommand extends Command {
	
	IReplicatedElement the_replicated;
	HReplicator the_replicator;
	
	public SetReplicatorCommand(IReplicatedElement the_replicated) {
		super();
		if (the_replicated == null) {
			throw new IllegalArgumentException();
		}
		setLabel("Replicate an element");
		this.the_replicated = the_replicated;
	}
	
	public void execute() {
		try {
			this.the_replicated.setReplicator(this.the_replicator);
		} catch (HPEUnmatchingEnumeratorsException e) {
		    JOptionPane.showMessageDialog(null, e.getMessage(),"Aborting Operation !", JOptionPane.ERROR_MESSAGE);			   
		}

	}
	
	public void undo() {
		this.the_replicated.unSetReplicator(the_replicator);		
	}
	
	public void redo() {
	    execute();	
	}
	
	public void setTarget(HReplicator the_replicator) {
		this.the_replicator = the_replicator;
	}
	
		
	public boolean canExecute() {
	
		if (the_replicated.isReplicatedBy(the_replicator)) 
			return false;
		
        if (the_replicated instanceof IHPrimUnit) {
        	IHPrimUnit u = (IHPrimUnit) the_replicated;
			
        	for (HBinding b : u.getBindings()) {
	        	if (u.isEntry() && u.getBinding() != null &&
	        		b.getPort() instanceof HPrimUnitStub && 
	        		!(u instanceof HPrimUnitStub)) return false;
        	}
        }

				
		return true;
	}

}
