package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


import hPE.frontend.base.commands.SetReplicatorFactorCommand;
import hPE.frontend.base.commands.SplitReplicatorCommand;
import hPE.frontend.base.edits.LinkToReplicatorEditPart;
import hPE.frontend.base.edits.ReplicatorEditPart;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;

public class SetReplicatorFactorEditPolicy extends ComponentEditPolicy {

	public SetReplicatorFactorEditPolicy() {
		super();
		
	}
	
private static final String
      SET_REPLICATOR_FACTOR_REQUEST = "Make Unitary";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HReplicator r = (HReplicator) ((ReplicatorEditPart) getHost()).getModel();
	
	if (SET_REPLICATOR_FACTOR_REQUEST.equals(request.getType()))
		return new SetReplicatorFactorCommand(r);
	return 
	    super.getCommand(request);
	
}


}
