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
import hPE.HPEPlugin;

public class ExposedAction extends SelectionAction {

	private static final String
		EXPOSED_REQUEST = "Exposed Yes/No";  //$NON-NLS-1$
	
	public static final String
	    EXPOSED = "Exposed Yes/No";   //$NON-NLS-1$
	
	Request request;
	
	public ExposedAction(IWorkbenchPart part) {
		super(part);
		request = new Request(EXPOSED_REQUEST);
		setText(EXPOSED);
		setId(EXPOSED);
		setToolTipText(EXPOSED);
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
		
		if (parts.size()!=1) return false;
		
		Object o = parts.get(0);
		if (!(o instanceof EditPart)) return false;
		
		Object model = ((EditPart) o).getModel();
		
		if (!(model instanceof HComponent)) return false;
		
        HComponent c = (HComponent) model;
        
        if (c.isSuperType()) return false;
        
        HComponent topC = (HComponent) c.getTopConfiguration();
        
        if (c.isTopConfiguration()) return false;
        
        if (topC.getSuperType() == c) return false;
            
//        if (topC.isAbstractConfiguration() || topC.getWhoItImplements() != null) return false;
        
 
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Expose Component!");//$NON-NLS-1$
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
