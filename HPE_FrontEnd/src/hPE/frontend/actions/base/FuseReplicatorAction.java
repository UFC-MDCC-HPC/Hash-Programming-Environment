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
import hPE.frontend.base.commands.FuseReplicatorCommand;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HReplicator;

public class FuseReplicatorAction extends SelectionAction {

	private static final String
		FUSE_REPLICATOR_REQUEST = "Fuse Replicator";  //$NON-NLS-1$
	
	public static final String
	    FUSE_REPLICATOR = "Fuse Replicator";   //$NON-NLS-1$
	
	Request request;
	
	public FuseReplicatorAction(IWorkbenchPart part) {
		super(part);
		request = new Request(FUSE_REPLICATOR_REQUEST);
		setText(FUSE_REPLICATOR);
		setId(FUSE_REPLICATOR);
		setToolTipText(FUSE_REPLICATOR);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		if (getSelectedObjects().size()<2)
			return false;
		List parts = getSelectedObjects();
		for (int i=0; i<parts.size(); i++){
			Object o = parts.get(i);
			if (!(o instanceof EditPart)) return false;
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HReplicator)) return false;
			HReplicator r = (HReplicator) part.getModel();
		
			
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Fuse Replicators");//$NON-NLS-1$
		
		HReplicator rTop = null;
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			FuseReplicatorCommand c = (FuseReplicatorCommand) part.getCommand(request);
			if (i==0) rTop = (HReplicator) part.getModel();			
			c.setTop(rTop);
			cc.add(c);
		}
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
