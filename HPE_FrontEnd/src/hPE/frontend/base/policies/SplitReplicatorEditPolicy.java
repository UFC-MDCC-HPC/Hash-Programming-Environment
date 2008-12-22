package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.base.commands.SplitReplicatorCommand;
import hPE.frontend.base.edits.LinkToReplicatorEditPart;
import hPE.frontend.base.model.HLinkToReplicator;

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
