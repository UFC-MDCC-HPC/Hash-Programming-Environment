package hPE.frontend.kinds.activate.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import hPE.frontend.kinds.activate.commands.InterleaveActionsCommand;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;

import java.util.List;


public class InterleaveActionsEditPolicy extends ComponentEditPolicy {


	public InterleaveActionsEditPolicy() {
		super();
		
	}
	
private static final String
	INTERLEAVE_ACTIONS_REQUEST = "Interleave Actions";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HAction model = (HAction) ((AbstractEditPart) getHost()).getModel();
	
	if (INTERLEAVE_ACTIONS_REQUEST.equals(request.getType()))
		return new InterleaveActionsCommand(model);
	return 
	    super.getCommand(request);
	
}




}
