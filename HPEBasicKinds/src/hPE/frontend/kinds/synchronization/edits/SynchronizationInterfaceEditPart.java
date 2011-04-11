package hPE.frontend.kinds.synchronization.edits;

import hPE.frontend.kinds.activate.edits.ActivateInterfaceEditPart;
import hPE.frontend.kinds.activate.policies.EditProtocolEditPolicy;
import hPE.frontend.kinds.synchronization.figures.SynchronizationInterfaceFigure;
import hPE.frontend.kinds.synchronization.model.HSynchronizationInterface;

public class SynchronizationInterfaceEditPart<ModelType extends HSynchronizationInterface,
FigureType extends SynchronizationInterfaceFigure> extends ActivateInterfaceEditPart<ModelType,FigureType> {

	public SynchronizationInterfaceEditPart() {
		super();
	}

	protected void createEditPolicies() {
		
		   super.createEditPolicies();
		   
	       this.installEditPolicy("Edit Protocol", new EditProtocolEditPolicy());
		
		}
}
