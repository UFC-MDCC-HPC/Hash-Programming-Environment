package hPE.frontend.edits.policies.kinds.activate;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.commands.kinds.activate.CombineActionsCommand;
import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HCombinatorAction;
import hPE.model.protocol.kinds.activate.HParAction;
import hPE.model.protocol.kinds.activate.HSeqAction;

public class CombineActionsEditPolicy extends ComponentEditPolicy {

	public CombineActionsEditPolicy() {
		super();
		
	}
	
private static final String
      PAR_ACTIONS_REQUEST = "Par Actions",  //$NON-NLS-1$
      SEQ_ACTIONS_REQUEST = "Seq Actions";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HAction action = (HAction) getHost().getModel();
	Object parent_action = getHost().getParent().getModel();
	
	if (PAR_ACTIONS_REQUEST.equals(request.getType()))
		return new CombineActionsCommand((HCombinatorAction) parent_action,action);
	else if (SEQ_ACTIONS_REQUEST.equals(request.getType()))
		return new CombineActionsCommand((HCombinatorAction) parent_action,action);
	else 
		return super.getCommand(request);
	
}


}
