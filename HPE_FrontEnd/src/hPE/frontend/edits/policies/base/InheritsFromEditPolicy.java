package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.commands.base.InheritFromCommand;
import hPE.model.base.HComponent;

public class InheritsFromEditPolicy extends ComponentEditPolicy {

	public InheritsFromEditPolicy() {
		super();
		
	}
	
private static final String
      INHERIT_FROM_REQUEST = "Inherit From";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HComponent c = (HComponent) getHost().getModel();
	
	if (INHERIT_FROM_REQUEST.equals(request.getType()))
		return new InheritFromCommand(c);
	return 
	    super.getCommand(request);
	
}


}
