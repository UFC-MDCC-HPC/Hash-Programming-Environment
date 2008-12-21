package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.commands.base.SetReplicatorFactorCommand;
import hPE.frontend.commands.base.SplitReplicatorCommand;
import hPE.frontend.edits.base.LinkToReplicatorEditPart;
import hPE.frontend.edits.base.ReplicatorEditPart;
import hPE.model.base.HLinkToReplicator;
import hPE.model.base.HReplicator;

public class SetReplicatorFactorEditPolicy extends ComponentEditPolicy {

	public SetReplicatorFactorEditPolicy() {
		super();
		
	}
	
private static final String
      SET_REPLICATOR_FACTOR_REQUEST = "Set Replicator Factor";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HReplicator r = (HReplicator) ((ReplicatorEditPart) getHost()).getModel();
	
	if (SET_REPLICATOR_FACTOR_REQUEST.equals(request.getType()))
		return new SetReplicatorFactorCommand(r);
	return 
	    super.getCommand(request);
	
}


}
