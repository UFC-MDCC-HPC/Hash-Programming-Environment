package hPE.frontend.base.policies;

import hPE.frontend.base.dialogs.AddReferencesDialog;
import hPE.frontend.base.model.HHasExternalReferences;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


public class AddReferencesEditPolicy extends ComponentEditPolicy {

public AddReferencesEditPolicy() {
	super();
}
	
public static final String
	ADD_REFERENCES = "Add References";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	if (ADD_REFERENCES.equals(request.getType()))
		return new AddReferencesCommand((HHasExternalReferences)this.getHost().getModel());
	return 
	    super.getCommand(request);
		
}

static class AddReferencesCommand 
extends org.eclipse.gef.commands.Command{

private HHasExternalReferences i = null;


public AddReferencesCommand(HHasExternalReferences i){

  this.i = i;

      
}

public void execute(){

  AddReferencesDialog dialog = new AddReferencesDialog(null, i);
  dialog.setAlwaysOnTop(true);
  dialog.setModal(true);
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
