package hPE.frontend.kinds.data.edits;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.edits.UnitEditPart;
import hPE.frontend.kinds.data.figures.DataUnitFigure;
import hPE.frontend.kinds.data.model.IHDataUnit;

public class DataUnitEditPart<ModelType extends IHDataUnit,FigureType extends DataUnitFigure> extends UnitEditPart<ModelType,FigureType> {

	public DataUnitEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new DataUnitFigure();
	}
}
