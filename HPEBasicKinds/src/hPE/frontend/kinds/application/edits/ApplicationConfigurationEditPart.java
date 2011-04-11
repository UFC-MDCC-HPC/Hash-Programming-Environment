package hPE.frontend.kinds.application.edits;

import hPE.frontend.kinds.application.figures.ApplicationConfigurationFigure;
import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.frontend.kinds.computation.edits.ComputationConfigurationEditPart;

public class ApplicationConfigurationEditPart<ModelType extends HApplicationComponent,
FigureType extends ApplicationConfigurationFigure> extends ComputationConfigurationEditPart<ModelType,FigureType> {

	public ApplicationConfigurationEditPart() {
		super();

	}

	protected void createEditPolicies() {
		super.createEditPolicies();
		
	}
	
}
