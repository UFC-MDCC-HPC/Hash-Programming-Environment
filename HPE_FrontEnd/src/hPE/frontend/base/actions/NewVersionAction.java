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

public class NewVersionAction extends SelectionAction {

	private static final String
		NEW_VERSION_REQUEST = "Manage Version";
	
	public static final String
        NEW_VERSION = "Manage Version";

	Request request;
	boolean show;
	
	public NewVersionAction(IWorkbenchPart part) {
	   super(part);
	   request = new Request(NEW_VERSION_REQUEST);
	   setText(NEW_VERSION);
	   setId(NEW_VERSION);
	   setToolTipText(NEW_VERSION);
	   setImageDescriptor(
	   ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
	   setHoverImageDescriptor(getImageDescriptor());		
	   
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		
		if (getSelectedObjects().size() !=1 )
			return false;
		EditPart part = (EditPart) getSelectedObjects().get(0);
		if (!(part.getModel() instanceof HComponent)) {
			return false;
		}
        HComponent c = (HComponent) part.getModel();
        HComponent topC = (HComponent) c.getTopConfiguration();
        
        if (c!=topC) return false;
        if (topC.isAbstractConfiguration()) return false;
            
      	return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Manage Version");//$NON-NLS-1$
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
