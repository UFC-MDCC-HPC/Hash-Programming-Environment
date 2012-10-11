package hPE.frontend.kinds.activate.policies;

import hPE.frontend.kinds.activate.model.protocol.IProtocol;
import hPE.frontend.kinds.activate.model.protocol.IProtocolCombinator;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;



public class ChangeOrderSEQProtocolEditPolicy extends ComponentEditPolicy {

	public ChangeOrderSEQProtocolEditPolicy() 
	{
		super();		
	}
	
public static final String
      CHANGE_ORDER_REQUEST = "Change Order";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	Object o = getHost().getModel();
	
	IProtocol protocol =  (o instanceof IProtocol) ? (IProtocol) getHost().getModel() : null;	
	
	
	if (CHANGE_ORDER_REQUEST.equals(request.getType()) && protocol != null)
		return new ChangeOrderSEQCommand(protocol);
	else 
		return super.getCommand(request);
	
}


public static class ChangeOrderSEQCommand extends Command {

	private IProtocol protocol = null;

	
	public ChangeOrderSEQCommand(IProtocol protocol) 
	{
		super();
		
		this.protocol = protocol;
		
	}

	
	public void execute() 
	{
        int order0 = protocol.getOrder();
        int order1 = other_protocol.getOrder();
        
        protocol.setOrder(order1);
        other_protocol.setOrder(order0);
        
        IProtocolCombinator parent_combinator = protocol.getParentCombinator();
        
		parent_combinator.updateChildren();
		for (IProtocol protocol: parent_combinator.getActions())
		{
			protocol.updateConnections();
			parent_combinator.updateEntryExitConnections();
		}
        
        
	}
	
	public void undo () 
	{
      execute();
	}
	
	public void redo () 
	{
	    execute();	
	}
	
	public boolean canExecute()
	{
		return protocol != null && other_protocol != null && protocol.getParentCombinator() == other_protocol.getParentCombinator();
	}

	private IProtocol other_protocol = null;

	public void setOther(Object model) {
		other_protocol = (IProtocol) model;
		
	}
	
}



}
