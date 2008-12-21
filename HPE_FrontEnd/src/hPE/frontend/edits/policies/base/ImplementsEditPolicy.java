package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.commands.base.ImplementsCommand;
import hPE.frontend.commands.base.InheritFromCommand;
import hPE.model.base.HComponent;

public class ImplementsEditPolicy extends ComponentEditPolicy {

	public ImplementsEditPolicy() {
		super();
		
	}
	
private static final String
      IMPLEMENTS_REQUEST = "Implements";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HComponent c = (HComponent) getHost().getModel();
	
	if (IMPLEMENTS_REQUEST.equals(request.getType()))
		return new ImplementsCommand(c);
	return 
	    super.getCommand(request);
	
}


}
