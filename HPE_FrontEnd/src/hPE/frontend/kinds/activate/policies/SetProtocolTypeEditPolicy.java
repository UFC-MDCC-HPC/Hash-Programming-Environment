package hPE.frontend.kinds.activate.policies;

import hPE.frontend.base.exceptions.HPEInvalidNameException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.connector.xml.component.ProtocolCombinatorType;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.activate.model.protocol.HProtocolCombinator;
import hPE.frontend.kinds.activate.model.protocol.HProtocolPerform;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;
import hPE.frontend.kinds.activate.model.protocol.IProtocolCombinator;
import hPE.frontend.kinds.activate.model.protocol.IProtocolPerform;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;



public class SetProtocolTypeEditPolicy extends ComponentEditPolicy {

	private int protocol_type = -1;
	
	public SetProtocolTypeEditPolicy(int protocol_type) 
	{
		super();		
		
		this.protocol_type = protocol_type;
	}
	
	private static final String
	SET_PROTOCOL_TYPE_PAR_REQUEST = "Set Protocol Type (PAR)",  //$NON-NLS-1$
	SET_PROTOCOL_TYPE_SEQ_REQUEST = "Set Protocol Type (SEQ)",  //$NON-NLS-1$
	SET_PROTOCOL_TYPE_ALT_REQUEST = "Set Protocol Type (ALT)",  //$NON-NLS-1$
	SET_PROTOCOL_TYPE_PERFORM_REQUEST = "Set Protocol Type (PERFORM)";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	Object o = getHost().getModel();
	
	if (SET_PROTOCOL_TYPE_PAR_REQUEST.equals(request.getType()))
		return new SetProtocolTypeCommand((IProtocol) o, HProtocolCombinator.PAR_COMBINATOR);
	else if (SET_PROTOCOL_TYPE_SEQ_REQUEST.equals(request.getType()))
		return new SetProtocolTypeCommand((IProtocol) o, HProtocolCombinator.SEQ_COMBINATOR);
	else if (SET_PROTOCOL_TYPE_ALT_REQUEST.equals(request.getType()))
		return new SetProtocolTypeCommand((IProtocol) o, HProtocolCombinator.ALT_COMBINATOR);
	else if (SET_PROTOCOL_TYPE_PERFORM_REQUEST.equals(request.getType()))
		return new SetProtocolTypeCommand((IProtocol) o, HProtocolCombinator.NO_COMBINATOR);
	else 
		return super.getCommand(request);
	
}


static class SetProtocolTypeCommand extends Command {

    private IProtocol protocol = null;
    private HProtocolChoice protocol_choice = null;
    
    int protocol_type = -1;
	
	public SetProtocolTypeCommand(IProtocol o, int protocol_type) 
	{
		super();
		
		this.protocol = o;
		this.protocol_choice = o.getProtocolChoice();
		this.protocol_type = protocol_type;
	}

	
	public void execute() 
	{
		HInterface i =  protocol.getInterface();
		Rectangle bounds = protocol.getBounds();
		boolean is_combinator = true;
		if (protocol_choice.getPar() != null && protocol_type != IProtocolCombinator.PAR_COMBINATOR)
		{
			protocol_choice.setPar(null);
		} 
		else if (protocol_choice.getAlt() != null && protocol_type != IProtocolCombinator.ALT_COMBINATOR)
		{
			protocol_choice.setAlt(null);
		}
		else if (protocol_choice.getSeq() != null && protocol_type != IProtocolCombinator.SEQ_COMBINATOR)
		{
			protocol_choice.setSeq(null);
		} 
		else if (protocol_choice.getPerform() != null && (protocol_type == IProtocolCombinator.ALT_COMBINATOR || protocol_type == IProtocolCombinator.SEQ_COMBINATOR || protocol_type == IProtocolCombinator.PAR_COMBINATOR))
		{
			protocol_choice.setPerform(null);
			is_combinator = false;
		}
		
		if (is_combinator)
		{
			HProtocolCombinator protocol_combinator = (HProtocolCombinator) protocol;
			if (protocol_type != IProtocolCombinator.NO_COMBINATOR)
				protocol_combinator.setCombinator(protocol_type);
			switch (protocol_type)
			{
			case IProtocolCombinator.ALT_COMBINATOR: protocol_choice.setAlt(protocol_combinator); protocol_combinator.updateChildren(); break;
			case IProtocolCombinator.PAR_COMBINATOR: protocol_choice.setPar(protocol_combinator); protocol_combinator.updateChildren();break;
			case IProtocolCombinator.SEQ_COMBINATOR: protocol_choice.setSeq(protocol_combinator); protocol_combinator.updateChildren(); break;
			default: 
				IProtocolPerform default_protocol = new HProtocolPerform();
				default_protocol.setId(protocol.getId());
				default_protocol.setOrder(protocol.getOrder());
		        default_protocol.setRepeat(protocol.isRepeat());		        
		        default_protocol.setProtocolChoice(protocol_choice);
		        default_protocol.setParentCombinator(protocol.getParentCombinator());
		        if (i!=null) 
		        	default_protocol.setInterface(i);
		        default_protocol.setBounds(bounds);
		        protocol_choice.setPerform(default_protocol);
			}
		} 
		else 
		{
			IProtocolCombinator default_protocol = new HProtocolCombinator();
			default_protocol.setId(protocol.getId());
			//if (protocol.getId() != null)
			//	try {
			//		default_protocol.setName(protocol.getName2());
			//	} catch (HPEInvalidNameException e) {
			//		// TODO Auto-generated catch block
			//		e.printStackTrace();
			//	}
			default_protocol.setOrder(protocol.getOrder());
			default_protocol.setRepeat(protocol.isRepeat());
			default_protocol.setBounds(bounds);
			default_protocol.setCombinator(protocol_type);
			default_protocol.setProtocolChoice(protocol_choice);
			default_protocol.setParentCombinator(protocol.getParentCombinator());
			if (i != null) 
				default_protocol.setInterface(i);
			switch (protocol_type)
			{
				case IProtocolCombinator.ALT_COMBINATOR: protocol_choice.setAlt(default_protocol); break;
				case IProtocolCombinator.PAR_COMBINATOR: protocol_choice.setPar(default_protocol); break;
				case IProtocolCombinator.SEQ_COMBINATOR: protocol_choice.setSeq(default_protocol); break;
			}
		}
	
		HProtocolCombinator pc = (HProtocolCombinator) protocol.getParentCombinator();
		if (pc == null && i != null)
		{
			HComponent c = (HComponent) i.getConfiguration();
			c.refresh();
		}

		if (pc == null && protocol instanceof HProtocolCombinator) 
			pc = (HProtocolCombinator) protocol; 

		if (pc != null) {
			pc.updateChildren();
			for (IProtocol pc_ : pc.getActions())
			{
				pc_.updateConnections();
				pc.updateEntryExitConnections();
			}
		}
		
	}
	
	public void undo () {
      
	}
	
	public void redo () {
	    execute();	
	}
	
}



}
