package hPE.frontend.actions.base;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HUnitSlice;
import hPE.HPEPlugin;

public class LiftReplicatorAction extends SelectionAction {

	private static final String
		LIFT_REPLICATOR_REQUEST = "Lift Replicator";  //$NON-NLS-1$
	
	public static final String
	    LIFT_REPLICATOR = "Lift Replicator";   //$NON-NLS-1$
	
	Request request;
	
	public LiftReplicatorAction(IWorkbenchPart part) {
		super(part);
		request = new Request(LIFT_REPLICATOR_REQUEST);
		setText(LIFT_REPLICATOR);
		setId(LIFT_REPLICATOR);
		setToolTipText(LIFT_REPLICATOR);
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
			EditPart part = (EditPart) o;
			Object model = part.getModel();
			if (!(model instanceof HLinkToReplicator)) return false;
			HLinkToReplicator l = (HLinkToReplicator) model;
			if (!(l.getReplicated() instanceof HUnitSlice)) return false;
			
		}	
		
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Lift Replicator");//$NON-NLS-1$
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
