package hPE.frontend.base.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import hPE.frontend.base.model.IHasInterface;

public class ShowInterfaceEditPolicy extends ComponentEditPolicy {

	public ShowInterfaceEditPolicy() {
		super();
		
	}
	
private static final String
	SHOW_INTERFACE_REQUEST = "Show Interface",  //$NON-NLS-1$
    HIDE_INTERFACE_REQUEST = "Hide Interface";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	IHasInterface model = (IHasInterface) ((AbstractEditPart) getHost()).getModel();
	
	if (SHOW_INTERFACE_REQUEST.equals(request.getType()))
		return new ShowInterfaceCommand(model);
	else if (HIDE_INTERFACE_REQUEST.equals(request.getType()))
		return new HideInterfaceCommand(model);
	return 
	    super.getCommand(request);
	
}

static class ShowInterfaceCommand 
extends org.eclipse.gef.commands.Command{

IHasInterface model;

public ShowInterfaceCommand(IHasInterface model){

  this.model = model;

}

public void execute(){

   model.showInterface();

}


public void undo(){
   model.hideInterface();
}

public void redo(){
   execute();
}
}


static class HideInterfaceCommand 
extends org.eclipse.gef.commands.Command{

IHasInterface model;

public HideInterfaceCommand(IHasInterface model){

  this.model = model;

}

public void execute(){

   model.hideInterface();

}


public void undo(){
   model.showInterface();
}

public void redo(){
   execute();
}

}


}
