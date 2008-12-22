package hPE.frontend.actions.base;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.HPEPlugin;
import hPE.frontend.base.commands.SplitReplicatorCommand;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.IHUnit;


public class SplitReplicatorAction extends SelectionAction {


	private static final String
		SPLIT_REPLICATOR_REQUEST = "Split replicator";  //$NON-NLS-1$
	
	public static final String
	    SPLIT_REPLICATOR = "Split replicator";   //$NON-NLS-1$
	
	Request request;
	
	InputDialog dialog = null;
	
	public SplitReplicatorAction(IWorkbenchPart part) {
		super(part);
		request = new Request(SPLIT_REPLICATOR_REQUEST);
		setText(SPLIT_REPLICATOR);
		setId(SPLIT_REPLICATOR);
		setToolTipText(SPLIT_REPLICATOR);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
	    dialog = new InputDialog(part.getSite().getWorkbenchWindow().getShell(),
	    		                 "Setting Splitting Factor",
	    		                 "Number of Replicas",
	    		                 "2",
	    		                 null);
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();

		HReplicator r = null;
		for (int i=0; i<parts.size(); i++){
			Object o = parts.get(i);
			if (!(o instanceof EditPart)) return false;
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HLinkToReplicator)) return false;
			HLinkToReplicator l = (HLinkToReplicator) part.getModel();
			if (r==null) r = l.getReplicator();
			else if (r != l.getReplicator()) return false;
			if (!(l.getReplicated() instanceof IHUnit)) return false;
			IHUnit u = (IHUnit) l.getReplicated();
			if (!u.isEntry() || u.getBinding()!=null) return false;
			
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
		
		SplitReplicatorCommand c = (SplitReplicatorCommand) part.getCommand(request);
		c.setLinks(links);
		c.setDialog(dialog);
		
		return c;
		
		
/*		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Split replicator");//$NON-NLS-1$
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			cc.add(part.getCommand(request));
		}
		return cc; */
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
