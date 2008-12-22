package hPE.frontend.kinds.activate.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.kinds.activate.model.protocol.HAltAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;
import hPE.frontend.kinds.activate.model.protocol.HParAction;
import hPE.frontend.kinds.activate.model.protocol.HSeqAction;
import hPE.HPEPlugin;

public class UnnestActionAction extends SelectionAction {

	private static final String
		UNNEST_ACTION_REQUEST = "Unnest Action";  //$NON-NLS-1$
	
	public static final String
	    UNNEST_ACTION = "Unnest Action";   //$NON-NLS-1$
	
	Request request;
	
	public UnnestActionAction(IWorkbenchPart part) {
		super(part);
		request = new Request(UNNEST_ACTION_REQUEST);
		setText(UNNEST_ACTION);
		setId(UNNEST_ACTION);
		setToolTipText(UNNEST_ACTION);
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
			Object model = part.getModel();
			if (model instanceof HCombinatorAction) {
				HCombinatorAction m = (HCombinatorAction) model;
				if (m.getActions().size()==1) 
					return true;
				else 
					return false;     
			} 
			else return false;
			
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
