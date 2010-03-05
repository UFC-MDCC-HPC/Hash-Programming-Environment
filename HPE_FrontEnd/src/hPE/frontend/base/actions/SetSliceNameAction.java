package hPE.frontend.base.actions;

import hPE.HPEPlugin;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.policies.SetSliceNameEditPolicy;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

public class SetSliceNameAction extends SelectionAction {

	private static final String
		SET_SLICE_NAME_REQUEST = "Set Slice Name";  //$NON-NLS-1$
	
	public static final String
	    SET_SLICE_NAME = "Set Slice Name";   //$NON-NLS-1$
	
	Request request;
	
	// InputDialog dialog = null;
	
	private Shell shell; 
	
	public SetSliceNameAction(IWorkbenchPart part) {
		super(part);
		request = new Request(SET_SLICE_NAME_REQUEST);
		setText(SET_SLICE_NAME);
		setId(SET_SLICE_NAME);
		setToolTipText(SET_SLICE_NAME);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
		shell = part.getSite().getWorkbenchWindow().getShell();
	    // dialog = new InputDialog(part.getSite().getWorkbenchWindow().getShell(),"Set Slice Name","Slice Name","x",null);
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
			//if (!(part instanceof InterfaceSliceEditPart)) return false;
			if (!(part.getParent().getModel() instanceof HInterface)) return false;
			HInterface iContainer = (HInterface) part.getParent().getModel();
			if (!iContainer.isEditable()) return false;			
			
		//	if (!(part.getModel() instanceof HInterfaceSlice)) return false;
			if (part.getModel() instanceof HInterfaceSlice) {			
 			   HInterfaceSlice s = (HInterfaceSlice) part.getModel();
 			   if (s.isInherited()) return false;
			} 
			
		}	
		return true;
	}
	
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Set Slice Name");//$NON-NLS-1$
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			Command c = (Command) part.getCommand(request); 
			if (c instanceof SetSliceNameEditPolicy.SetSliceNameCommand) {
				((SetSliceNameEditPolicy.SetSliceNameCommand) c).setShell(shell);
			}
			cc.add(c);
		}
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
