package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.commands.base.FuseReplicatorCommand;
import hPE.model.base.HReplicator;

public class FuseReplicatorEditPolicy extends ComponentEditPolicy {

	public FuseReplicatorEditPolicy() {
		super();
		
	}
	
private static final String
      FUSE_REPLICATOR_REQUEST = "Fuse Replicator";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HReplicator i = (HReplicator) getHost().getModel();
	
	if (FUSE_REPLICATOR_REQUEST.equals(request.getType()))
		return new FuseReplicatorCommand(i);
	return 
	    super.getCommand(request);
	
}


}
