package hPE.frontend.edits.policies.kinds.activate;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HAltAction;
import hPE.model.protocol.kinds.activate.HCombinatorAction;
import hPE.model.protocol.kinds.activate.HParAction;
import hPE.model.protocol.kinds.activate.HSeqAction;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class RepeatFusionEditPolicy extends ComponentEditPolicy {

	public RepeatFusionEditPolicy() {
		super();
		
	}
	
private static final String
	REPEAT_FUSION_REQUEST = "Repeat Fusion";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HAction model = (HAction) ((AbstractEditPart) getHost()).getModel();
	
	if (REPEAT_FUSION_REQUEST.equals(request.getType()))
		return new RepeatFusionCommand(model);
	return 
	    super.getCommand(request);
	
}

public static class RepeatFusionCommand 
extends org.eclipse.gef.commands.Command{

HAction action;
HParAction par_action_outer = null;
HParAction par_action_inner = null;

public RepeatFusionCommand(HAction model){

    this.action = model;
	
}

public void setWorkingActions(HParAction par_action_outer, HParAction par_action_inner) {
	this.par_action_inner = par_action_inner;
	this.par_action_outer = par_action_outer;
}

HAction undo_action = null;
HAction redo_action = null;

public void setUndoAction(HAction undo_action) {
	this.undo_action = undo_action;
}

public void execute(){

       par_action_outer.removeAction(action);
       // par_action_inner.addAction(action);
       action.setRepeat(action.getRepeatDepth()-1);
       action.setCombinatorAction(par_action_inner);
	
	   par_action_outer.organizeAction();
	
	
       redo_action = par_action_outer.getTopActionCopy();

}

	

public void undo(){

	   undo_action.getProtocol().setAction(undo_action);
	
}

public void redo(){
	
   	   redo_action.getProtocol().setAction(redo_action);
	
}

}




}
