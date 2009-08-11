
package hPE.frontend.base.commands;


import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.InputDialog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;


public class SplitReplicatorCommand extends Command {
	
	private List<HLinkToReplicator> links;
	
	private HReplicator replicator;
	
	private InputDialog dialog = null;

	public void setDialog(InputDialog dialog) {
		this.dialog = dialog;
	}
		
	public SplitReplicatorCommand(HReplicator replicator) {
		super();
		if (replicator == null) {
			throw new IllegalArgumentException();
		}
		setLabel("Split an enumeration");
		
	    this.replicator = replicator;
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
		boolean alreadyreplicated = !replicator.getSplits().isEmpty();
		if (alreadyreplicated) {
			JOptionPane.showMessageDialog(null, "Cannot split an enumerator twice !", "Bad Configuration", JOptionPane.ERROR_MESSAGE);			
		}
		
		boolean onlyreplicateslices = true;
		
		Collection<HLinkToReplicator> ls = replicator.getLinksToMe();

		links = new ArrayList<HLinkToReplicator>();
		
		for (HLinkToReplicator l : ls){
			if (!l.isInvisible()) {
				if ((l.getReplicated() instanceof IHUnit)) { 
					IHUnit u = (IHUnit) l.getReplicated();
					HComponent cu = (HComponent) u.getConfiguration();
					boolean isInnerComponent = cu.isDirectSonOfTheTopConfiguration();
					
					if (isInnerComponent) {
						if (u.isEntry() && u.getBinding()==null) { 
							if (!links.contains(l))
								links.add(l);
						} else {
						}
					} else {
						if (cu.isTopConfiguration()) {
							onlyreplicateslices = false;
							break;
						}
					}
				} else {
					// test if it is a direct inner component of the current configuration.
					if (l.getReplicated() instanceof IComponent) {
					   HComponent c = (HComponent) l.getReplicated() ;
					   if (c.isDirectSonOfTheTopConfiguration()) {
							onlyreplicateslices = false;
							break;
					   }
					}
					// Test if it is a slice of unit of the current configuration.
					if (l.getReplicated() instanceof HUnitSlice) {
						   HUnitSlice uslice = (HUnitSlice) l.getReplicated();
						   IHUnit uofuslice = uslice.getUnit();
						   HComponent cofuofuslice = (HComponent) uofuslice.getConfiguration();
						   if (cofuofuslice.isTopConfiguration()){
								onlyreplicateslices = false;
								break;
						   }
						}
				}
			}
		}	
		
		if (!onlyreplicateslices) {
			JOptionPane.showMessageDialog(null, "It is not possible to split. The enumerator is linked " +
					                            "to units and/or inner components.", 
					                            "Bad Configuration", JOptionPane.ERROR_MESSAGE);			
		}
		
		
		return !alreadyreplicated && onlyreplicateslices ;
	}

}
 