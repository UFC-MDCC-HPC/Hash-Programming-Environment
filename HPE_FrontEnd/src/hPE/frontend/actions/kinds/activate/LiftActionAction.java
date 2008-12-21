package hPE.frontend.actions.kinds.activate;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.ui.IWorkbenchPart;

import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HAltAction;
import hPE.model.protocol.kinds.activate.HCombinatorAction;
import hPE.model.protocol.kinds.activate.HParAction;
import hPE.model.protocol.kinds.activate.HSeqAction;
import hPE.HPEPlugin;

public class LiftActionAction extends SelectionAction {

	private static final String
		LIFT_ACTION_REQUEST = "Lift Action";  //$NON-NLS-1$
	
	public static final String
	    LIFT_ACTION = "Lift Action";   //$NON-NLS-1$
	
	Request request;
	
	public LiftActionAction(IWorkbenchPart part) {
		super(part);
		request = new Request(LIFT_ACTION_REQUEST);
		setText(LIFT_ACTION);
		setId(LIFT_ACTION);
		setToolTipText(LIFT_ACTION);
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
			if (!(part.getModel() instanceof HCombinatorAction && part.getParent().getModel() instanceof HCombinatorAction)) return false;
			HAction parent_model = (HAction) part.getParent().getModel();
			HAction model        = (HAction) part.getModel();
			if (!(parent_model instanceof HCombinatorAction)) return false;
			if (parent_model instanceof HSeqAction && !parent_model.isRepeat() 
				    && model instanceof HSeqAction && !model.isRepeat()) return true;
			else 
			if (parent_model instanceof HParAction && !parent_model.isRepeat() 
					&& model instanceof HParAction && !model.isRepeat()) return true;
			else 
			if (parent_model instanceof HAltAction && !parent_model.isRepeat() 
					&& model instanceof HAltAction && !model.isRepeat()) return true;
			else 
			return false;
			
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Lift action");//$NON-NLS-1$
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			Command c = (Command) part.getCommand(request); 
			cc.add(c);
		}
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
