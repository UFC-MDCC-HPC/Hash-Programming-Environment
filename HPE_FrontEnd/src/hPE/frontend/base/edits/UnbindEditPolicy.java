package hPE.frontend.base.edits;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.base.commands.UnbindCommand;
import hPE.frontend.base.model.HBinding;

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
