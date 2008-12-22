package hPE.frontend.kinds.activate.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.kinds.activate.commands.InterleaveActionsCommand;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HAltAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;
import hPE.frontend.kinds.activate.model.protocol.HParAction;
import hPE.frontend.kinds.activate.model.protocol.HSeqAction;
import hPE.HPEPlugin;

public class CutBranchAction extends SelectionAction {

	private static final String
		CUT_BRANCH_REQUEST = "Cut Branch";  //$NON-NLS-1$
	
	public static final String
	    CUT_BRANCH = "Cut Branch";   //$NON-NLS-1$
	
	Request request;
	
	public CutBranchAction(IWorkbenchPart part) {
		super(part);
		request = new Request(CUT_BRANCH_REQUEST);
		setText(CUT_BRANCH);
		setId(CUT_BRANCH);
		setToolTipText(CUT_BRANCH);
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
			Object parent_model = part.getParent().getModel();
			if (!(parent_model instanceof HAltAction)) return false;
			if (((HAltAction)parent_model).getActions().size() <=1) return false;
		}	
		
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Cut Branch in alt-action");//$NON-NLS-1$
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
