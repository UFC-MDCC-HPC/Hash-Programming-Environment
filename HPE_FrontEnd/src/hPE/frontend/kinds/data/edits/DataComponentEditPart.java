package hPE.frontend.kinds.data.edits;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.kinds.data.figures.DataComponentFigure;
import hPE.frontend.kinds.data.model.HDataComponent;

public class DataComponentEditPart<ComponentType extends HDataComponent,
                                   ComponentFigureType extends DataComponentFigure > 
                extends ComponentEditPart<ComponentType,
                                          ComponentFigureType> {

	public DataComponentEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new DataComponentFigure();
	}
	
}
