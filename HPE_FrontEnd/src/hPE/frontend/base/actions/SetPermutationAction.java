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
import hPE.frontend.base.commands.FuseReplicatorCommand;
import hPE.frontend.base.commands.SetPermutationCommand;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

public class SetPermutationAction extends SelectionAction {

	private static final String
		SET_PERMUTATION_REQUEST = "Set Permutation";  //$NON-NLS-1$
	
	public static final String
	    SET_PERMUTATION = "Set Permutation";   //$NON-NLS-1$
	
	Request request;
	
	public SetPermutationAction(IWorkbenchPart part) {
		super(part);
		request = new Request(SET_PERMUTATION_REQUEST);
		setText(SET_PERMUTATION);
		setId(SET_PERMUTATION);
		setToolTipText(SET_PERMUTATION);
		setImageDescriptor(
		ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(getImageDescriptor());
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		if (getSelectedObjects().size()<2)
			return false;
		List parts = getSelectedObjects();
		if (parts.size() != 2) return false;
		EditPart partEnumerator = (EditPart) parts.get(0);
		EditPart partPermutation = (EditPart) parts.get(1);
		if (!(partEnumerator.getModel() instanceof HLinkToReplicator)) return false; 
		if (!(partPermutation.getModel() instanceof HEnumeratorComponent)) return false; 
		
		
		return true;
	}
	
	private Command getCommand() {
		List parts = getSelectedObjects();
		Command cc = new CompoundCommand();
		cc.setDebugLabel("Set Permutation");//$NON-NLS-1$

		EditPart partEnumerator = (EditPart) parts.get(0);
		EditPart partPermutation = (EditPart) parts.get(1);
		HLinkToReplicator r = (HLinkToReplicator) partEnumerator.getModel();
		HEnumeratorComponent c = (HEnumeratorComponent) partPermutation.getModel();
		
		SetPermutationCommand command = (SetPermutationCommand) partEnumerator.getCommand(request);
		
		command.setLinkToReplicator(r);
		command.setPermutation(c);
		
		return command;
		
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
