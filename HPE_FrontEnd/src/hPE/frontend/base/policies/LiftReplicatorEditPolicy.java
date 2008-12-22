package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.base.commands.InheritFromCommand;
import hPE.frontend.base.commands.LiftReplicatorCommand;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HLinkToReplicator;

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
