package hPE.frontend.actions.base;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.base.model.IHUnit;
import hPE.HPEPlugin;

public class BuildInterfaceFromSlicesAction extends SelectionAction {


	private static final String
		CREATE_INTERFACE_FROM_SLICE_REQUEST = "Create Interface";  //$NON-NLS-1$
	
	public static final String
	    CREATE_INTERFACE_FROM_SLICE = "Create Interface";   //$NON-NLS-1$
	
	Request request;
	
	public BuildInterfaceFromSlicesAction(IWorkbenchPart part) {
		super(part);
		request = new Request(CREATE_INTERFACE_FROM_SLICE_REQUEST);
		setText("Create Interface");
		setId("Create Interface");
		setToolTipText("Create Interface");
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle16.gif")); //$NON-NLS-1$
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
			if (!(part.getModel() instanceof IHUnit)) return false;
			IHUnit u = (IHUnit) part.getModel();
			if (u.getInterface() != null) return false;
			// In a composite unit, any unit must be formed from unification of other units.
			/* if (u instanceof HUnit) 
				if (((HUnit) u).getSlices().size() == 0) return false; */
		}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Create interface from slices");//$NON-NLS-1$
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
