package hPE.frontend.edits.policies.kinds.activate;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import hPE.model.protocol.kinds.activate.HCombinatorAction;

import java.util.List;

public class LiftActionEditPolicy extends ComponentEditPolicy {

	public LiftActionEditPolicy() {
		super();
		
	}
	
private static final String
	LIFT_ACTION_REQUEST = "Lift Action";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HCombinatorAction model = (HCombinatorAction) ((AbstractEditPart) getHost()).getModel();
	
	if (LIFT_ACTION_REQUEST.equals(request.getType()))
		return new LiftActionCommand(model);
	return 
	    super.getCommand(request);
	
}

static class LiftActionCommand 
extends org.eclipse.gef.commands.Command{

HCombinatorAction model;

public LiftActionCommand(HCombinatorAction model){

  this.model = model;

}

List unlift_info;

public void execute(){

   HCombinatorAction parent_model = model.getActionCombinator();
   
   unlift_info = parent_model.liftAction(model);

}


public void undo(){
	
   HCombinatorAction parent_model = model.getActionCombinator();
	   
   parent_model.unliftAction(unlift_info);
	   
}

public void redo(){
   execute();
}
}




}
