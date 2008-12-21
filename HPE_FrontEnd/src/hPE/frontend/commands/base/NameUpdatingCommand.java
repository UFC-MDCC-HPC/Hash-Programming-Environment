package hPE.frontend.commands.base;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.model.base.HNamed;
import hPE.model.base.exceptions.HPEInvalidNameException;

public class NameUpdatingCommand extends Command {

	private String new_name;
	private String old_name;
	
	private HNamed the_named;
	
	public NameUpdatingCommand(HNamed named, String label) {
		
		super(label);

		the_named = named;
		old_name = named.getName2();
		new_name = label;
	}
	
	public void execute () {
	   try { 
	      the_named.setName(new_name);
	   } 
	   catch (HPEInvalidNameException e) {
		   JOptionPane.showMessageDialog(null, e.getMessage(),"Name Updating Error", JOptionPane.ERROR_MESSAGE);   
	   }

	}
	
	public void redo () {
	   execute();	
	}

	public void undo () {
	   try {
		   the_named.setName(old_name);
	   } 
	   catch (HPEInvalidNameException e) {
			   
	   }

	}
	
	public boolean canExecute() {
		if (new_name.equals("")) return false;
		                         else return true;
	}
	
}
