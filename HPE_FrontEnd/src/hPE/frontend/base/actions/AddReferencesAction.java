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

public class AddReferencesAction extends SelectionAction {

	private static final String
		ADD_REFERENCES_REQUEST = "Add References";
	
	public static final String
        ADD_REFERENCES = "Add References";

	Request request;
	boolean show;
	
	public AddReferencesAction(IWorkbenchPart part) {
	   super(part);
	   request = new Request(ADD_REFERENCES_REQUEST);
	   setText(ADD_REFERENCES);
	   setId(ADD_REFERENCES);
	   setToolTipText(ADD_REFERENCES);
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
		if (parts.size() != 1) return false;
		Object o = parts.get(0);
		if (!(o instanceof EditPart)) return false;
		EditPart part = (EditPart)o;
		if (!(part.getModel() instanceof HInterface)) {
			return false;
		}		
		
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Add References");//$NON-NLS-1$
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
