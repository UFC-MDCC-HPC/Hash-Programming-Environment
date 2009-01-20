package hPE.frontend.base.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.base.edits.PortEditPart;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HPrimUnitStub;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHasInterface;
import hPE.HPEPlugin;

public class ShowInterfaceAction extends SelectionAction {

	private static final String
		SHOW_INTERFACE_REQUEST = "Show Interface",
		HIDE_INTERFACE_REQUEST = "Hide Interface";  //$NON-NLS-1$
	
	public static final String
	    SHOW_INTERFACE = "Show Interface",
	    HIDE_INTERFACE = "Hide Interface";  //$NON-NLS-1$
	
	Request request;
	boolean show;
	
	public ShowInterfaceAction(IWorkbenchPart part, boolean show) {
		super(part);
		if (show) {
			   request = new Request(SHOW_INTERFACE_REQUEST);
			   setText("Show Interface");
			   setId("Show Interface");
			   setToolTipText("Show Interface");
			   setImageDescriptor(
			   ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle16.gif")); //$NON-NLS-1$
			   setHoverImageDescriptor(getImageDescriptor());
		} else {
			   request = new Request(HIDE_INTERFACE_REQUEST);
			   setText("Hide Interface");
			   setId("Hide Interface");
			   setToolTipText("Hide Interface");
			   setImageDescriptor(
			   ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle16.gif")); //$NON-NLS-1$
			   setHoverImageDescriptor(getImageDescriptor());
		}
		
		this.show = show;
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
			if (part instanceof PortEditPart) return false;
			if (!(part.getModel() instanceof IHasInterface)) return false;
            IHasInterface x = (IHasInterface) part.getModel();
            if (x instanceof IHPrimUnit) {
            	IHPrimUnit u = (IHPrimUnit) x;
    			
            	for (HBinding b : u.getBindings()) {
                	if (u.isEntry() && u.getBinding() != null &&
                    		b.getPort() instanceof HPrimUnitStub && 
                    		!(u instanceof HPrimUnitStub)) return false;
            	}
            	
            }
            
            if (show) {  
                if (x.getInterface() == null || x.visibleInterface()) return false;
            }
            else {
                if (x.getInterface() == null || !x.visibleInterface()) return false;
            }
               
		}
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Show/Hide interface");//$NON-NLS-1$
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
