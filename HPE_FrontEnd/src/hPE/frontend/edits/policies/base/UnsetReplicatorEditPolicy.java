package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.commands.base.UnSetReplicatorCommand;
import hPE.frontend.edits.base.LinkToReplicatorEditPart;
import hPE.model.base.HLinkToReplicator;

public class UnsetReplicatorEditPolicy extends ComponentEditPolicy {

	public UnsetReplicatorEditPolicy() {
		super();
		
	}
	
private static final String
      UNSET_REPLICATOR_REQUEST = "Unset replicator";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HLinkToReplicator link = (HLinkToReplicator) ((LinkToReplicatorEditPart) getHost()).getModel();
	
	if (UNSET_REPLICATOR_REQUEST.equals(request.getType()))
		return new UnSetReplicatorCommand(link);
	return 
	    super.getCommand(request);
	
}


}
