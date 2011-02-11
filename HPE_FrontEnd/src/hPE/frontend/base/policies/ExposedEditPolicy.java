package hPE.frontend.base.policies;

import hPE.frontend.base.actions.ExposedAction;
import hPE.frontend.base.commands.ExposedCommand;
import hPE.frontend.base.model.HComponent;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

public class ExposedEditPolicy extends ComponentEditPolicy {

	public ExposedEditPolicy() {
		super();
		
	}
	
private static final String
      EXPOSED_REQUEST = ExposedAction.EXPOSED;  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HComponent c = (HComponent) getHost().getModel();
	
	if (EXPOSED_REQUEST.equals(request.getType()))
		return new ExposedCommand(c);
	return 
	    super.getCommand(request);
	
}


}
