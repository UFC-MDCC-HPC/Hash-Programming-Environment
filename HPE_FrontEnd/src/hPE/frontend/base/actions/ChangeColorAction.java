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
import hPE.frontend.base.commands.ChangeColorCommand;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.IHasColor;

public class ChangeColorAction extends SelectionAction {

	ColorDialog colorDialog;
	
	private static final String
		CHANGE_COLOR_REQUEST = "Change Color";  //$NON-NLS-1$
	
	public static final String
	    CHANGE_COLOR = "Change Color";   //$NON-NLS-1$
	
	Request request;
	
	public ChangeColorAction(IWorkbenchPart part, ColorDialog colorDialog) {
		super(part);
		request = new Request(CHANGE_COLOR_REQUEST);
		setText(CHANGE_COLOR);
		setId(CHANGE_COLOR);
		setToolTipText(CHANGE_COLOR);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
		this.colorDialog = colorDialog;
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
			if (!(part.getModel() instanceof IHasColor)) return false;
			if ((part.getModel() instanceof HInterface)) {
				if (!((HInterface)part.getModel()).isEditable()) return false;
			}
			if ((part.getModel() instanceof HComponent)) {
				if (!((IComponent)part.getModel()).isTopConfiguration()) return false;
			}
		}	
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("change color");//$NON-NLS-1$
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			ChangeColorCommand c = (ChangeColorCommand) part.getCommand(request); 
			c.setDialog(colorDialog);
			cc.add(c);
		}
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
