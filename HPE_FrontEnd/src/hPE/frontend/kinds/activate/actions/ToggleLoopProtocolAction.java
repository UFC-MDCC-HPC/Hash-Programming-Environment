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

public class ToggleLoopProtocolAction extends SelectionAction {

	private static final String
		TOGGLE_LOOP_REQUEST = "Toggle Loop";  //$NON-NLS-1$
	
	public static final String
        TOGGLE_LOOP = "Toggle Loop";   //$NON-NLS-1$
	
	Request request;
	
	
	public ToggleLoopProtocolAction(IWorkbenchPart part) {
		super(part);
			request = new Request(TOGGLE_LOOP_REQUEST);
			setText(TOGGLE_LOOP);
			setId(TOGGLE_LOOP);
			setToolTipText(TOGGLE_LOOP);
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
			if (part.getModel() instanceof HProtocolChoice) return false;
			if (part.getModel() instanceof IProtocol) 
			{
				IProtocol protocol = (IProtocol) part.getModel();
			}  
			else
				return false;
			
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Toggle Loop Action !");//$NON-NLS-1$
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
