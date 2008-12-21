
package hPE.frontend.commands.base;


import org.eclipse.gef.commands.Command;

import hPE.model.base.HInterface;
import hPE.model.base.IHUnit;


public class DetachInterfaceCommand extends Command {
	
	IHUnit the_unit;
	HInterface the_interface;
	
	public DetachInterfaceCommand(IHUnit the_unit) {
		super();
		if (the_unit == null) {
			throw new IllegalArgumentException();
		}
		setLabel("Dettaching unit from interface");
		this.the_unit = the_unit;
	}
	
	public void execute() {
		this.the_interface = (HInterface) this.the_unit.getInterface();
		this.the_unit.detachFromInterface();
	}
	
	public void undo() {
		this.the_unit.attachToInterface(this.the_interface);		
	}
	
	public void redo() {
	    execute();	
	}
			
	public boolean canExecute() {
	
		if (the_unit.getInterface() == null || !the_unit.isInterfaceEditable()) return false;
				
		return true;
	}

}
