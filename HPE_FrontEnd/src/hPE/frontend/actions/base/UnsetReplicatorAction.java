package hPE.frontend.actions.base;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.base.model.HLinkToReplicator;
import hPE.HPEPlugin;

public class UnsetReplicatorAction extends SelectionAction {


	private static final String
		UNSET_REPLICATOR_REQUEST = "Unset replicator";  //$NON-NLS-1$
	
	public static final String
	    UNSET_REPLICATOR = "Unset replicator";   //$NON-NLS-1$
	
	Request request;
	
	public UnsetReplicatorAction(IWorkbenchPart part) {
		super(part);
		request = new Request(UNSET_REPLICATOR_REQUEST);
		setText(UNSET_REPLICATOR);
		setId(UNSET_REPLICATOR);
		setToolTipText(UNSET_REPLICATOR);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
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
			if (!(part.getModel() instanceof HLinkToReplicator)) return false;
			HLinkToReplicator r = (HLinkToReplicator) part.getModel();
			if (r.isPermanent()) return false;
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Unlink from replicator");//$NON-NLS-1$
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
