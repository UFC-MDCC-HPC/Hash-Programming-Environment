package hPE.frontend.edits.kinds.data;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.edits.base.UnitEditPart;
import hPE.frontend.figures.kinds.data.DataUnitFigure;
import hPE.model.kinds.data.IHDataUnit;

public class DataUnitEditPart<ModelType extends IHDataUnit,FigureType extends DataUnitFigure> extends UnitEditPart<ModelType,FigureType> {

	public DataUnitEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new DataUnitFigure();
	}
}
