
package hPE.frontend.base.commands;


import org.eclipse.gef.commands.Command;

import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IBindingTarget;
import hPE.frontend.base.model.IHUnit;


public class UnbindCommand extends Command {
	
	HBinding binding;
	IHUnit the_unit;
	
	public UnbindCommand(HBinding binding) {
		super();
		if (binding == null) {
			throw new IllegalArgumentException();
		}
		setLabel("Unbind !!!");
		this.binding = binding;
		
		IBindingTarget port = this.binding.getPort();
		if (port instanceof HUnitSlice) {
			this.the_unit = (IHUnit)((HUnitSlice)port).getUnit();
		}
		
	}
	
	public void execute() {
		this.binding.getEntry().unsetBinding();
		this.binding.getPort().unsetBinding();
		if (this.the_unit != null)
		   this.the_unit.removeUnitSlice((HUnitSlice) this.binding.getPort());
		else {
	       IHUnit u  = (IHUnit) binding.getPort();
	       u.remove();
		}
	}
	
	public boolean canUndo () { return false;}
	
	public void undo() {
		this.binding.getEntry().setBinding(this.binding);
		this.binding.getPort().setBinding(this.binding);
		if (this.the_unit != null)
		   this.the_unit.addUnitSlice((HUnitSlice)this.binding.getPort());
		return;
	}
	
	public void redo() {
		execute();
	    return;
	}
	
	public boolean canExecute() {
				
		if (the_unit != null)
		     return the_unit.getInterface() == null;
		else 
			 return true;
			 
			 
	}

}
