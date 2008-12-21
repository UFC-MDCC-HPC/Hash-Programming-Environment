package hPE.frontend.edits.kinds.activate.computation.application;

import hPE.frontend.edits.kinds.activate.computation.ComputationConfigurationEditPart;
import hPE.frontend.figures.kinds.activate.computation.application.ApplicationConfigurationFigure;
import hPE.model.kinds.activate.computation.application.HApplicationComponent;

public class ApplicationConfigurationEditPart<ModelType extends HApplicationComponent,
FigureType extends ApplicationConfigurationFigure> extends ComputationConfigurationEditPart<ModelType,FigureType> {

	public ApplicationConfigurationEditPart() {
		super();

	}

	protected void createEditPolicies() {
		super.createEditPolicies();
		
	}
	
}
