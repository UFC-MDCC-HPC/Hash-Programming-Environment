package hPE.frontend.actions.base;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.HPEPlugin;
import org.eclipse.jface.dialogs.InputDialog;

import hPE.frontend.commands.base.SetRecursiveCommand;
import hPE.frontend.edits.policies.base.SetParameterEditPolicy;
import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.kinds.activate.computation.application.HApplicationComponent;

import java.util.Iterator;


public class SetRecursiveAction extends SelectionAction {

	private static final String
		SET_RECURSIVE_REQUEST = "Set Recursive";  //$NON-NLS-1$
	
	public static final String
	    SET_RECURSIVE = "Set Recursive";  //$NON-NLS-1$
	
	Request request;
	
	public SetRecursiveAction(IWorkbenchPart part) {
		super(part);
	    request = new Request(SET_RECURSIVE_REQUEST);
	    setText("Set Recursive");
	    setId("Set Recursive");
	    setToolTipText("Set Recursive");
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
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HComponent)) return false;
		 
  		    HComponent cBasis = (HComponent) ((EditPart)parts.get(i)).getModel();
  		    if (cBasis.isTopConfiguration()) return false;
            if (!cBasis.isDirectSonOfTheTopConfiguration()) return false;
  		    HComponent superType = ((HComponent)cBasis.getTopConfiguration()).getSuperType();
  		    // TODO: (getConfiguration) the recursive action is always applied at the top level of the top configuration
		    if (superType == null) return false;
			if (cBasis == superType || !cBasis.isSubTypeOf(superType)) 
				return false;
            if (!cBasis.isDirectSonOfTheTopConfiguration()) return false;

		}
	   
		return true;

	}
	
	private Command getCommand() {
		List parts = getSelectedObjects();

		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Set Recursive");//$NON-NLS-1$
		for (int i=0; i<parts.size(); i++){
			EditPart part = (EditPart) parts.get(i);
			cc.add(part.getCommand(request));
			
     		HComponent cBasis = (HComponent) ((EditPart)parts.get(i)).getModel();		
  	        SetRecursiveCommand c =  new SetRecursiveCommand(cBasis);  // part.getCommand(request);
			
		    cc.add(c);
		}
		
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
