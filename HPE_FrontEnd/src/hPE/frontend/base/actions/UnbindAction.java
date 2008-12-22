package hPE.frontend.base.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IBindingTarget;
import hPE.HPEPlugin;

public class UnbindAction extends SelectionAction {


	private static final String
		UNBIND_REQUEST = "Unbind";  //$NON-NLS-1$
	
	public static final String
	    UNBIND = "Unbind";   //$NON-NLS-1$
	
	Request request;
	
	public UnbindAction(IWorkbenchPart part) {
		super(part);
		request = new Request(UNBIND_REQUEST);
		setText(UNBIND);
		setId(UNBIND);
		setToolTipText(UNBIND);
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
			if (!(part.getModel() instanceof HBinding)) return false;
			HBinding r = (HBinding) part.getModel();
			if (r.getEntry() instanceof HUnitStub) return false;
			IBindingTarget p = r.getPort();
			if (p instanceof HUnitSlice) {
			   return ((HUnitSlice) p).getUnit().getInterface() == null;
			} 
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("unbinding");//$NON-NLS-1$
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
