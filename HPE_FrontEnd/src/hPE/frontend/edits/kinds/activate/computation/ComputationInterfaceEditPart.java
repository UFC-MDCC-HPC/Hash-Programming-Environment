package hPE.frontend.edits.kinds.activate.computation;

import hPE.frontend.edits.kinds.activate.ActivateInterfaceEditPart;
import hPE.frontend.figures.kinds.activate.computation.ComputationInterfaceFigure;
import hPE.model.kinds.activate.computation.HComputationInterface;

public class ComputationInterfaceEditPart<ModelType extends HComputationInterface, 
                                          FigureType extends ComputationInterfaceFigure> 
               extends ActivateInterfaceEditPart<ModelType, FigureType> {

	public ComputationInterfaceEditPart() {
		super();
	}

}
