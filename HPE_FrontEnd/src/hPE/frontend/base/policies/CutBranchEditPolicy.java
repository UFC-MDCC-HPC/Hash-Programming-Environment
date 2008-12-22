package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HAltAction;

import java.util.List;

public class CutBranchEditPolicy extends ComponentEditPolicy {

	public CutBranchEditPolicy() {
		super();
		
	}
	
private static final String
	CUT_BRANCH_REQUEST = "Cut Branch";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HAction model = (HAction) ((AbstractEditPart) getHost()).getModel();
	
	if (CUT_BRANCH_REQUEST.equals(request.getType()))
		return new CutBranchCommand(model);
	return 
	    super.getCommand(request);
	
}

static class CutBranchCommand 
extends org.eclipse.gef.commands.Command{

HAction branch_action;

public CutBranchCommand(HAction model){

  this.branch_action = model;

}

HAction undo_action = null;
HAction redo_action = null;

public void execute(){

   undo_action = branch_action.getTopActionCopy();
	
   HAltAction alt_model = (HAltAction) branch_action.getActionCombinator();
   alt_model.removeAction(branch_action);
   
   redo_action = branch_action.getTopActionCopy();

}


public void undo(){

	undo_action.getProtocol().setAction(undo_action);
	
}

public void redo(){
	
	redo_action.getProtocol().setAction(redo_action);
	
}

}




}
