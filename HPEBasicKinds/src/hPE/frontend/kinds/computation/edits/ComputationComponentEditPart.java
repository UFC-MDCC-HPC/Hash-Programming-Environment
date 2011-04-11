package hPE.frontend.kinds.computation.edits;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.kinds.computation.figures.ComputationComponentFigure;
import hPE.frontend.kinds.computation.model.HComputationComponent;

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
