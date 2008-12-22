package hPE.frontend.kinds.computation.edits;

import hPE.frontend.kinds.activate.edits.ActivateInterfaceEditPart;
import hPE.frontend.kinds.computation.figures.ComputationInterfaceFigure;
import hPE.frontend.kinds.computation.model.HComputationInterface;

public class ComputationInterfaceEditPart<ModelType extends HComputationInterface, 
                                          FigureType extends ComputationInterfaceFigure> 
               extends ActivateInterfaceEditPart<ModelType, FigureType> {

	public ComputationInterfaceEditPart() {
		super();
	}

}
