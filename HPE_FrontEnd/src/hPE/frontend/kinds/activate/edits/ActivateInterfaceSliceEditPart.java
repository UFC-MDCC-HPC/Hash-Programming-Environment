package hPE.frontend.kinds.activate.edits;

import hPE.frontend.base.figures.InterfaceSliceFigure;
import hPE.frontend.kinds.activate.model.HActivateInterfaceSlice;
import hPE.frontend.kinds.base.edits.HasPortsInterfaceSliceEditPart;

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
	

