package hPE.frontend.actions.base;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.ui.IWorkbenchPart;

import hPE.HPEPlugin;
import hPE.frontend.commands.base.UnfuseReplicatorCommand;
import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HReplicator;

public class UnfuseReplicatorAction extends SelectionAction {

	private static final String
		UNFUSE_REPLICATOR_REQUEST = "Unfuse Replicator";  //$NON-NLS-1$
	
	public static final String
	    UNFUSE_REPLICATOR = "Unfuse Replicator";   //$NON-NLS-1$
	
	Request request;
	
	public UnfuseReplicatorAction(IWorkbenchPart part) {
		super(part);
		request = new Request(UNFUSE_REPLICATOR_REQUEST);
		setText(UNFUSE_REPLICATOR);
		setId(UNFUSE_REPLICATOR);
		setToolTipText(UNFUSE_REPLICATOR);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		return false;
		/*
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		for (int i=0; i<parts.size(); i++){
			Object o = parts.get(i);
			if (!(o instanceof EditPart)) return false;
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HReplicator)) return false;
			HReplicator r = (HReplicator) part.getModel();
		    if (r.getMyJoined().isEmpty()) return false;
			
		}	
		return true;*/
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Unfuse Replicators");//$NON-NLS-1$
		
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			UnfuseReplicatorCommand c = (UnfuseReplicatorCommand) part.getCommand(request);
			cc.add(c);
		}
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
