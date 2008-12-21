package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.commands.base.SplitReplicatorCommand;
import hPE.frontend.edits.base.LinkToReplicatorEditPart;
import hPE.model.base.HLinkToReplicator;

public class SplitReplicatorEditPolicy extends ComponentEditPolicy {

	public SplitReplicatorEditPolicy() {
		super();
		
	}
	
private static final String
      SPLIT_REPLICATOR_REQUEST = "Split replicator";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HLinkToReplicator link = (HLinkToReplicator) ((LinkToReplicatorEditPart) getHost()).getModel();
	
	if (SPLIT_REPLICATOR_REQUEST.equals(request.getType()))
		return new SplitReplicatorCommand(link);
	return 
	    super.getCommand(request);
	
}


}
