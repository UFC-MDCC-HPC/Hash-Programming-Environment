package hPE.frontend.kinds.activate.policies;

import hPE.frontend.kinds.activate.model.protocol.IProtocol;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;



public class ToggleLoopProtocolEditPolicy extends ComponentEditPolicy {

	public ToggleLoopProtocolEditPolicy() 
	{
		super();		
	}
	
public static final String
      TOGGLE_LOOP_REQUEST = "Toggle Loop";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	Object o = getHost().getModel();
	
	IProtocol protocol =  (o instanceof IProtocol) ? (IProtocol) getHost().getModel() : null;	
	
	
	if (TOGGLE_LOOP_REQUEST.equals(request.getType()) && protocol != null)
		return new ToggleLoopProtocolCommand(protocol);
	else 
		return super.getCommand(request);
	
}


static class ToggleLoopProtocolCommand extends Command {

	private IProtocol protocol = null;

	
	public ToggleLoopProtocolCommand(IProtocol protocol) 
	{
		super();
		
		this.protocol = protocol;
		
	}

	
	public void execute() 
	{
		protocol.setRepeat(!protocol.isRepeat());
		protocol.updateConnections();
	}
	
	public void undo () 
	{
      execute();
	}
	
	public void redo () 
	{
	    execute();	
	}
	
}



}
