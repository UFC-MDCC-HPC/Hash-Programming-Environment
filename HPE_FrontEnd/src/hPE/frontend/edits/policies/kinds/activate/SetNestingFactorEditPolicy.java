package hPE.frontend.edits.policies.kinds.activate;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import hPE.model.base.HUnitSlice;

public class SetNestingFactorEditPolicy extends ComponentEditPolicy {

	public SetNestingFactorEditPolicy() {
		super();
		
	}
	
private static final String
	INCREMENT_NF_REQUEST = "Increment Nesting Factor",  //$NON-NLS-1$
    DECREMENT_NF_REQUEST = "Decrement Nesting Factor";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HUnitSlice model = (HUnitSlice) ((AbstractEditPart) getHost()).getModel();
	
	if (INCREMENT_NF_REQUEST.equals(request.getType()))
		return new IncrementNFCommand(model,+1);
	else if (DECREMENT_NF_REQUEST.equals(request.getType()))
		return new IncrementNFCommand(model,-1);
	return 
	    super.getCommand(request);
	
}

static class IncrementNFCommand 
extends org.eclipse.gef.commands.Command{

HUnitSlice model;
int inc;

public IncrementNFCommand(HUnitSlice model, int inc){

  this.model = model;
  this.inc = inc;

}

public void execute(){

   model.setNestingFactor(model.getNestingFactor()+inc);

}


public void undo(){
	   model.setNestingFactor(model.getNestingFactor()-inc);
}

public void redo(){
   execute();
}
}




}
