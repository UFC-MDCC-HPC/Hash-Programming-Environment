package hPE.frontend.edits.policies.kinds.activate;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import hPE.model.base.IHUnit;

public class SetPrivateUnitEditPolicy extends ComponentEditPolicy {

	public SetPrivateUnitEditPolicy() {
		super();
		
	}
	
private static final String
	SET_PUBLIC_UNIT_REQUEST = "Set Public Unit",  //$NON-NLS-1$
    SET_PRIVATE_UNIT_REQUEST = "Set Private Unit";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	IHUnit model = (IHUnit) ((AbstractEditPart) getHost()).getModel();
	
	if (SET_PUBLIC_UNIT_REQUEST.equals(request.getType()))
		return new SetPublicCommand(model);
	else if (SET_PRIVATE_UNIT_REQUEST.equals(request.getType()))
		return new SetPrivateCommand(model);
	return 
	    super.getCommand(request);
	
}

static class SetPrivateCommand 
extends org.eclipse.gef.commands.Command{

IHUnit model;

public SetPrivateCommand(IHUnit model){

  this.model = model;

}

public void execute(){

   model.setHidden(true);

}


public void undo(){
   model.setHidden(false);
}

public void redo(){
   execute();
}
}


static class SetPublicCommand 
extends org.eclipse.gef.commands.Command{

IHUnit model;

public SetPublicCommand(IHUnit model){

  this.model = model;

}

public void execute(){

   model.setHidden(false);

}


public void undo(){
   model.setHidden(true);
}

public void redo(){
   execute();
}

}


}
