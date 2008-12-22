package hPE.frontend.actions.base;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;
import hPE.HPEPlugin;

public class ImplementsAction extends SelectionAction {

	private static final String
		IMPLEMENTS_REQUEST = "Implements";  //$NON-NLS-1$
	
	public static final String
	    IMPLEMENTS = "Implements";   //$NON-NLS-1$
	
	Request request;
	
	public ImplementsAction(IWorkbenchPart part) {
		super(part);
		request = new Request(IMPLEMENTS_REQUEST);
		setText(IMPLEMENTS);
		setId(IMPLEMENTS);
		setToolTipText(IMPLEMENTS);
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
		
		if (parts.size()!=1) return false;
		
		Object o = parts.get(0);
		if (!(o instanceof EditPart)) return false;
		
		Object model = ((EditPart) o).getModel();
		
		if (!(model instanceof HComponent)) return false;
		
        HComponent c = (HComponent) model;
        
        for (IHUnit u : c.getEntries()) 
        	if (u instanceof HUnitStub || !u.getBindings().isEmpty()) 
        		return false;
        
        if(c.isSuperType()) return false;
        
        if (!c.isAbstractConfiguration()) return false;
        
        if (!c.allSupplied()) return false;
        
        if (c.isTopConfiguration()) return false;
        HComponent topConfiguration = (HComponent) c.getTopConfiguration();
        
  		if (!topConfiguration.kindString().equals(c.kindString())) return false;		
		
  		if (topConfiguration.getWhoItImplements() == c) return false;
  		
        if (!c.isDirectSonOfTheTopConfiguration()) return false;

		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Implements Abstract Component!");//$NON-NLS-1$
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
