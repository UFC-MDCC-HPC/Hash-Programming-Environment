package hPE.frontend.commands.base;

import hPE.model.base.HComponent;

import org.eclipse.gef.commands.Command;


public class RemoveComponentCommand extends Command {

    HComponent the_component;
	
	public RemoveComponentCommand(HComponent c) {
		super();
		
		this.the_component = c;
	}

	public void execute() {
        ((HComponent)the_component.getTopConfiguration()).removeComponent(the_component);
        // The remove operations is always applied to a direct inner component of the top configuration 
        
		return;
	}

	public boolean canExecute() {
		return the_component.canRemoveMe(((HComponent)the_component.getTopConfiguration()).getAllInnerConfigurations(),(HComponent)the_component.getTopConfiguration());
	}
	

}
