package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.base.commands.FuseReplicatorCommand;
import hPE.frontend.base.commands.SetPermutationCommand;
import hPE.frontend.base.model.HReplicator;

public class SetPermutationEditPolicy extends ComponentEditPolicy {

	public SetPermutationEditPolicy() {
		super();
		
	}
	
private static final String
      SET_PERMUTATION_REQUEST = "Set Permutation";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	if (SET_PERMUTATION_REQUEST.equals(request.getType()))
		return new SetPermutationCommand();
	return 
	    super.getCommand(request);
	
}


}
