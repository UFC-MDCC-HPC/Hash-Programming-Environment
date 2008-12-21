package hPE.frontend.edits.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.commands.base.UnbindCommand;
import hPE.model.base.HBinding;

public class UnbindEditPolicy extends ComponentEditPolicy {

	public UnbindEditPolicy() {
		super();
		
	}
	
private static final String
      UNBIND_REQUEST = "Unbind";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HBinding binding = (HBinding) ((BindingEditPart) getHost()).getModel();
	
	if (UNBIND_REQUEST.equals(request.getType()))
		return new UnbindCommand(binding);
	return 
	    super.getCommand(request);
	
}


}
