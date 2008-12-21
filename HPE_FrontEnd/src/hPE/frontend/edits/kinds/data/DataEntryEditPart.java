package hPE.frontend.edits.kinds.data;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.edits.base.EntryEditPart;
import hPE.frontend.figures.kinds.data.DataEntryFigure;
import hPE.model.kinds.data.HDataUnit;

public class DataEntryEditPart<ModelType extends HDataUnit,FigureType extends DataEntryFigure> extends EntryEditPart<ModelType,FigureType> {

	public DataEntryEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new DataEntryFigure();
	}
}
