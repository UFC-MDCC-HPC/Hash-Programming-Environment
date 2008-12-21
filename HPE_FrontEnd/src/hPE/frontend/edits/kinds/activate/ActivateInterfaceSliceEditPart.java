package hPE.frontend.edits.kinds.activate;

import hPE.frontend.edits.kinds.base.HasPortsInterfaceSliceEditPart;
import hPE.frontend.figures.base.InterfaceSliceFigure;
import hPE.model.kinds.activate.HActivateInterfaceSlice;

public class ActivateInterfaceSliceEditPart<ModelType extends HActivateInterfaceSlice, 
                                            FigureType extends InterfaceSliceFigure> 
                  extends HasPortsInterfaceSliceEditPart<ModelType,FigureType> {

	public ActivateInterfaceSliceEditPart() {
		super();
	}

	protected void refreshVisuals() {
		
		super.refreshVisuals();
		
  	    ModelType slice_abstraction = (ModelType) getModel();
  	    FigureType slice_abstraction_figure = (FigureType) getFigure();
  	    
        if (slice_abstraction.getNestingFactor() > 0)
            slice_abstraction_figure.setLabelText((new Integer(slice_abstraction.getNestingFactor())).toString());
        else
        	slice_abstraction_figure.setLabelText("");
		
	}
	
		
}
	

