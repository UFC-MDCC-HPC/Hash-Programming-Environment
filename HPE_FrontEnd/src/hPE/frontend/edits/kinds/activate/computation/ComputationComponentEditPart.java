package hPE.frontend.edits.kinds.activate.computation;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.edits.base.ComponentEditPart;
import hPE.frontend.figures.kinds.activate.computation.ComputationComponentFigure;
import hPE.model.kinds.activate.computation.HComputationComponent;

public class ComputationComponentEditPart<ModelType extends HComputationComponent,
                                          FigureType extends ComputationComponentFigure> 
                  extends ComponentEditPart<ModelType,
                                            FigureType> {

	public ComputationComponentEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {
		return new ComputationComponentFigure();
	}
}
