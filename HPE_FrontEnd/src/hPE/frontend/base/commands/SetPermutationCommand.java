package hPE.frontend.base.commands;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.HReplicatorSplit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.model.IPointsToReplicator;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

public class SetPermutationCommand extends Command {

	private HReplicatorSplit split = null;
	private HEnumeratorComponent c = null;
	
	public SetPermutationCommand() {
		super();
	}

	public void setLinkToReplicator(HReplicatorSplit r) {
		this.split = r;
	}
	
	public void setPermutation(HEnumeratorComponent c) {
		this.c = c;
	}

	public void execute() {
  
		split.setPermutation(c);
		
		HComponent cTop = (HComponent) c.getTopConfiguration();
		cTop.hideInnerComponent(c);
		
		return;
	}
	
	
	public void redo () {
		execute();
	}
	
	public boolean canExecute() {
		   if (c.hasFreeVariables()) {
			   JOptionPane.showMessageDialog(null, 
					   "The enumerator inner component has free type variables. You must supply them before to apply this operation.",
					    "Aborting Operation !", JOptionPane.ERROR_MESSAGE);			   
			   return false;
		   }
		   
			if (c.getRef().equals(HComponent.UNDEFINED_NAME)) {
				JOptionPane.showMessageDialog(null, "This component has an undefined identifier.", "Supply Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		   
		   return true;
	}

}
