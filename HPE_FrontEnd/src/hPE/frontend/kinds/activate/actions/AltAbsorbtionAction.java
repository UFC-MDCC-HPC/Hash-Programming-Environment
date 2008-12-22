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
import hPE.frontend.kinds.activate.policies.AltAbsorptionEditPolicy.AltAbsorptionCommand;
import hPE.HPEPlugin;


public class AltAbsorbtionAction extends SelectionAction {

	private static final String
		ALT_ABSORPTION_REQUEST = "Alt Absorption";  //$NON-NLS-1$
	
	public static final String
	    ALT_ABSORPTION = "Alt Absorption";   //$NON-NLS-1$
	
	Request request;
	
	public AltAbsorbtionAction(IWorkbenchPart part) {
		super(part);
		request = new Request(ALT_ABSORPTION_REQUEST);
		setText(ALT_ABSORPTION);
		setId(ALT_ABSORPTION);
		setToolTipText(ALT_ABSORPTION);
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
		
		HAltAction alt_action = null;
		HAction any_action = null;
		
		if (parts.size() == 2) {
			for (int i=0; i<parts.size(); i++){
				Object o = parts.get(i);
				if (!(o instanceof EditPart)) return false;
				EditPart part = (EditPart) o;
				Object model = part.getModel();
				
				if (model instanceof HAltAction) {
					alt_action = (HAltAction) model;
				} else if (model instanceof HAction){
					any_action = (HAction) model;
				} else {
					return false;
				}
			}
			if (alt_action == null) return false;
			if (alt_action.getActionCombinator() != any_action.getActionCombinator()) return false;
			HCombinatorAction parent_action = alt_action.getActionCombinator();
			if (parent_action instanceof HSeqAction) {
               	if (parent_action.getActions().indexOf(any_action) != parent_action.getActions().indexOf(alt_action) - 1) 
               		return false;			
			}
		} else {
			return false;
		}
		
		
		
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Alt Absorption");//$NON-NLS-1$
		HAltAction alt_model = null;
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			if (part.getModel() instanceof HAltAction) {
				alt_model = (HAltAction) part.getModel();
			}
		}
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			AltAbsorptionCommand c = (AltAbsorptionCommand) part.getCommand(request);
			c.setAbsorbingAction(alt_model);
			cc.add(c);
		}
		return cc;
	}

	
	public void run() {
		execute(getCommand());
	}

	
}
