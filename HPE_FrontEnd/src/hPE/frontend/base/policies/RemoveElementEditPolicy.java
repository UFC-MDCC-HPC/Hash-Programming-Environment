package hPE.frontend.base.policies;

import hPE.frontend.base.commands.RemoveComponentCommand;
import hPE.frontend.base.commands.RemoveUnitCommand;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.IHUnit;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;


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
		if (parent instanceof HComponent  && child instanceof HComponent) {
			return new RemoveComponentCommand((HComponent) child);
		}
		
		return super.createDeleteCommand(deleteRequest);
	}
	
}
