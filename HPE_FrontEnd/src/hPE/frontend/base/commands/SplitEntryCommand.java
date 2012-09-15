
package hPE.frontend.base.commands;


import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;

import org.eclipse.gef.commands.Command;


public class SplitEntryCommand extends Command {
	

	private HUnit u = null;
	
	public SplitEntryCommand(HUnit u) {
		super();
		if (u == null) {
			throw new IllegalArgumentException();
		}
		
		this.u = u;
		
		setLabel("Split unit");
	}
	
	private HUnit u_clone;
	public HUnit getReplica()
	{
		return u_clone;
	}
	
	public void execute() 
	{
		HUnit u = this.u;
		while (u.isClone()) 
			u = (HUnit) u.cloneOf();
		
	    u_clone = (HUnit) u.createReplica(u.getClones().size()-1);
	    //u_clone.setBounds(u.getBounds().translate(10,10));
	    //HComponent c = (HComponent) u.getConfiguration();
	    
	    
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
 