package hPE.frontend.base.commands;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HPrimUnit;
import hPE.frontend.kinds.activate.model.HActivateConfiguration;
import hPE.frontend.kinds.computation.model.HComputationUnit;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.data.model.HDataUnit;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

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

		if (the_configuration instanceof HEnumeratorComponent) {
			JOptionPane.showMessageDialog(null, "An Enumerator cannot have more than one unit.", "New Unit Error", JOptionPane.WARNING_MESSAGE);
		} else {
			HPrimUnit new_unit = the_configuration.createUnit();
			new_unit.setLocation(the_location);
		}
		
	}
	
	public boolean canUndo() {
		return false;
		
	}
	
	public boolean canExecute() {

		return true;
	}

}
