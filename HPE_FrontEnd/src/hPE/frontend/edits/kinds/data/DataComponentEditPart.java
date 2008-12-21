package hPE.frontend.edits.kinds.data;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.edits.base.ComponentEditPart;
import hPE.frontend.figures.kinds.data.DataComponentFigure;
import hPE.model.kinds.data.HDataComponent;

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
