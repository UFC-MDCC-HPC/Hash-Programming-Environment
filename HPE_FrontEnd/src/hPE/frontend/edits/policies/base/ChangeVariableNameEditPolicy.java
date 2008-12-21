package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.commands.base.ChangeVariableNameCommand;
import hPE.model.base.HComponent;

public class ChangeVariableNameEditPolicy extends ComponentEditPolicy {

	
	
	public ChangeVariableNameEditPolicy() {
		super();
		
	}
	
private static final String
      CHANGE_VARIABLE_NAME_REQUEST = "Change Variable Name";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	
	HComponent c = (HComponent) getHost().getModel();
	
	if (CHANGE_VARIABLE_NAME_REQUEST.equals(request.getType()))
		return new ChangeVariableNameCommand(c);
	return 
	    super.getCommand(request);
	
}


}
