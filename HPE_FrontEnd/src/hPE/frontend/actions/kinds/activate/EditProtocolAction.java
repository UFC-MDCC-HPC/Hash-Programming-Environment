package hPE.frontend.actions.kinds.activate;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.model.kinds.activate.HActivateInterface;
import hPE.model.protocol.kinds.activate.HProtocol;
import hPE.HPEPlugin;

public class EditProtocolAction extends SelectionAction {

	private static final String
		SHOW_PROTOCOL_REQUEST = "Show Protocol",  //$NON-NLS-1$
        HIDE_PROTOCOL_REQUEST = "Hide Protocol";  //$NON-NLS-1$
	
	public static final String
        SHOW_PROTOCOL = "Show Protocol",   //$NON-NLS-1$
	    HIDE_PROTOCOL = "Hide Protocol";   //$NON-NLS-1$
	
	Request request;
	
	boolean show = true;
	
	public EditProtocolAction(IWorkbenchPart part, boolean show) {
		super(part);
		this.show = show;
		if (show) {
			request = new Request(SHOW_PROTOCOL_REQUEST);
			setText(SHOW_PROTOCOL);
			setId(SHOW_PROTOCOL);
			setToolTipText(SHOW_PROTOCOL);
			setImageDescriptor(
			ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
			setHoverImageDescriptor(getImageDescriptor());
		}
		else {
			request = new Request(HIDE_PROTOCOL_REQUEST);
			setText(HIDE_PROTOCOL);
			setId(HIDE_PROTOCOL);
			setToolTipText(HIDE_PROTOCOL);
			setImageDescriptor(
			ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
			setHoverImageDescriptor(getImageDescriptor());
		}
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
			if (!(part.getModel() instanceof HActivateInterface || part.getModel() instanceof HProtocol)) return false;
			if (part.getModel() instanceof HActivateInterface) {
			    HActivateInterface f = (HActivateInterface) part.getModel();
			    // if (f.getSlices().size() == 0) return false;
			    if (f.getProtocol() == null) return false;
			    return (show && !f.protocolIsVisible()) || (!show && f.protocolIsVisible());
			} else if (part.getModel() instanceof HProtocol) {
				HProtocol p = (HProtocol) part.getModel();
				if (show) return false;
			}
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Show/Hide Protocol !");//$NON-NLS-1$
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
