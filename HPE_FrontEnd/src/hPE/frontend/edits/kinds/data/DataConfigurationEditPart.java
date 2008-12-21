package hPE.frontend.edits.kinds.data;

import org.eclipse.draw2d.IFigure;

import java.util.List;

import hPE.frontend.edits.base.ConfigurationEditPart;
import hPE.frontend.figures.kinds.data.DataConfigurationFigure;

import hPE.model.kinds.data.HDataComponent;


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
