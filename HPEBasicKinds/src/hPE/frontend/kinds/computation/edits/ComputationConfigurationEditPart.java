package hPE.frontend.kinds.computation.edits;

import hPE.frontend.kinds.activate.edits.ActivateConfigurationEditPart;
import hPE.frontend.kinds.computation.figures.ComputationConfigurationFigure;
import hPE.frontend.kinds.computation.model.HComputationComponent;


public class ComputationConfigurationEditPart<ModelType extends HComputationComponent,FigureType extends ComputationConfigurationFigure>               
                                    extends		ActivateConfigurationEditPart<ModelType,FigureType> {

	public ComputationConfigurationEditPart() {
		super();
	}

}
