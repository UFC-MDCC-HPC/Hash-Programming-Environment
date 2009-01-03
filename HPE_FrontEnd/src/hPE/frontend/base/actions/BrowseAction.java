package hPE.frontend.base.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.HPEPlugin;

public class BrowseAction extends SelectionAction {

	private static final String
		BROWSE_REQUEST = "Browse";
	
	public static final String
        BROWSE = "Browse";

	Request request;
	boolean show;
	
	public BrowseAction(IWorkbenchPart part) {
	   super(part);
	   request = new Request(BROWSE_REQUEST);
	   setText(BROWSE);
	   setId(BROWSE);
	   setToolTipText(BROWSE);
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
			if (!(part.getModel() instanceof HComponent)) {
				return false;
			}
            HComponent c = (HComponent) part.getModel();
            HComponent topC = (HComponent) c.getTopConfiguration();
            if (c!=topC) 
            	return false;
            
      	}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel(BROWSE);//$NON-NLS-1$
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
