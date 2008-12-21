package hPE.frontend.actions.kinds.activate;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.commands.kinds.activate.InterleaveActionsCommand;
import hPE.frontend.edits.policies.kinds.activate.RepeatFusionEditPolicy.RepeatFusionCommand;
import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HAltAction;
import hPE.model.protocol.kinds.activate.HCombinatorAction;
import hPE.model.protocol.kinds.activate.HParAction;
import hPE.model.protocol.kinds.activate.HSeqAction;
import hPE.HPEPlugin;


public class RepeatFusionAction extends SelectionAction {

	private static final String
		REPEAT_FUSION_REQUEST = "Repeat Fusion";  //$NON-NLS-1$
	
	public static final String
	    REPEAT_FUSION = "Repeat Fusion";   //$NON-NLS-1$
	
	Request request;
	
	public RepeatFusionAction(IWorkbenchPart part) {
		super(part);
		request = new Request(REPEAT_FUSION_REQUEST);
		setText(REPEAT_FUSION);
		setId(REPEAT_FUSION);
		setToolTipText(REPEAT_FUSION);
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
		
		HAction parent_action = null;
		
		if (parts.size() >= 2) {
			for (int i=0; i<parts.size(); i++){
				Object o = parts.get(i);
				if (!(o instanceof EditPart)) return false;
				EditPart part = (EditPart) o;
				Object model = part.getModel();
				if (!(model instanceof HAction)) return false;
				if (!((HAction) model).isRepeat()) return false;
				if (parent_action == null) {
					parent_action = ((HAction) model).getActionCombinator();
					if (!(parent_action instanceof HParAction)) return false;
				} else {
					if (parent_action != ((HAction)model).getActionCombinator()) return false;
				}
				
			}
		} else {
			return false;
		}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Repeat Fusion");//$NON-NLS-1$
	    
		HParAction parent_action = (HParAction)((HAction)((EditPart)editparts.get(0)).getModel()).getActionCombinator();
	    HAction undo_action = parent_action.getTopActionCopy();
		HParAction par_action = new HParAction(null,parent_action);
		par_action.setRepeat(1);
		
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			RepeatFusionCommand c = (RepeatFusionCommand) part.getCommand(request);
			c.setWorkingActions(parent_action, par_action);
			c.setUndoAction(undo_action);
			cc.add(c);
		}
		return cc;
	}

	
	public void run() {
		execute(getCommand());
	}

	
}
