
package hPE.frontend.base.commands;


import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.InputDialog;

import java.util.List;

import javax.swing.JOptionPane;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HComponent.NoInnerOcurrencesException;


public class SetRecursiveCommand extends Command {
	

	private HComponent cBasis = null;
	
	public SetRecursiveCommand(HComponent cBasis) {
		super();
		if (cBasis == null) {
			throw new IllegalArgumentException();
		}
		
		this.cBasis = cBasis;
		
		setLabel("Set Recursive");
	}
	
	
	public void execute() {

		if (cBasis.isRecursive())
		    cBasis.setRecursive(false);
		else
			cBasis.setRecursive(true);
		
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
 