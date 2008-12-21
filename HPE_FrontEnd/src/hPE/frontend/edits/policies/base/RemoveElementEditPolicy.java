package hPE.frontend.edits.policies.base;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import hPE.frontend.commands.base.RemoveComponentCommand;
import hPE.frontend.commands.base.RemoveReplicatorCommand;
import hPE.frontend.commands.base.RemoveUnitCommand;
import hPE.model.base.HComponent;
import hPE.model.base.HReplicator;
import hPE.model.base.IHUnit;


public class RemoveElementEditPolicy extends ComponentEditPolicy {

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		Object parent = getHost().getParent().getModel();
		Object child = getHost().getModel();
		if (parent instanceof HComponent  && child instanceof IHUnit) {
			return new RemoveUnitCommand((IHUnit) child);
		}
		if (parent instanceof HComponent  && child instanceof HReplicator) {
			return new RemoveReplicatorCommand((HReplicator) child);
		}
		if (parent instanceof HComponent  && child instanceof HComponent) {
			return new RemoveComponentCommand((HComponent) child);
		}
		
		return super.createDeleteCommand(deleteRequest);
	}
	
}
