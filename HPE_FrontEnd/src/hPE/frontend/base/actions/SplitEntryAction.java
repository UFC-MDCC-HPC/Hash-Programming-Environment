package hPE.frontend.base.actions;

import hPE.HPEPlugin;
import hPE.frontend.base.commands.SetMultipleCommand;
import hPE.frontend.base.commands.SplitEntryCommand;
import hPE.frontend.base.interfaces.IElement;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.topology.model.HTopologyComponent;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;


public class SplitEntryAction extends SelectionAction {

	private static final String
		SPLIT_ENTRY_REQUEST = "Split unit";  //$NON-NLS-1$
	
	public static final String
	    SPLIT_ENTRY = "Split unit";  //$NON-NLS-1$
	
	Request request;
	
	public SplitEntryAction(IWorkbenchPart part) {
		super(part);
	    request = new Request(SPLIT_ENTRY_REQUEST);
	    setText("Split unit");
	    setId("Split unit");
	    setToolTipText("Split unit");
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
			if (!(part.getModel() instanceof HUnit)) return false;
			HUnit u = (HUnit) part.getModel();
			if (!u.isMultiple()) return false;
			//if (((HComponent)u.getConfiguration()).isTopConfiguration()) return false;
			
		}
	   
		return true;

	}
	
	private Command getCommand() {
		List parts = getSelectedObjects();

		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Split unit");//$NON-NLS-1$
		for (int i=0; i<parts.size(); i++){
			EditPart part = (EditPart) parts.get(i);
			cc.add(part.getCommand(request));
			
     		HUnit u = (HUnit) ((EditPart)parts.get(i)).getModel();		
  	        SplitEntryCommand c =  new SplitEntryCommand(u);  // part.getCommand(request);
			
		    cc.add(c);
		}
		
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
