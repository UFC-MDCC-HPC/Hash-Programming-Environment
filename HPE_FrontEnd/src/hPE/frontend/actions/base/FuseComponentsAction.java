package hPE.frontend.actions.base;

import hPE.HPEPlugin;
import hPE.frontend.commands.base.SupersedeCommand;
import hPE.model.base.HComponent;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

public class FuseComponentsAction extends SelectionAction {

	private static final String
		FUSE_COMPONENTS_REQUEST = "Fuse Components";  //$NON-NLS-1$
	
	public static final String
	    FUSE_COMPONENTS = "Fuse Components";   //$NON-NLS-1$
	
	Request request;
	
	public FuseComponentsAction(IWorkbenchPart part) {
		super(part);
		request = new Request(FUSE_COMPONENTS_REQUEST);
		setText(FUSE_COMPONENTS);
		setId(FUSE_COMPONENTS);
		setToolTipText(FUSE_COMPONENTS);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		
		List<HComponent> cs = new java.util.ArrayList<HComponent>();
		
		if (getSelectedObjects().size()<2)
			return false;
		List parts = getSelectedObjects();
		for (int i=0; i<parts.size(); i++){
			Object o = parts.get(i);
			if (!(o instanceof EditPart)) return false;
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HComponent)) return false;
			HComponent r = (HComponent) part.getModel();
			//if (((HComponent)r.getTopConfiguration()).getWhoItImplements() == r.getTopParentConfigurations().get(0)) return false;
	        HComponent topC = (HComponent) r.getTopConfiguration();
	        if (!topC.isAbstractConfiguration()) return false;
	        	        
		    cs.add(r);
			
		}	
      
		
		//TODO: CHECK IF THE COMPONENTS CAN BE FUSED ...
		HComponent c = (HComponent)cs.get(0);		
		for (int i=1;i<cs.size();i++) {
			HComponent c_ = (HComponent) cs.get(i);
			if (!c_.isEquivalentTo(c)) return false;
			if (c.getExposed() != c_.getExposed()) return false;
			if (!c.getName2().equals(c_.getName2())) return false;
	        // If they are parameters ...
	        if (c.isParameter() && c_.isParameter() && /*c.getSupplied() == null && c_.getSupplied() == null &&*/ 
	        		!c.getVariableName().equals(c_.getVariableName()))  return false;
	        
	        if (!HComponent.checkConsistencyOfUnitsInSuperseding(c_, c)) return false;
	        
	        if (!HComponent.checkConsistencyOfCardinalityInSuperseding(c_,c)) return false;
			
		}
		
		return true;
	}
	
	private Command getCommand() {
		List<EditPart> editparts = getSelectedObjects();
		List<HComponent> csfuse = new ArrayList<HComponent>();  
		
		for (EditPart part : editparts) {
			HComponent c = (HComponent) part.getModel();
			csfuse.add(c);
		}
				
		//FuseComponentsCommand c = new FuseComponentsCommand(csfuse);
		
		CompoundCommand cc = new CompoundCommand(); 
		
		HComponent source = csfuse.get(0);		
		for (int i=1; i<csfuse.size(); i++){
			HComponent target = csfuse.get(i);
		    SupersedeCommand c = new SupersedeCommand((HComponent)source, (HComponent)target);
		    cc.add(c);
		}
		
		
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
