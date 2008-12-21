package hPE.frontend.edits.kinds.activate.computation;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.edits.base.EntryEditPart;
import hPE.frontend.figures.base.EntryFigure;
import hPE.frontend.figures.kinds.activate.computation.ComputationEntryFigure;

import hPE.model.kinds.activate.computation.HComputationUnit;
;

public class ComputationEntryEditPart<ModelType extends HComputationUnit,FigureType extends ComputationEntryFigure> extends EntryEditPart<ModelType,FigureType> {

	public ComputationEntryEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new ComputationEntryFigure();
	}
}
