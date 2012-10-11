package hPE.frontend.kinds.activate.actions;

import hPE.HPEPlugin;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;
import hPE.frontend.kinds.activate.model.protocol.IProtocolCombinator;
import hPE.xml.component.ProtocolType;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

public class SetProtocolTypeAction extends SelectionAction {

	private static final String
		SET_PROTOCOL_TYPE_PAR_REQUEST = "Set Protocol Type (PAR)",  //$NON-NLS-1$
		SET_PROTOCOL_TYPE_SEQ_REQUEST = "Set Protocol Type (SEQ)",  //$NON-NLS-1$
		SET_PROTOCOL_TYPE_ALT_REQUEST = "Set Protocol Type (ALT)",  //$NON-NLS-1$
		SET_PROTOCOL_TYPE_PERFORM_REQUEST = "Set Protocol Type (PERFORM)";  //$NON-NLS-1$
	
	public static final String
		SET_PROTOCOL_TYPE_PAR = "Set Protocol Type (PAR)",  //$NON-NLS-1$
		SET_PROTOCOL_TYPE_SEQ= "Set Protocol Type (SEQ)",  //$NON-NLS-1$
		SET_PROTOCOL_TYPE_ALT= "Set Protocol Type (ALT)",  //$NON-NLS-1$
		SET_PROTOCOL_TYPE_PERFORM = "Set Protocol Type (PERFORM)";  //$NON-NLS-1$
	
	Request request;
	
	private int protocol_type;
	
	public SetProtocolTypeAction(IWorkbenchPart part, int protocol_type) 
	{
		super(part);
		
		switch (protocol_type) 
		{
		case IProtocolCombinator.PAR_COMBINATOR:
			request = new Request(SET_PROTOCOL_TYPE_PAR_REQUEST);
			setText("Set PAR");
			setId(SET_PROTOCOL_TYPE_PAR);
			setToolTipText(SET_PROTOCOL_TYPE_PAR);
			break;
		case IProtocolCombinator.ALT_COMBINATOR:
			request = new Request(SET_PROTOCOL_TYPE_ALT_REQUEST);
			setText("Set ALT");
			setId(SET_PROTOCOL_TYPE_ALT);
			setToolTipText(SET_PROTOCOL_TYPE_ALT);
			break;
		case IProtocolCombinator.SEQ_COMBINATOR:
			request = new Request(SET_PROTOCOL_TYPE_SEQ_REQUEST);
			setText("Set SEQ");
			setId(SET_PROTOCOL_TYPE_SEQ);
			setToolTipText(SET_PROTOCOL_TYPE_SEQ);
			break;
		default:
			request = new Request(SET_PROTOCOL_TYPE_PERFORM_REQUEST);
			setText("Set PERFORM");
			setId(SET_PROTOCOL_TYPE_PERFORM);
			setToolTipText(SET_PROTOCOL_TYPE_PERFORM);
		}
		
		setImageDescriptor(ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
		
		this.protocol_type = protocol_type;
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		for (int i=0; i<parts.size(); i++){
			Object o = parts.get(i);
			if (!(o instanceof EditPart)) return false;
			EditPart part = (EditPart)o;
			if (part.getModel() instanceof IProtocol) 
			{
				IProtocol protocol = (IProtocol) part.getModel();
				if (protocol instanceof IProtocolCombinator) 
				{
					IProtocolCombinator protocol_combinator = (IProtocolCombinator) part.getModel();					
					int protocol_type_current = protocol_combinator.getCombinator();
					if (protocol_type_current == protocol_type) return false;
					if (!protocol_combinator.getActions().isEmpty() && protocol_type != IProtocolCombinator.ALT_COMBINATOR && 
							protocol_type != IProtocolCombinator.PAR_COMBINATOR &&
							protocol_type != IProtocolCombinator.SEQ_COMBINATOR) return false;
				}
				else 
				{
					if (protocol_type != IProtocolCombinator.ALT_COMBINATOR && 
						protocol_type != IProtocolCombinator.PAR_COMBINATOR &&
						protocol_type != IProtocolCombinator.SEQ_COMBINATOR)
							return false;
				}
			} 
			else
				return false;
			
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Set Protocol Type Box!");//$NON-NLS-1$
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			cc.add(part.getCommand(request));
		}
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
