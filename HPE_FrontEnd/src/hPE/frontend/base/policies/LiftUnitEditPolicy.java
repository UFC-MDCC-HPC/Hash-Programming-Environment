package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.base.commands.InheritFromCommand;
import hPE.frontend.base.commands.LiftUnitCommand;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.IHUnit;

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
