package hPE.frontend.kinds.domain.edits;

import hPE.frontend.kinds.base.edits.HasPortsInterfaceSliceEditPart;
import hPE.frontend.kinds.domain.figures.DomainInterfaceSliceFigure;
import hPE.frontend.kinds.domain.model.HDomainInterfaceSlice;

public class DomainInterfaceSliceEditPart<ModelType extends HDomainInterfaceSlice,
FigureType extends DomainInterfaceSliceFigure> extends HasPortsInterfaceSliceEditPart<ModelType,FigureType> {

	public DomainInterfaceSliceEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

/*	public List getModelSourceConnections() {
	     List r = super.getModelSourceConnections();	
		 	
	     HDomainInterfaceSlice s = (HDomainInterfaceSlice) this.getModel();
	     
	     r.add("PortOwnership.".concat(s.toString()).concat(s.toString()));
	     s.addPortOwner(s);
	     
	     return r;
	
	} */
}
