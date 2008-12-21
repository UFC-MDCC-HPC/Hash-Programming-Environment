package hPE.frontend.commands.base;

import org.eclipse.gef.commands.Command;

import hPE.model.base.HComponent;
import hPE.model.base.HReplicator;

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

		
		new_replicator = new HReplicator(the_configuration,the_location);

		undo_command = new RemoveReplicatorCommand(new_replicator);
		
		return;
	}
	
	public void undo() {
		if (undo_command != null)
		   undo_command.execute();
		
	}
	
	public void redo() {
	    execute();	
	}

}
