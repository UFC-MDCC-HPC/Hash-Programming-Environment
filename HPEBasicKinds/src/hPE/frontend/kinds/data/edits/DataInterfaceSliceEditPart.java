package hPE.frontend.kinds.data.edits;

import hPE.frontend.kinds.base.edits.HasPortsInterfaceSliceEditPart;
import hPE.frontend.kinds.data.figures.DataInterfaceSliceFigure;
import hPE.frontend.kinds.data.model.HDataInterfaceSlice;

public class DataInterfaceSliceEditPart<ModelType extends HDataInterfaceSlice,
                                        FigureType extends DataInterfaceSliceFigure> extends 
                           HasPortsInterfaceSliceEditPart<ModelType,FigureType> {

	public DataInterfaceSliceEditPart() {
		super();
	}
	
/*	public List getModelSourceConnections() {
	     List r = super.getModelSourceConnections();	
		 
	     HDataInterfaceSlice s = (HDataInterfaceSlice) this.getModel();
	     
	     r.add("PortOwnership.".concat(s.toString()).concat(s.toString()));
	     s.addPortOwner(s);
	     
	     return r;
	
	}
*/
}
