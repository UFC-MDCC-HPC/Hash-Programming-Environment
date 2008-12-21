package hPE.frontend.edits.kinds.activate.synchronization;

import hPE.frontend.edits.kinds.activate.ActivateInterfaceEditPart;
import hPE.frontend.edits.policies.kinds.activate.EditProtocolEditPolicy;
import hPE.frontend.figures.kinds.activate.synchronization.SynchronizationInterfaceFigure;
import hPE.model.kinds.activate.synchronization.HSynchronizationInterface;

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
