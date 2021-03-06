package hPE.frontend.base.commands;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HPrimUnit;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

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
	
	public boolean canExecute() {

		return true;
	}

}
