package hPE.frontend.edits.kinds.data;

import hPE.frontend.edits.kinds.base.HasPortsInterfaceSliceEditPart;
import hPE.frontend.figures.kinds.data.DataInterfaceSliceFigure;
import hPE.model.kinds.data.HDataInterfaceSlice;

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
