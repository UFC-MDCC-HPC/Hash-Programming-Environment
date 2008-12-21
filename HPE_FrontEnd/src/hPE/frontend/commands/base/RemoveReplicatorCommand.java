package hPE.frontend.commands.base;

import hPE.model.base.HComponent;
import hPE.model.base.HLinkToReplicator;
import hPE.model.base.HReplicator;
import hPE.model.base.IReplicatedElement;
import hPE.model.exceptions.base.HPEInvalidNameException;
import hPE.model.exceptions.base.HPEUnmatchingEnumeratorsException;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class RemoveReplicatorCommand extends Command {

    HReplicator the_replicator;
    Rectangle replicator_bounds;
    String replicator_name;
    Collection replicated_ones = new ArrayList();
	
    NewReplicatorCommand undo_command = null;
    
	public RemoveReplicatorCommand(HReplicator u) {
		super();
		
		this.the_replicator = u;
	}

	public void execute() {
		
		undo_command = new NewReplicatorCommand((HComponent)the_replicator.getConfiguration(),the_replicator.getBounds().getLocation());
		replicator_bounds = the_replicator.getBounds();
		replicator_name = the_replicator.getName2();
		replicated_ones.addAll(the_replicator.getLinksToMe());
		
		// String label, HConfiguration configuration, Point location
        the_replicator.remove();
        
		return;
	}
	
	public void undo() {
		if (undo_command != null) {
   		   undo_command.execute();
   		   HReplicator new_replicator = undo_command.getReplicator();
   		   Iterator is =  replicated_ones.iterator();
   		   while (is.hasNext()) {
   			   IReplicatedElement hr = (IReplicatedElement) ((HLinkToReplicator)is.next()).getReplicated();
   			   try {
   				   hr.setReplicator(new_replicator);
   		       } catch (HPEUnmatchingEnumeratorsException e) {
			      System.err.println("Unexpected Exception !" + e.getMessage());
		       }

   		   }
   		   new_replicator.setBounds(replicator_bounds);
   		   try {
   			   new_replicator.setName(replicator_name);
   		   } catch (HPEInvalidNameException e) {
   			   
   		   }
		}
	}

	public void redo() {
		execute();
	}
	
	
	public boolean canExecute() {
		
		return !the_replicator.hasLinks() && !the_replicator.isSplitReplicator(); // the_replicator.getLinksToMe().size() == 0;
	}
	

}
