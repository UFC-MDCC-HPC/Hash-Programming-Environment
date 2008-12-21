package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.commands.base.InheritFromCommand;
import hPE.frontend.commands.base.LiftReplicatorCommand;
import hPE.model.base.HComponent;
import hPE.model.base.HLinkToReplicator;

public class LiftReplicatorEditPolicy extends ComponentEditPolicy {

	public LiftReplicatorEditPolicy() {
		super();
		
	}
	
private static final String
      LIFT_REPLICATOR_REQUEST = "Lift Replicator";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HLinkToReplicator c = (HLinkToReplicator) getHost().getModel();
	
	if (LIFT_REPLICATOR_REQUEST.equals(request.getType()))
		return new LiftReplicatorCommand(c);
	return 
	    super.getCommand(request);
	
}


}
