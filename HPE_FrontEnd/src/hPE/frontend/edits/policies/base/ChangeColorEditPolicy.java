package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.commands.base.ChangeColorCommand;
import hPE.model.base.IHasColor;

public class ChangeColorEditPolicy extends ComponentEditPolicy {

	public ChangeColorEditPolicy() {
		super();
		
	}
	
private static final String
      CHANGE_COLOR_REQUEST = "Change Color";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	IHasColor i = (IHasColor) getHost().getModel();
	
	if (CHANGE_COLOR_REQUEST.equals(request.getType()))
		return new ChangeColorCommand(i);
	return 
	    super.getCommand(request);
	
}


}
