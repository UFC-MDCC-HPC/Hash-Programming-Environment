package hPE.frontend.base.commands;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.model.HComponent;


public class ExposedCommand extends Command {

	private HComponent component;
	
	
	public ExposedCommand(HComponent component) {
		super();
		this.component = component;		
	}

	
	public void execute() {

		component.setExposed(!component.isPublic());
		
		return;
	}
	
	public void undo () {
		component.setExposed(!component.isPublic());
	}
	
	public void redo () {
		component.setExposed(!component.isPublic());
	}
	
	public boolean canExecute() {
		return true;
	}

}
