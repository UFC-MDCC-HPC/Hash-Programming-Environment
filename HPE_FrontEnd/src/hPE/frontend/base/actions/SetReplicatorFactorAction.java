package hPE.frontend.base.actions;

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
import hPE.frontend.base.commands.SetReplicatorFactorCommand;
import hPE.frontend.base.commands.SplitReplicatorCommand;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.IHUnit;


public class SetReplicatorFactorAction extends SelectionAction {


	private static final String
		SET_REPLICATOR_FACTOR_REQUEST = "Make Unitary";  //$NON-NLS-1$
	
	public static final String
	    SET_REPLICATOR_FACTOR = "Make Unitary";   //$NON-NLS-1$
	
	private Request request;
	
	private InputDialog dialog = null;
	
	public SetReplicatorFactorAction(IWorkbenchPart part) {
		super(part);
		request = new Request(SET_REPLICATOR_FACTOR_REQUEST);
		setText(SET_REPLICATOR_FACTOR);
		setId(SET_REPLICATOR_FACTOR);
		setToolTipText(SET_REPLICATOR_FACTOR);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
	    dialog = new InputDialog(part.getSite().getWorkbenchWindow().getShell(),
	    		                 "Configuring Replicator Factor",
	    		                 "Enter Replicator Factor",
	    		                 "0",
	    		                 null);
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		if (parts.size() > 1) {
			System.out.println();
		}
		
		for (int i=0; i<parts.size(); i++){
			Object o = parts.get(i);
			if (!(o instanceof EditPart)) return false;
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HReplicator)) return false;
			HReplicator r = (HReplicator) part.getModel();
			
			if (r.getSplits().size() > 0) return false;
			
			if ((r.getConfigurationWhereCreated() == r.getConfiguration().getTopConfiguration()) 
					&& r.getParentSplit() == null) return false;
			
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel(SET_REPLICATOR_FACTOR);//$NON-NLS-1$
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			SetReplicatorFactorCommand c = (SetReplicatorFactorCommand) part.getCommand(request);
			c.setDialog(dialog);
			cc.add(c);
		}
		return cc;		
		
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
