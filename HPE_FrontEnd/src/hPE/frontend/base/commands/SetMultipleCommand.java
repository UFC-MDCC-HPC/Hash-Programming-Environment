
package hPE.frontend.base.commands;


import hPE.frontend.base.interfaces.IElement;

import org.eclipse.gef.commands.Command;


public class SetMultipleCommand extends Command {
	

	private IElement cBasis = null;
	
	public SetMultipleCommand(IElement cBasis) {
		super();
		if (cBasis == null) {
			throw new IllegalArgumentException();
		}
		
		this.cBasis = cBasis;
		
		setLabel("Set Parallel");
	}
	
	
	public void execute() {

		cBasis.setMultiple(!cBasis.isMultiple());
		
	}
	
	public boolean canUndo() {
		return false;
	}
	
	public boolean canRedo() {
	    return false;
	}
	
	public boolean canExecute() {
		return true;
	}

}
 