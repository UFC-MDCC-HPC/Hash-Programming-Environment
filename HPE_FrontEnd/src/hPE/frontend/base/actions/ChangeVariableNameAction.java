package hPE.frontend.base.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.ui.IWorkbenchPart;

import hPE.HPEPlugin;
import hPE.frontend.base.commands.ChangeVariableNameCommand;
import hPE.frontend.base.dialogs.DialogChangeVarName;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.IHasColor;

public class ChangeVariableNameAction extends SelectionAction {

	private static final String
		CHANGE_VARIABLE_NAME_REQUEST = "Change Variable Name";  //$NON-NLS-1$
	
	public static final String
	    CHANGE_VARIABLE_NAME = "Change Variable Name";   //$NON-NLS-1$
	
	Request request;
	
	public ChangeVariableNameAction(IWorkbenchPart part) {
		super(part);
		request = new Request(CHANGE_VARIABLE_NAME_REQUEST);
		setText(CHANGE_VARIABLE_NAME);
		setId(CHANGE_VARIABLE_NAME);
		setToolTipText(CHANGE_VARIABLE_NAME);
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
			if (!(part.getModel() instanceof HComponent)) return false;
			HComponent c = (HComponent) part.getModel();
			// if (c.getConfiguration() == null) return false;
			if (c.getParameters2().size() == 0) return false;
            if (!c.isDirectSonOfTheTopConfiguration() && !c.isTopConfiguration()) return false;
            if (((HComponent)c.getTopConfiguration()).getWhoItImplements() == c) return false;
            
		}	
		
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Change Variable Name");//$NON-NLS-1$
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			ChangeVariableNameCommand c = (ChangeVariableNameCommand) part.getCommand(request); 
			cc.add(c);
		}
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
