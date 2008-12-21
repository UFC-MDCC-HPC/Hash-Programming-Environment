package hPE.frontend.commands.base;

import hPE.model.base.IHUnit;

import org.eclipse.gef.commands.Command;

public class RemoveUnitCommand extends Command {

    IHUnit the_unit;
	
	public RemoveUnitCommand(IHUnit u) {
		super();
		
		this.the_unit = u;
	}

	public void execute() {
		if (the_unit.getInterface() != null) the_unit.detachFromInterface();
        the_unit.remove();		
		return;
	}

	public boolean canExecute() {
		if (the_unit instanceof IHUnit) {
			return ((IHUnit)the_unit).getSlices().size() == 0 && the_unit.getReplicators().size() == 0;
		} else {
			return true;
		}
		
	}
	

}
