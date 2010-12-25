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

		component.setExposed(!component.getExposed());
		
		return;
	}
	
	public void undo () {
		component.setExposed(!component.getExposed());
	}
	
	public void redo () {
		component.setExposed(!component.getExposed());
	}
	
	public boolean canExecute() {
		return true;
	}

}
