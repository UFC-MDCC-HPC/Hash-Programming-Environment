package hPE.frontend.kinds.qualifier.edits;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.kinds.computation.figures.ComputationComponentFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierComponentFigure;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;

public class QualifierComponentEditPart<ModelType extends HQualifierComponent,
FigureType extends QualifierComponentFigure> extends ComponentEditPart<ModelType,FigureType> {

	public QualifierComponentEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {
		return new QualifierComponentFigure();
	}
}
