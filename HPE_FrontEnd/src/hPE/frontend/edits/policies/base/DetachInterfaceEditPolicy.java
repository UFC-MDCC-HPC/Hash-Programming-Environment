package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.commands.base.DetachInterfaceCommand;
import hPE.frontend.edits.base.UnitEditPart;
import hPE.model.base.IHUnit;

public class DetachInterfaceEditPolicy extends ComponentEditPolicy {

	public DetachInterfaceEditPolicy() {
		super();		
	}
	
private static final String
	DETACH_INTERFACE_REQUEST = "Detach Interface";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	IHUnit the_unit = (IHUnit) ((UnitEditPart) getHost()).getModel();
	
	if (DETACH_INTERFACE_REQUEST.equals(request.getType()))
		return new DetachInterfaceCommand(the_unit);
	return 
	    super.getCommand(request);
	
}


}
