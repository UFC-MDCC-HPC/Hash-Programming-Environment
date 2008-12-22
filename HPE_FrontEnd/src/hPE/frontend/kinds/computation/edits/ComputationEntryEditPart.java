package hPE.frontend.kinds.computation.edits;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.edits.EntryEditPart;
import hPE.frontend.base.figures.EntryFigure;
import hPE.frontend.kinds.computation.figures.ComputationEntryFigure;
import hPE.frontend.kinds.computation.model.HComputationUnit;

;

public class ComputationEntryEditPart<ModelType extends HComputationUnit,FigureType extends ComputationEntryFigure> extends EntryEditPart<ModelType,FigureType> {

	public ComputationEntryEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new ComputationEntryFigure();
	}
}
