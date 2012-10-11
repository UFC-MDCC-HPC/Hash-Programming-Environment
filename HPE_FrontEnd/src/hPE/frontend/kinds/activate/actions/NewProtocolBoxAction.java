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

public class NewProtocolBoxAction extends SelectionAction {

	private static final String
		NEW_PROTOCOL_REQUEST = "New Protocol";  //$NON-NLS-1$
	
	public static final String
        NEW_PROTOCOL = "New Protocol";   //$NON-NLS-1$
	
	Request request;
	
	
	public NewProtocolBoxAction(IWorkbenchPart part) {
		super(part);
			request = new Request(NEW_PROTOCOL_REQUEST);
			setText(NEW_PROTOCOL);
			setId(NEW_PROTOCOL);
			setToolTipText(NEW_PROTOCOL);
			setImageDescriptor(
			ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
			setHoverImageDescriptor(getImageDescriptor());
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
			if (part.getModel() instanceof IProtocolCombinator) 
			{
				IProtocolCombinator protocol = (IProtocolCombinator) part.getModel();
			} 
			else if (part.getModel() instanceof ProtocolChoiceType) 
			{
				ProtocolChoiceType protocol_choice = (ProtocolChoiceType) part.getModel();
			} 
			else
				return false;
			
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("New Protocol Box!");//$NON-NLS-1$
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
