package hPE.frontend.base.actions;

import hPE.HPEPlugin;
import hPE.frontend.base.commands.SetMultipleCommand;
import hPE.frontend.base.interfaces.IElement;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.topology.model.HTopologyComponent;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;


public class SetMultipleAction extends SelectionAction {

	private static final String
		SET_MULTIPLE_REQUEST = "Set Multiple";  //$NON-NLS-1$
	
	public static final String
	    SET_MULTIPLE = "Set Multiple";  //$NON-NLS-1$
	
	Request request;
	
	public SetMultipleAction(IWorkbenchPart part) {
		super(part);
	    request = new Request(SET_MULTIPLE_REQUEST);
	    setText("Set Multiple");
	    setId("Set Multiple");
	    setToolTipText("Set Multiple");
	    setImageDescriptor(
	    ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
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
			if (!(part.getModel() instanceof IElement)) return false;
		    if (part.getModel() instanceof HComponent) 
		    {
		    	HComponent c = (HComponent) part.getModel();
		    	if (!c.isDirectSonOfTheTopConfiguration()) return false;		    	
		    	HComponent cTop = (HComponent) c.getTopConfiguration();
		    	if (c == cTop.getSuperType()) return false;		    	
		    }
		    else if (part.getModel() instanceof HUnit) 
		    {
		    	HUnit u = (HUnit) part.getModel();
		    	HComponent c = (HComponent) u.getConfiguration();		
		    	if (c.kindString().equals(HTopologyComponent.KIND)) return false;
		    	HComponent cTop = (HComponent) c.getTopConfiguration();
		    	if (cTop.getSuperType() != null) return false;
		    	if (u.getBinding() != null) return false;
		    }
			
		}
	   
		return true;

	}
	
	private Command getCommand() {
		List parts = getSelectedObjects();

		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Set Multiple");//$NON-NLS-1$
		for (int i=0; i<parts.size(); i++){
			EditPart part = (EditPart) parts.get(i);
			cc.add(part.getCommand(request));
			
     		IElement cBasis = (IElement) ((EditPart)parts.get(i)).getModel();		
  	        SetMultipleCommand c =  new SetMultipleCommand(cBasis);  // part.getCommand(request);
			
		    cc.add(c);
		}
		
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
