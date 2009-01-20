package hPE.frontend.base.policies;

import hPE.HPEVersionEditor;
import hPE.frontend.base.dialogs.NewVersionShell;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.model.HComponent;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


public class NewVersionEditPolicy extends ComponentEditPolicy {

public NewVersionEditPolicy() {
	super();
}
	
private static final String
	NEW_VERSION_REQUEST = "Manage Version";  //$NON-NLS-1$

public Command getCommand(Request request) {
		
	if (NEW_VERSION_REQUEST.equals(request.getType()))
		return new NewVersionCommand((ConfigurationEditPart)this.getHost());
	return 
	    super.getCommand(request);
	
	
	
}

static class NewVersionCommand 
extends org.eclipse.gef.commands.Command{

private ConfigurationEditPart part;

private HComponent c = null;
private HPEVersionEditor editor = null;


public NewVersionCommand(ConfigurationEditPart part){

  this.part = part;
  c = (HComponent) part.getModel();

      
}

public void execute(){

	NewVersionShell shell = new NewVersionShell(c);
	

	
			
	
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
