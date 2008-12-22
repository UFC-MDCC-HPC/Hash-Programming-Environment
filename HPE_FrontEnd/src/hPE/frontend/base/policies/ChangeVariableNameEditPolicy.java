package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.base.commands.ChangeVariableNameCommand;
import hPE.frontend.base.model.HComponent;

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
