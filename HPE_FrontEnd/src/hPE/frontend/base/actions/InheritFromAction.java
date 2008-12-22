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
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;
import hPE.HPEPlugin;

public class InheritFromAction extends SelectionAction {

	private static final String
		INHERIT_FROM_REQUEST = "Inherit From";  //$NON-NLS-1$
	
	public static final String
	    INHERIT_FROM = "Inherit From";   //$NON-NLS-1$
	
	Request request;
	
	public InheritFromAction(IWorkbenchPart part) {
		super(part);
		request = new Request(INHERIT_FROM_REQUEST);
		setText(INHERIT_FROM);
		setId(INHERIT_FROM);
		setToolTipText(INHERIT_FROM);
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
			if (!(model instanceof HComponent)) return false;
			HComponent c = (HComponent) model;
	        for (IHUnit u : c.getEntries()) 
	        	if (u instanceof HUnitStub || !u.getBindings().isEmpty()) 
	        		return false;
	        if (c.isSuperType()) return false;
			HComponent topConfiguration = (HComponent) c.getTopConfiguration();
			if (topConfiguration == null) return false;			
			if (!topConfiguration.kindString().equals(c.kindString())) return false;
			//if (topConfiguration.getUnits().size() > 0) return false;
	        if (!c.isDirectSonOfTheTopConfiguration()) return false;
			if (topConfiguration.getWhoItImplements() == c) return false;
		}	
		
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Inherits from configuration");//$NON-NLS-1$
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
