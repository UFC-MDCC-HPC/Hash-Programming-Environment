package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.commands.base.InheritFromCommand;
import hPE.frontend.commands.base.LiftUnitCommand;
import hPE.model.base.HComponent;
import hPE.model.base.HUnit;
import hPE.model.base.IHUnit;

public class LiftUnitEditPolicy extends ComponentEditPolicy {

	public LiftUnitEditPolicy() {
		super();
		
	}
	
private static final String
      LIFT_UNIT_REQUEST = "Lift Unit";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	IHUnit u = (IHUnit) getHost().getModel();
	
	if (LIFT_UNIT_REQUEST.equals(request.getType()))
		return new LiftUnitCommand(u);
	return 
	    super.getCommand(request);
	
}


}
