package hPE.frontend.base.policies;


import hPE.frontend.base.edits.PortEditPart;
import hPE.frontend.base.edits.ProvidesPortEditPart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;


public class UnitFlowLayoutEditPolicy extends XYLayoutEditPolicy {

	public UnitFlowLayoutEditPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected Command createAddCommand(EditPart child, EditPart after) {
			return null;
	}

	protected Command createAddCommand(EditPart child, Object constraint) {
		// not used in this example
		
		if (child instanceof PortEditPart) {
		/*	IHProvidesPort sourcePort = (IHProvidesPort) child.getModel();
			IHProvidesPort targetPort = (IHProvidesPort) getHost().getModel();
			HInterface iContext = (HInterface) child.getParent().getModel();
			
    		return new PortBindingCommand(sourcePort,targetPort,iContext); */
			return null;
		}
		else
			return null;
	}
	
	
	protected Command createMoveChildCommand(EditPart child, EditPart after) {
		// TODO Auto-generated method stub
		return null;
	}

	protected Command getCreateCommand(CreateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	protected Command getDeleteDependantCommand(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
	 */
	protected EditPolicy createChildEditPolicy(EditPart child) {
		PointsResizableEditPolicy policy = new PointsResizableEditPolicy();
		
		if (child instanceof ProvidesPortEditPart)	policy.setResizeDirections(0);

		
		return policy;
	}  
	
	
	protected Command createChangeConstraintCommand(
			EditPart child, Object constraint) {
		
		return null;
	}

	
	
}
