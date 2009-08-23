package hPE.frontend.base.commands;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

public class SetPermutationCommand extends Command {

	private HLinkToReplicator link = null;
	private HEnumeratorComponent c = null;
	
	public SetPermutationCommand() {
		super();
	}

	public void setLinkToReplicator(HLinkToReplicator r) {
		this.link = r;
	}
	
	public void setPermutation(HEnumeratorComponent c) {
		this.c = c;
	}

	public void execute() {
  
		link.setPermutation(c);
		
		HComponent cTop = (HComponent) c.getTopConfiguration();
		cTop.removeComponent(c);
		
		return;
	}
	
	
	public void redo () {
		execute();
	}
	
	public boolean canExecute() {
		   if (c.hasFreeVariables()) {
			   JOptionPane.showMessageDialog(null, "The inner component has free type variables. You must supply them before to lift units.","Aborting Operation !", JOptionPane.ERROR_MESSAGE);			   
			   return false;
		   }
		   return true;
	}

}
