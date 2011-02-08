package hPE.frontend.base.commands;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HPrimUnit;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

import javax.swing.JOptionPane;

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

	@Override
	public void execute() {

		if (the_configuration instanceof HEnumeratorComponent) {
			JOptionPane.showMessageDialog(null, "An Enumerator cannot have more than one unit.", "New Unit Error", JOptionPane.WARNING_MESSAGE);
		} else {
			HPrimUnit new_unit = the_configuration.createUnit();
			new_unit.setLocation(the_location);
		}

	}

	@Override
	public boolean canUndo() {
		return false;

	}

	@Override
	public boolean canExecute() {

		return true;
	}

}
