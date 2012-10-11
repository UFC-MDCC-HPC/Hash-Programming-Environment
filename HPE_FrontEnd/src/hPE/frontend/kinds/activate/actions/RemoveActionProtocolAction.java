package hPE.frontend.kinds.activate.actions;

import hPE.HPEPlugin;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
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

public class RemoveActionProtocolAction extends SelectionAction {

	private static final String
		REMOVE_ACTION_REQUEST = "Remove Action";  //$NON-NLS-1$
	
	public static final String
        REMOVE_ACTION = "Remove Action";   //$NON-NLS-1$
	
	Request request;
	
	
	public RemoveActionProtocolAction(IWorkbenchPart part) {
		super(part);
			request = new Request(REMOVE_ACTION_REQUEST);
			setText(REMOVE_ACTION);
			setId(REMOVE_ACTION);
			setToolTipText(REMOVE_ACTION);
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
			Object model = part.getModel();
			if (model instanceof IProtocol) 
			{
				IProtocol protocol = (IProtocol) model;
				if (protocol.getParentCombinator() == null) return false;
				if (model instanceof IProtocolCombinator) 
				{
					IProtocolCombinator protocol_combinator = (IProtocolCombinator) protocol;
					if (!protocol_combinator.getActions().isEmpty()) return false; 
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
		cc.setDebugLabel("Remove Action Action !");//$NON-NLS-1$
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
