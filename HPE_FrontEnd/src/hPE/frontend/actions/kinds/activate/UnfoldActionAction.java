package hPE.frontend.actions.kinds.activate;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HDoAction;
import hPE.HPEPlugin;

public class UnfoldActionAction extends SelectionAction {

	private static final String
		UNFOLD_ACTION_REQUEST = "Unfold Action",
		FOLD_ACTION_REQUEST = "Fold Action";  //$NON-NLS-1$
	
	public static final String
	    UNFOLD_ACTION = "Unfold Action",
	    FOLD_ACTION = "Fold Action";  //$NON-NLS-1$
	
	Request request;
	boolean unfold;
	
	public UnfoldActionAction(IWorkbenchPart part, boolean unfold) {
		super(part);
		if (unfold) {
			   request = new Request(UNFOLD_ACTION_REQUEST);
			   setText("Unfold Action");
			   setId("Unfold Action");
			   setToolTipText("Unfold Action");
			   setImageDescriptor(
			   ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
			   setHoverImageDescriptor(getImageDescriptor());
		} else {
			   request = new Request(FOLD_ACTION_REQUEST);
			   setText("Fold Action");
			   setId("Fold Action");
			   setToolTipText("Fold Action");
			   setImageDescriptor(
			   ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
			   setHoverImageDescriptor(getImageDescriptor());
		}
		
		this.unfold = unfold;
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
			
			if ((part.getModel() instanceof HDoAction)) {
               HDoAction a = (HDoAction) part.getModel();
               if (!unfold || a.getEncapsulatedAction() == null) return false;
               return true;
			}
			else if ((part.getModel() instanceof HAction)) {
	           HAction a = (HAction) part.getModel();
	           if (unfold || a.getEncapsulatingDoAction() == null) return false;
	           return true;
			} else
			   return false;
   		}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Unfold/Fold Action");//$NON-NLS-1$
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
