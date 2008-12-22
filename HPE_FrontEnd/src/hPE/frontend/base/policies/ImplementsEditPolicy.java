package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.base.commands.ImplementsCommand;
import hPE.frontend.base.commands.InheritFromCommand;
import hPE.frontend.base.model.HComponent;

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
