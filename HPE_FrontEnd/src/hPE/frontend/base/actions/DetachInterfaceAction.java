package hPE.frontend.base.actions;

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

public class DetachInterfaceAction extends SelectionAction {


	private static final String
		DETACH_INTERFACE_REQUEST = "Detach Interface";  //$NON-NLS-1$
	
	public static final String
	    DETACH_INTERFACE = "Detach Interface";   //$NON-NLS-1$
	
	Request request;
	
	public DetachInterfaceAction(IWorkbenchPart part) {
		super(part);
		request = new Request(DETACH_INTERFACE_REQUEST);
		setText("Detach Interface");
		setId("Detach Interface");
		setToolTipText("Detach Interface");
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
			if (!(part.getModel() instanceof IHUnit)) return false;
			IHUnit u = (IHUnit) part.getModel();
			if (u.getInterface() == null || !u.isInterfaceEditable()) return false;
			if (u.isEntry()) return false;
		}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Detach interface from unit");//$NON-NLS-1$
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
