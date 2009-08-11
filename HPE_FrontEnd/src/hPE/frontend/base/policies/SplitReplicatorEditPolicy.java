package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.base.commands.SplitReplicatorCommand;
import hPE.frontend.base.edits.LinkToReplicatorEditPart;
import hPE.frontend.base.edits.ReplicatorEditPart;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;

public class SplitReplicatorEditPolicy extends ComponentEditPolicy {

	public SplitReplicatorEditPolicy() {
		super();
		
	}
	
private static final String
      SPLIT_REPLICATOR_REQUEST = "Split Enumeration";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HReplicator replicator = (HReplicator) ((ReplicatorEditPart) getHost()).getModel();
	
	if (SPLIT_REPLICATOR_REQUEST.equals(request.getType()))
		return new SplitReplicatorCommand(replicator);
	return 
	    super.getCommand(request);
	
}


}
