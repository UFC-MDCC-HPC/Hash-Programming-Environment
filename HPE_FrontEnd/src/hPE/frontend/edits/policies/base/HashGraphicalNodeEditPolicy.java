package hPE.frontend.edits.policies.base;

import hPE.frontend.commands.base.GenericNodeCommand;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

public class HashGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	public HashGraphicalNodeEditPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	 protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		GenericNodeCommand cmd = (GenericNodeCommand) request.getStartCommand();
		cmd.setTarget(getHost().getModel(), request.getLocation());
		if (cmd.canComplete())	
			return cmd;
		else 
			return null;
		 
	} 
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		Object source = getHost().getModel();
		GenericNodeCommand cmd = new GenericNodeCommand();
		cmd.setSource(source);
		request.setStartCommand(cmd);
		return cmd;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		return null;
	} 
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		return null;
	} 

}
