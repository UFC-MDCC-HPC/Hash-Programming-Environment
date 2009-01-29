package hPE.frontend.base.policies;

import javax.swing.JPanel;

import hPE.HPEVersionEditor;
import hPE.frontend.base.dialogs.NewVersionShell;
import hPE.frontend.base.dialogs.RegisterComponentDialog;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.model.HComponent;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


public class RegisterComponentEditPolicy extends ComponentEditPolicy {

public RegisterComponentEditPolicy() {
	super();
}
	
private static final String
	REGISTER_COMPONENT_REQUEST = "Register Component";  //$NON-NLS-1$

public Command getCommand(Request request) {
		
	if (REGISTER_COMPONENT_REQUEST.equals(request.getType()))
		return new RegisterComponentCommand((ConfigurationEditPart)this.getHost());
	return 
	    super.getCommand(request);
	
	
	
}

static class RegisterComponentCommand 
extends org.eclipse.gef.commands.Command{

private ConfigurationEditPart part;

private HComponent c = null;
private HPEVersionEditor editor = null;


public RegisterComponentCommand(ConfigurationEditPart part){

  this.part = part;
  c = (HComponent) part.getModel();

      
}

public void execute(){

	RegisterComponentDialog dialog = new RegisterComponentDialog(null, c);

	dialog.setModal(true);
//	dialog.pack();
	dialog.setVisible(true);	

	
			
	
}



public void undo(){

}

public void redo(){
   execute();
}

public boolean canExecute() {
	return true;
}

}





}
