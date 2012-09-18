package hPE.frontend.kinds.activate.policies;

import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;



public class EditProtocolEditPolicy extends ComponentEditPolicy {

	public EditProtocolEditPolicy() {
		super();
		
	}
	
private static final String
      SHOW_PROTOCOL_REQUEST = "Show Protocol",  //$NON-NLS-1$
      HIDE_PROTOCOL_REQUEST = "Hide Protocol";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	Object o = getHost().getModel();
	
	HActivateInterface i;
	
	if (o instanceof HActivateInterface) 	
	   i = (HActivateInterface) getHost().getModel();
	else 
       i = (HActivateInterface) ((IProtocol) getHost().getModel()).getInterface();
	
	
	if (SHOW_PROTOCOL_REQUEST.equals(request.getType()))
		return new ShowProtocolCommand(i);
	else if (HIDE_PROTOCOL_REQUEST.equals(request.getType()))
		return new HideProtocolCommand(i);
	return 
	    super.getCommand(request);
	
}


static class ShowProtocolCommand extends Command {

	HActivateInterface the_interface;
	
	public ShowProtocolCommand(HActivateInterface the_interface) {
		super();
		this.the_interface = the_interface;
	}

	
	public void execute() {

		
		the_interface.showProtocol();
	}
	
	public void undo () {
        the_interface.hideProtocol();
	}
	
	public void redo () {
	    execute();	
	}
	
}

static class HideProtocolCommand extends Command {

	HActivateInterface the_interface;
	
	public HideProtocolCommand(HActivateInterface the_interface) {
		super();
		this.the_interface = the_interface;
	}

	public void execute() {
		
		the_interface.hideProtocol();
		
		
	}
	
	public void undo () {
        the_interface.showProtocol();
	}
	
	public void redo () {
	    execute();	
	}

}


}
