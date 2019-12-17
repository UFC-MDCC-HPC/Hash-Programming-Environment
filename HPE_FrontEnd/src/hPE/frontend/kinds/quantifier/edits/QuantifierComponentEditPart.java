package hPE.frontend.kinds.quantifier.edits;

import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.kinds.quantifier.figures.QuantifierComponentFigure;
import hPE.frontend.kinds.quantifier.model.HQuantifierComponent;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

public class QuantifierComponentEditPart<ModelType extends HQuantifierComponent,
FigureType extends QuantifierComponentFigure> extends ComponentEditPart<ModelType,FigureType> {

	public QuantifierComponentEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {
		return new QuantifierComponentFigure();
	}

	protected void refreshVisuals() 
	{		
		super.refreshVisuals();
					
		ModelType component_ = (ModelType) getModel();
		FigureType component_figure = (FigureType) getFigure();
		
        component_figure.setName(component_figure.getName() + " = " + component_.getValue() + (component_.getComponentName().endsWith("Up") ? "\u2191" : "\u2193"));
        
        Label ff = (Label) component_figure.getToolTip();
        //String s = ff.getText();
        //String[] ss = s.trim().replace('.', ':').split(":");        
        //ff.setText(ss[ss.length-1]);
        String s = component_.getComponentName();
        String[] ss = s.trim().replace('.', ':').split(":");        
        ff.setText(ss[ss.length-1]);
        ff.setText(" " + s + " ");
	}

}
