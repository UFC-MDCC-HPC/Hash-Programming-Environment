package hPE.frontend.kinds.activate.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.kinds.activate.commands.CombineActionsCommand;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;
import hPE.frontend.kinds.activate.model.protocol.HParAction;
import hPE.frontend.kinds.activate.model.protocol.HSeqAction;

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
