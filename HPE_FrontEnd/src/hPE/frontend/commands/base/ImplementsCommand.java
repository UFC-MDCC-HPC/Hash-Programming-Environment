package hPE.frontend.commands.base;

import org.eclipse.gef.commands.Command;

import hPE.model.base.HComponent;


public class ImplementsCommand extends Command {

	private HComponent abstractConfiguration;
	private HComponent component;
	
	
	public ImplementsCommand(HComponent abstractComponent) {
		super();
		this.abstractConfiguration = abstractComponent;
		this.component = (HComponent) abstractConfiguration.getTopConfiguration();
		// In fact, the abstract configuration is always son of the top configuration.
		// Thus, getConfiguration() always return only one configuration.
	}

	
	public void execute() {

		component.setImplements(abstractConfiguration);
		
		return;
	}
	
	public void undo () {

	}
	
	public void redo () {

	}
	
	public boolean canExecute() {
		return true;
	}

}
