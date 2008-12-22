package hPE.frontend.kinds.activate.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HAltAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;
import hPE.frontend.kinds.activate.model.protocol.HParAction;
import hPE.frontend.kinds.activate.model.protocol.HSeqAction;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class AltAbsorptionEditPolicy extends ComponentEditPolicy {

	public AltAbsorptionEditPolicy() {
		super();
		
	}
	
private static final String
	ALT_ABOSORPTION_REQUEST = "Alt Absorption";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HAction model = (HAction) ((AbstractEditPart) getHost()).getModel();
	
	if (ALT_ABOSORPTION_REQUEST.equals(request.getType()))
		return new AltAbsorptionCommand(model);
	return 
	    super.getCommand(request);
	
}

public static class AltAbsorptionCommand 
extends org.eclipse.gef.commands.Command{

HAction action = null;
HAltAction alt_action = null;

public AltAbsorptionCommand(HAction model){

    this.action = model;
	
}

public void setAbsorbingAction(HAltAction alt_action) {
	this.alt_action = alt_action;
}

HAction undo_action = null;
HAction redo_action = null;

public void execute(){

	if (action != alt_action) {
       undo_action = alt_action.getTopActionCopy();
	
       HCombinatorAction parent_action = alt_action.getActionCombinator();
       parent_action.removeAction(action);
       
       Iterator as = ((ArrayList)((ArrayList)alt_action.getActions()).clone()).iterator();
       while (as.hasNext()) {
    	   HAction branch_action = (HAction) as.next();
    	   alt_action.removeAction(branch_action);
    	   HCombinatorAction inner_branch_action = getCombinatorAction(parent_action);
    	   inner_branch_action.addAction(action.getCopy(inner_branch_action));
    	   inner_branch_action.addAction(branch_action);
    	   branch_action.setCombinatorAction(inner_branch_action);
       }
       parent_action.organizeAction();
       redo_action = alt_action.getTopActionCopy();
	} else {
       // The absorbing action do nothing.		
	}

}

private HCombinatorAction getCombinatorAction(HCombinatorAction action) {
	if (action instanceof HSeqAction) return new HSeqAction(null,alt_action);
	if (action instanceof HParAction) return new HParAction(null,alt_action);
	if (action instanceof HAltAction) return new HAltAction(null,alt_action);	
	return null;
}
	

public void undo(){

	if (action != alt_action) {
	   undo_action.getProtocol().setAction(undo_action);
	}
	
}

public void redo(){
	
	if (action != alt_action) {
   	   redo_action.getProtocol().setAction(redo_action);
	}
	
}

}




}
