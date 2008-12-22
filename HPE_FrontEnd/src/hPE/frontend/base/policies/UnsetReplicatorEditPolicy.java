package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.base.commands.UnSetReplicatorCommand;
import hPE.frontend.base.edits.LinkToReplicatorEditPart;
import hPE.frontend.base.model.HLinkToReplicator;

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
