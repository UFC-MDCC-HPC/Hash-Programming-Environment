package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.base.commands.JoinReplicatorCommand;
import hPE.frontend.base.edits.LinkToReplicatorEditPart;
import hPE.frontend.base.model.HLinkToReplicator;

public class JoinReplicatorEditPolicy extends ComponentEditPolicy {

	public JoinReplicatorEditPolicy() {
		super();
		
	}
	
private static final String
      JOIN_REPLICATOR_REQUEST = "Join replicator";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HLinkToReplicator link = (HLinkToReplicator) ((LinkToReplicatorEditPart) getHost()).getModel();
	
	if (JOIN_REPLICATOR_REQUEST.equals(request.getType()))
		return new JoinReplicatorCommand(link);
	return 
	    super.getCommand(request);
	
}


}
