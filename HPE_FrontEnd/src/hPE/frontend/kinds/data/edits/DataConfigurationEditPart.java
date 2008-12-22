package hPE.frontend.kinds.data.edits;

import org.eclipse.draw2d.IFigure;

import java.util.List;

import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.kinds.data.figures.DataConfigurationFigure;
import hPE.frontend.kinds.data.model.HDataComponent;



public class DataConfigurationEditPart<ModelType extends HDataComponent,
                                       FigureType extends DataConfigurationFigure>          
             extends ConfigurationEditPart<ModelType, FigureType> {

	public DataConfigurationEditPart() {
		super();
	}

	protected IFigure createFigure() {
		
		return new DataConfigurationFigure();
		
	}
	
	public List getModelChildren() {
		return super.getModelChildren();
	}
}
