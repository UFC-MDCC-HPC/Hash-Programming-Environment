package hPE.frontend.kinds.application.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.HPEPlugin;

public class DeployApplicationAction extends SelectionAction {

	private static final String
		DEPLOY_APPLICATION_REQUEST = "Deploy Application";
	
	public static final String
        DEPLOY_APPLICATION = "Deploy Application";

	Request request;
	
	
	public DeployApplicationAction(IWorkbenchPart part) {
		
	   super(part);
	   
	   request = new Request(DEPLOY_APPLICATION_REQUEST);
	   setText(DEPLOY_APPLICATION);
	   setId(DEPLOY_APPLICATION);
	   setToolTipText(DEPLOY_APPLICATION);
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
			if (!(part.getModel() instanceof HApplicationComponent)) {
				return false;
			}
			HApplicationComponent app = (HApplicationComponent) part.getModel();
			if (app.getArchitecture() == null) return false;
               
		}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Deploy Application");//$NON-NLS-1$
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
