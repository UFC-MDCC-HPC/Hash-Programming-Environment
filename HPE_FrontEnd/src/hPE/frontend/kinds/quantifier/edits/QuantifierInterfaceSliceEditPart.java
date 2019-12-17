package hPE.frontend.kinds.quantifier.edits;

import hPE.frontend.kinds.base.edits.HasPortsInterfaceSliceEditPart;
import hPE.frontend.kinds.quantifier.figures.QuantifierInterfaceSliceFigure;
import hPE.frontend.kinds.quantifier.model.HQuantifierInterfaceSlice;

public class QuantifierInterfaceSliceEditPart<ModelType extends HQuantifierInterfaceSlice,
FigureType extends QuantifierInterfaceSliceFigure> extends HasPortsInterfaceSliceEditPart<ModelType,FigureType> {

	public QuantifierInterfaceSliceEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

/*	public List getModelSourceConnections() {
	     List r = super.getModelSourceConnections();	
		 	
	     HQuantifierInterfaceSlice s = (HQuantifierInterfaceSlice) this.getModel();
	     
	     r.add("PortOwnership.".concat(s.toString()).concat(s.toString()));
	     s.addPortOwner(s);
	     
	     return r;
	
	} */
}
