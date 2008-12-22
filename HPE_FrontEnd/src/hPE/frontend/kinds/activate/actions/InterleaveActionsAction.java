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

public class InterleaveActionsAction extends SelectionAction {

	private static final String
		INTERLEAVE_ACTIONS_REQUEST = "Interleave Actions";  //$NON-NLS-1$
	
	public static final String
	    INTERLEAVE_ACTIONS = "Interleave Actions";   //$NON-NLS-1$
	
	Request request;
	
	public InterleaveActionsAction(IWorkbenchPart part) {
		super(part);
		request = new Request(INTERLEAVE_ACTIONS_REQUEST);
		setText(INTERLEAVE_ACTIONS);
		setId(INTERLEAVE_ACTIONS);
		setToolTipText(INTERLEAVE_ACTIONS);
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
		HParAction grandparentAction = null;
		if (parts.size() > 1) {
			for (int i=0; i<parts.size(); i++){
				Object o = parts.get(i);
				if (!(o instanceof EditPart)) return false;
				EditPart part = (EditPart) o;
				
				if (!(part.getModel() instanceof HAction)) return false;
				if (!(part.getParent().getModel() instanceof HSeqAction)) return false;
				if (!(part.getParent().getParent().getModel() instanceof HParAction)) return false;
	
				if (grandparentAction == null) { 
				   grandparentAction = (HParAction) part.getParent().getParent().getModel();
				}
				else {
		            if (grandparentAction != part.getParent().getParent().getModel()) return false;
				}
	            if (((HSeqAction) part.getParent().getModel()).getActions().indexOf(part.getModel()) != 0) return false;
			}	
		} else {
			return false;
		}
		
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Interleave actions");//$NON-NLS-1$
		
		HAction top_action_copy = ((HAction)((EditPart) editparts.get(0)).getModel()).getTopActionCopy();
		
		HParAction par_action = (HParAction) ((EditPart) editparts.get(0)).getParent().getParent().getModel();
		HAltAction alt_action = new HAltAction(null,par_action);
		
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			InterleaveActionsCommand c = (InterleaveActionsCommand) part.getCommand(request);
			c.setAltCombinator(alt_action);
			c.setOtherModels(editparts);
			if (i==0) c.setTopActionCopy(top_action_copy);
			cc.add(c);
		}
		return cc;
	}

	
	public void run() {
		execute(getCommand());
	}

	
}
