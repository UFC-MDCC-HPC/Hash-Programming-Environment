package hPE.frontend.actions.base;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.edits.policies.base.SupplyParameterEditPolicy;
import hPE.model.base.HComponent;
import hPE.HPEPlugin;

public class SupplyParameterAction extends SelectionAction {

	private static final String
		SUPPLY_PARAMETER_REQUEST = "Supply Parameter";  //$NON-NLS-1$
	
	public static final String
	    SUPPLY_PARAMETER = "Supply Parameter";   //$NON-NLS-1$
	
	Request request;
	
	InputDialog dialog = null;
	
	public SupplyParameterAction(IWorkbenchPart part) {
		super(part);
		request = new Request(SUPPLY_PARAMETER_REQUEST);
		setText(SUPPLY_PARAMETER);
		setId(SUPPLY_PARAMETER);
		setToolTipText(SUPPLY_PARAMETER);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
	    dialog = new InputDialog(part.getSite().getWorkbenchWindow().getShell(),"Supplying Parameter","Variable Name","X",null);
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
			if (!(part.getModel() instanceof HComponent)) return false;
			HComponent c = (HComponent) part.getModel();
			if (c.isTopConfiguration()) return false;
			if (c.isConnected()) return false;
			if (c.isReplicated())return false;
			if (!c.isAbstractConfiguration()) return false; // only abstract configurations are parameterized ... 
		}	
		return true;
	}
	
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Supply Parameter");//$NON-NLS-1$
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			Command c = (Command) part.getCommand(request); 
			if (c instanceof SupplyParameterEditPolicy.SupplyParameterCommand) {
				((SupplyParameterEditPolicy.SupplyParameterCommand) c).setDialog(dialog);
			}
			cc.add(c);
		}
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
