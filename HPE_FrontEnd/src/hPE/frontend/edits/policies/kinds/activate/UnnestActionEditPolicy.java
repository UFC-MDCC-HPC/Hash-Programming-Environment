package hPE.frontend.edits.policies.kinds.activate;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Point;

import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HCombinatorAction;
import hPE.model.protocol.kinds.activate.HProtocol;



import java.util.List;

public class UnnestActionEditPolicy extends ComponentEditPolicy {

	public UnnestActionEditPolicy() {
		super();
		
	}
	
private static final String
	UNNEST_ACTION_REQUEST = "Unnest Action";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HCombinatorAction model = (HCombinatorAction) ((AbstractEditPart) getHost()).getModel();
	
	if (UNNEST_ACTION_REQUEST.equals(request.getType()))
		return new UnnestActionCommand(model);
	return 
	    super.getCommand(request);
	
}

static class UnnestActionCommand 
extends org.eclipse.gef.commands.Command{

HCombinatorAction model;

public UnnestActionCommand(HCombinatorAction model){

  this.model = model;

}

HAction action;
Point action_location;

public void execute(){

   HCombinatorAction parent_action = model.getActionCombinator();
   HProtocol parent_protocol = model.getProtocol();
   
   action = (HAction) model.getActions().get(0);
   
   if (parent_action != null) {
	   model.removeAction(action);
	   action.setRepeat(action.getRepeatDepth()+model.getRepeatDepth());
	   action.setCombinatorAction(parent_action);
	   // parent_action.replaceAction(model,action);
	   parent_action.removeAction(model);
   } else if (parent_protocol != null) {
	   model.removeAction(action);
	   action.setRepeat(action.getRepeatDepth()+model.getRepeatDepth());
	   action.setProtocol(parent_protocol);
	   parent_protocol.setAction(action);
   } else {
	   // ERROR !!!
   }
   
   Rectangle bounds = model.getBounds().getCopy();
   bounds.setSize(action.getBounds().getSize());
   action_location = action.getBounds().getLocation().getCopy();
   action.setBounds(bounds);
   
   // parent_model.unnestAction();
   

}


public void undo(){
	
	   HCombinatorAction parent_action = model.getActionCombinator();
	   HProtocol parent_protocol = model.getProtocol();
	   
	   model.addAction(action);
	   action.setCombinatorAction(model);
	   action.setRepeat(action.getRepeatDepth()-model.getRepeatDepth());
	   
	   if (parent_action != null) {
		   int i = parent_action.getActions().indexOf(action);
		   parent_action.removeAction(action);
		   parent_action.addAction(i,model);
		   parent_action.sinalizeRefresh();
	   } else if (parent_protocol != null) {
		   parent_protocol.setAction(null);
		   parent_protocol.setAction(model);
	   } else {
		   // ERROR !!!
	   }

	   Rectangle bounds = action.getBounds().getCopy();
	   bounds.setSize(model.getBounds().getSize());
	   model.setBounds(bounds);
	   
	   action.setBounds(new Rectangle(action_location,action.getBounds().getSize()));
	   
	   
}

public void redo(){
   execute();
}
}


// DOM, 23/10, 12:55 - 19:10 ...
// RIO-SP , 27/10, 21:00 -  
// SP-FOR, 30/10, 23:50

// 1200,00 ...




}
