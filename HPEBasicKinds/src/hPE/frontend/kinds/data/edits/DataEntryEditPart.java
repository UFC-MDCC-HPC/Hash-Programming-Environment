package hPE.frontend.kinds.data.edits;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.edits.EntryEditPart;
import hPE.frontend.kinds.data.figures.DataEntryFigure;
import hPE.frontend.kinds.data.model.HDataUnit;

public class DataEntryEditPart<ModelType extends HDataUnit,FigureType extends DataEntryFigure> extends EntryEditPart<ModelType,FigureType> {

	public DataEntryEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new DataEntryFigure();
	}
}
