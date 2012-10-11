package hPE.frontend.kinds.activate.policies;

import java.util.List;

import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;
import hPE.frontend.kinds.activate.model.protocol.IProtocolCombinator;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;



public class RemoveActionProtocolEditPolicy extends ComponentEditPolicy {

	public RemoveActionProtocolEditPolicy() 
	{
		super();		
	}
	
public static final String
      REMOVE_ACTION_REQUEST = "Remove Action";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	Object o = getHost().getModel();
	
	IProtocol protocol =  (o instanceof IProtocol) ? (IProtocol) getHost().getModel() : null;		
	
	if (REMOVE_ACTION_REQUEST.equals(request.getType()) && protocol != null)
		return new RemoveActionCommand(protocol);
	else 
		return super.getCommand(request);
	
}


static class RemoveActionCommand extends Command {

	private IProtocol protocol = null;

	
	public RemoveActionCommand(IProtocol protocol) 
	{
		super();
		
		this.protocol = protocol;		
	}

	
	public void execute() 
	{
		IProtocolCombinator parent_combinator = protocol.getParentCombinator();
		ProtocolChoiceType removed_protocol_choice = null;
		if (parent_combinator != null)
		{
			for (ProtocolChoiceType protocol_choice : parent_combinator.getAction())
			{
				if (protocol_choice.getAlt() == protocol) 
				{
					protocol_choice.setAlt(null);	
					removed_protocol_choice = protocol_choice;
				} 
				else if (protocol_choice.getPar() == protocol) 
				{
					protocol_choice.setPar(null);	
					removed_protocol_choice = protocol_choice;
				} 
				else if (protocol_choice.getSeq() == protocol) 
				{
					protocol_choice.setSeq(null);
					removed_protocol_choice = protocol_choice;
				} 
				else if (protocol_choice.getPerform() == protocol) 
				{
					protocol_choice.setPerform(null);
					removed_protocol_choice = protocol_choice;
				} 
			}

			if (removed_protocol_choice != null)
			{
			    parent_combinator.getAction().remove(removed_protocol_choice);	
			}

			parent_combinator.updateChildren();
			for (IProtocol protocol: parent_combinator.getActions())
			{
				protocol.updateConnections();
			}
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
	
}



}
