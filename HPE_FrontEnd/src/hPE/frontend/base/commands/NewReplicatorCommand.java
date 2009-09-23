package hPE.frontend.base.commands;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

import org.eclipse.draw2d.geometry.Point;

public class NewReplicatorCommand extends Command {

    HReplicator new_replicator;	
    HComponent the_configuration;
    Point the_location;
    
    RemoveReplicatorCommand undo_command = null;
	
	public NewReplicatorCommand(HComponent configuration, Point location) {
		super();
		this.the_configuration = configuration;
		this.the_location = location;
	}

	public HReplicator getReplicator() { return new_replicator; }
	
	public void execute() {

		
		if (the_configuration instanceof HEnumeratorComponent) {
			JOptionPane.showMessageDialog(null, "An Enumerator cannot have enumerators.", "New Enumerator Error", JOptionPane.WARNING_MESSAGE);
		} else {
			new_replicator = new HReplicator(the_configuration,the_location);
			undo_command = new RemoveReplicatorCommand(new_replicator);
		}
		
		return;
	}
	
	public void undo() {
		if (undo_command != null)
		   undo_command.execute();
		
	}
	
	public void redo() {
	    execute();	
	}
	
	public boolean canExecute() {
		return true;
	}

}
