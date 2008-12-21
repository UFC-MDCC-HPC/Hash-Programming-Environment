package hPE.frontend.commands.base;

import org.eclipse.gef.commands.Command;

import hPE.model.base.HComponent;
import hPE.model.base.HPrimUnit;
import hPE.model.kinds.activate.HActivateConfiguration;
import hPE.model.kinds.activate.computation.HComputationUnit;
import hPE.model.kinds.data.HDataComponent;
import hPE.model.kinds.data.HDataUnit;

import org.eclipse.draw2d.geometry.Point;

public class NewUnitCommand extends Command {

    HPrimUnit new_unit;	
    HComponent the_configuration;
    Point the_location;
	
	public NewUnitCommand(String label, HComponent configuration, Point location) {
		super(label);
		this.the_configuration = configuration;
		this.the_location = location;
	}
	
	public void execute() {

		HPrimUnit new_unit = the_configuration.createUnit();
		new_unit.setLocation(the_location);
		
	}
	
	public boolean canUndo() {
		return false;
		
	}

}
