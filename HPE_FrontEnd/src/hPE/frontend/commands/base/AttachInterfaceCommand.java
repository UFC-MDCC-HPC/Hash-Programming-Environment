
package hPE.frontend.commands.base;



import org.eclipse.gef.commands.Command;

import hPE.model.base.HInterface;
import hPE.model.base.IHUnit;


public class AttachInterfaceCommand extends Command {
	
	IHUnit the_unit = null;
	HInterface the_interface = null;
	
	public AttachInterfaceCommand(IHUnit the_unit) {
		super();
		if (the_unit == null) {
			throw new IllegalArgumentException();
		}
		setLabel("Attaching unit to interface");
		this.the_unit = the_unit;
	}
	
	public void execute() {
		if (the_interface != null) this.the_unit.attachToInterface(this.the_interface);
 
	}
	
	public void undo() {
				
		if (the_interface != null) this.the_unit.detachFromInterface();
	}
	
	public void redo() {
	    execute();	
	}
	
	public void setTarget(HInterface the_interface) {
		this.the_interface = the_interface;
	}

	public void setUnit(IHUnit u) {
		this.the_unit = u;
	}
		
	public boolean canExecute() {
	
		
		if (this.the_interface != null) {		
			if (the_unit.getInterface() != null) return false;
		    if (!the_unit.matchForAttachment(this.the_interface)) return false;
		    return true;
		} 
		
		return true;
	}

}
