package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.base.commands.ChangeColorCommand;
import hPE.frontend.base.model.IHasColor;

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
