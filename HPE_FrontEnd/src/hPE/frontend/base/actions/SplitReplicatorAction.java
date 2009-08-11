package hPE.frontend.base.actions;

import java.util.Collection;
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
		SPLIT_REPLICATOR_REQUEST = "Split Enumeration";  //$NON-NLS-1$
	
	public static final String
	    SPLIT_REPLICATOR = "Split Enumeration";   //$NON-NLS-1$
	
	Request request;
	
	InputDialog dialog = null;
	
	public SplitReplicatorAction(IWorkbenchPart part) {
		super(part);
		request = new Request(SPLIT_REPLICATOR_REQUEST);
		setText(SPLIT_REPLICATOR);
		setId(SPLIT_REPLICATOR);
		setToolTipText(SPLIT_REPLICATOR);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle16.gif")); //$NON-NLS-1$
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
		
		if (parts.size() != 1) return false;
		Object o = parts.get(0);
		if (!(o instanceof EditPart)) return false;
		EditPart part = (EditPart)o;
		if (!(part.getModel() instanceof HReplicator)) return false;
		HReplicator r = (HReplicator) part.getModel();

		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		List links = new ArrayList();
		EditPart part = null;
		part = (EditPart)editparts.get(0);
				
		SplitReplicatorCommand c = (SplitReplicatorCommand) part.getCommand(request);
		c.setDialog(dialog);
		
		return c;
		
}
	
	public void run() {
		execute(getCommand());
	}

	
}
