package hPE.frontend.kinds.activate.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.base.model.HUnitSlice;
import hPE.HPEPlugin;

public class SetNestingFactorAction extends SelectionAction {

	private static final String
		INCREMENT_NF_REQUEST = "Increment Nesting Factor",
		DECREMENT_NF_REQUEST = "Decrement Nesting Factor";  //$NON-NLS-1$
	
	public static final String
	    INCREMENT_NF = "Increment Nesting Factor",
	    DECREMENT_NF = "Decrement Nesting Factor";  //$NON-NLS-1$
	
	Request request;
	boolean inc;
	
	public SetNestingFactorAction(IWorkbenchPart part, boolean inc) {
		super(part);
		if (inc) {
			   request = new Request(INCREMENT_NF_REQUEST);
			   setText("Increment Nesting Factor");
			   setId("Increment Nesting Factor");
			   setToolTipText("Increment Nesting Factor");
			   setImageDescriptor(
			   ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
			   setHoverImageDescriptor(getImageDescriptor());
		} else {
			   request = new Request(DECREMENT_NF_REQUEST);
			   setText("Decrement Nesting Factor");
			   setId("Decrement Nesting Factor");
			   setToolTipText("Decrement Nesting Factor");
			   setImageDescriptor(
			   ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
			   setHoverImageDescriptor(getImageDescriptor());
		}
		
		this.inc = inc;
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
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HUnitSlice)) return false;
			HUnitSlice x = (HUnitSlice) part.getModel();
            
            if (!inc  && x.getNestingFactor() <= 0) return false;
            if (x.getUnit().getInterface() != null) return false;
               
		}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Increment/Decrement Nesting Factor");//$NON-NLS-1$
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
