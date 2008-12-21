package hPE.frontend.commands.base;

import org.eclipse.gef.commands.Command;

import hPE.model.base.HComponent;


public class InheritFromCommand extends Command {

	private HComponent superType;
	private HComponent subType;
	
	
	public InheritFromCommand(HComponent superType) {
		super();
		this.superType = superType;
		this.subType = (HComponent) superType.getTopConfiguration();		
		// In fact, the super type is always son of the top configuration.
		// Thus, getConfiguration() always return only one configuration.
	}

	
	public void execute() {

		subType.setExtends(superType);
		
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
