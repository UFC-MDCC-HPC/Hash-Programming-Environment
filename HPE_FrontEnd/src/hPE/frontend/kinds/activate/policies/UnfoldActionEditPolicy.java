package hPE.frontend.kinds.activate.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;
import hPE.frontend.kinds.activate.model.protocol.HDoAction;

public class UnfoldActionEditPolicy extends ComponentEditPolicy {

	public UnfoldActionEditPolicy() {
		super();
		
	}
	
private static final String
	UNFOLD_ACTION_REQUEST = "Unfold Action",  //$NON-NLS-1$
    FOLD_ACTION_REQUEST = "Fold Action";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HAction model = (HAction) ((AbstractEditPart) getHost()).getModel();
	
	if (UNFOLD_ACTION_REQUEST.equals(request.getType()))
		return new UnfoldActionCommand((HDoAction) model);
	else if (FOLD_ACTION_REQUEST.equals(request.getType()))
		return new FoldActionCommand(model);
	return 
	    super.getCommand(request);
	
}

static class UnfoldActionCommand 
extends org.eclipse.gef.commands.Command{

HAction model;

public UnfoldActionCommand(HDoAction model){

  this.model = model;

}

public void execute(){

   HCombinatorAction ca = model.getActionCombinator();	
	
   if (ca!=null) {
      model = ca.unfoldAction((HDoAction) model);
   } else {
	   // UNEXPECTED ERROR !!
   }
   

}


public void undo(){
   HCombinatorAction ca = model.getActionCombinator();	
   model = ca.foldAction(model);
}

public void redo(){
   execute();
}
}


static class FoldActionCommand 
extends org.eclipse.gef.commands.Command{

HAction model;

public FoldActionCommand(HAction model){

  this.model = model;

}

public void execute(){

   HCombinatorAction ca = model.getActionCombinator();	
   model = ca.foldAction(model);

}


public void undo(){
	   HCombinatorAction ca = model.getActionCombinator();	
	   model = ca.unfoldAction((HDoAction) model);
}

public void redo(){
   execute();
}

}


}
