package hPE.frontend.base.actions;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.HPEPlugin;
import hPE.frontend.base.commands.JoinReplicatorCommand;
import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HPrimUnitStub;
import hPE.frontend.base.model.IHUnit;


public class JoinReplicatorAction extends SelectionAction {


	private static final String
		JOIN_REPLICATOR_REQUEST = "Join replicator";  //$NON-NLS-1$
	
	public static final String
	    JOIN_REPLICATOR = "Join replicator";   //$NON-NLS-1$
	
	Request request;
	
	InputDialog dialog = null;
	
	public JoinReplicatorAction(IWorkbenchPart part) {
		super(part);
		request = new Request(JOIN_REPLICATOR_REQUEST);
		setText(JOIN_REPLICATOR);
		setId(JOIN_REPLICATOR);
		setToolTipText(JOIN_REPLICATOR);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle16.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
/*	    dialog = new InputDialog(part.getSite().getWorkbenchWindow().getShell(),
	    		                 "Setting Joining Factor",
	    		                 "Number of Replicas",
	    		                 "2",
	    		                 null);
*/	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
        IInterface ui = null;
        if (parts.size() < 2) return false;
		for (int i=0; i<parts.size(); i++){
			Object o = parts.get(i);
			if (!(o instanceof EditPart)) return false;
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HLinkToReplicator)) return false;
			HLinkToReplicator l = (HLinkToReplicator) part.getModel();
			if (!(l.getReplicated() instanceof IHUnit)) return false;			
			IHUnit u = (IHUnit) l.getReplicated();
			if (ui==null) ui = u.getInterface();
			else if (ui != u.getInterface()) return false;


			HBinding b = (HBinding) u.getBinding();
			
			if (u.isEntry() && ((u.getBinding()==null) || u.getBinding() != null && !(b.getPort() instanceof HPrimUnitStub))) return false;			
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		List links = new ArrayList();
		EditPart part = null;
		for (int i=0; i < editparts.size(); i++) {
			part = (EditPart)editparts.get(i);
			links.add(part.getModel());
		}
		
		JoinReplicatorCommand c = (JoinReplicatorCommand) part.getCommand(request);
		c.setLinks(links);
//		c.setDialog(dialog);
		
		return c;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
