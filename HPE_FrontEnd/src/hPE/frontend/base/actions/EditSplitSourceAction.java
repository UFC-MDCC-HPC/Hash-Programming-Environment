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
import hPE.frontend.base.model.HReplicatorSplit;
import hPE.HPEPlugin;

public class EditSplitSourceAction extends SelectionAction {

	private static final String
		EDIT_SPLIT_SOURCE_REQUEST = "Edit Split Source";
	
	public static final String
        EDIT_SPLIT_SOURCE = "Edit Split Source";

	Request request;
	boolean show;
	
	public EditSplitSourceAction(IWorkbenchPart part) {
	   super(part);
	   request = new Request(EDIT_SPLIT_SOURCE_REQUEST);
	   setText("Edit Spit Source");
	   setId("Edit Split Source");
	   setToolTipText("Edit Split Source");
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
		for (int i=0; i<parts.size(); i++){
			Object o = parts.get(i);
			if (!(o instanceof EditPart)) return false;
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HReplicatorSplit)) {
				return false;
			}
            HReplicatorSplit x = (HReplicatorSplit) part.getModel();
            
            HComponent c = (HComponent) x.getConfiguration();
            HComponent topC = (HComponent) c.getTopConfiguration();
            
            //if (topC.isAbstractConfiguration()) return false;
                       
      	}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Edit Split Source");//$NON-NLS-1$
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
