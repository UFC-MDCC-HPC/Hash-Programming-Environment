package hPE.frontend.actions.kinds.activate;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.edits.base.PortEditPart;
import hPE.model.base.HUnitStub;
import hPE.model.base.IHUnit;
import hPE.HPEPlugin;

public class SetPrivateUnitAction extends SelectionAction {

	private static final String
		SET_PUBLIC_UNIT_REQUEST = "Set Public Unit",
		SET_PRIVATE_UNIT_REQUEST = "Set Private Unit";  //$NON-NLS-1$
	
	public static final String
	    SET_PUBLIC_UNIT = "Set Public Unit",
	    SET_PRIVATE_UNIT = "Set Private Unit";  //$NON-NLS-1$
	
	Request request;
	boolean setPrivateUnit;
	
	public SetPrivateUnitAction(IWorkbenchPart part, boolean setPrivateUnit) {
		super(part);
		if (!setPrivateUnit) {
			   request = new Request(SET_PUBLIC_UNIT_REQUEST);
			   setText("Set Public Unit");
			   setId("Set Public Unit");
			   setToolTipText("Set Public Unit");
			   setImageDescriptor(
			   ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
			   setHoverImageDescriptor(getImageDescriptor());
		} else {
			   request = new Request(SET_PRIVATE_UNIT_REQUEST);
			   setText("Set Private Unit");
			   setId("Set Private Unit");
			   setToolTipText("Set Private Unit");
			   setImageDescriptor(
			   ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
			   setHoverImageDescriptor(getImageDescriptor());
		}
		
		this.setPrivateUnit = setPrivateUnit;
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
			
			if (!(part.getModel() instanceof IHUnit)) return false;
            IHUnit x = (IHUnit) part.getModel();
            if (x.isEntry() && !(x instanceof HUnitStub)) return false;
            
            if ((setPrivateUnit) && (x.getHidden() || x.getHiddenBlocked())) return false;
            else if (!setPrivateUnit && !x.getHidden()) return false;           
               
		}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Set Public/Private Unit");//$NON-NLS-1$
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
