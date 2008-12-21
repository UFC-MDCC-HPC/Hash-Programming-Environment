package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.commands.base.UnfuseReplicatorCommand;
import hPE.model.base.HReplicator;

public class UnfuseReplicatorEditPolicy extends ComponentEditPolicy {

	public UnfuseReplicatorEditPolicy() {
		super();
		
	}
	
private static final String
      UNFUSE_REPLICATOR_REQUEST = "Unfuse Replicator";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HReplicator i = (HReplicator) getHost().getModel();
	
	if (UNFUSE_REPLICATOR_REQUEST.equals(request.getType()))
		return new UnfuseReplicatorCommand(i);
	return 
	    super.getCommand(request);
	
}


}
