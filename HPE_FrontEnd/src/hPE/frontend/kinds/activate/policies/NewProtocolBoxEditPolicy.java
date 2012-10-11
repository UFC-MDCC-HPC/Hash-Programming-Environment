package hPE.frontend.kinds.activate.policies;

import hPE.frontend.base.exceptions.HPEInvalidNameException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.activate.model.protocol.HProtocolPerform;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;
import hPE.frontend.kinds.activate.model.protocol.IProtocolCombinator;
import hPE.frontend.kinds.activate.model.protocol.IProtocolPerform;
import hPE.frontend.connector.xml.component.ComponentFactory;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;



public class NewProtocolBoxEditPolicy extends ComponentEditPolicy {

	public NewProtocolBoxEditPolicy() 
	{
		super();		
	}
	
private static final String
      NEW_PROTOCOL_REQUEST = "New Protocol";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	Object o = getHost().getModel();
	
	
	
	if (NEW_PROTOCOL_REQUEST.equals(request.getType()))
		return new NewProtocolCommand(o);
	else 
		return super.getCommand(request);
	
}


static class NewProtocolCommand extends Command {

	private HProtocolChoice protocol_choice_parent = null;
	private IProtocolCombinator protocol_combinator = null;

	
	public NewProtocolCommand(Object o) 
	{
		super();
		
		
		protocol_choice_parent = o instanceof HProtocolChoice ?  (HProtocolChoice) o :  (protocol_combinator = (IProtocolCombinator) o).getProtocolChoice();
		
	}

	
	public void execute() 
	{
        IProtocolPerform default_protocol = new HProtocolPerform();
        //default_protocol.setId("?");
        default_protocol.setRepeat(false);
        //default_protocol.setSliceId("?");        
		protocol_choice_parent.setPerform(default_protocol);
		default_protocol.setProtocolChoice(protocol_choice_parent);
		
		if (protocol_combinator != null)
		{
			default_protocol.setParentCombinator(protocol_combinator);
			HProtocolChoice protocol_choice = new HProtocolChoice();
			protocol_choice.setPerform(default_protocol);
			int max_order = protocol_combinator.getActions().size();
			protocol_combinator.getAction().add(protocol_choice);
			default_protocol.setOrder(max_order);
			default_protocol.setProtocolChoice(protocol_choice);
			Rectangle bounds = new Rectangle();
			int i = protocol_combinator.getActions().size();
			bounds.setLocation(protocol_combinator.getBounds().getLocation().getCopy().getTranslated(i*10,i*10));
			bounds.setSize(100, 50);
			default_protocol.setBounds(bounds);
			protocol_combinator.updateChildren();
			for (IProtocol p : protocol_combinator.getActions())
				p.updateConnections();
			protocol_combinator.updateEntryExitConnections();
			
		}
		else 
		{
			default_protocol.setBounds(new Rectangle(100,100,300,300));
			if (protocol_choice_parent.getActionName() != null)
				try {
					default_protocol.setName(protocol_choice_parent.getActionName());
				} catch (HPEInvalidNameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			HInterface i = ((HProtocolChoice)protocol_choice_parent).getInterface();
			HComponent c = (HComponent)i.getConfiguration();
		    c.refresh();
		}
	}
	
	public void undo () {
      
	}
	
	public void redo () {
	    execute();	
	}
	
}



}
