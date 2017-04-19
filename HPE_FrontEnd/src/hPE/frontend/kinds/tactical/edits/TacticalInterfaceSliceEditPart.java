package hPE.frontend.kinds.tactical.edits;

import hPE.frontend.kinds.base.edits.HasPortsInterfaceSliceEditPart;
import hPE.frontend.kinds.certifier.figures.CertifierInterfaceSliceFigure;
import hPE.frontend.kinds.certifier.model.HCertifierInterfaceSlice;

public class TacticalInterfaceSliceEditPart<ModelType extends HCertifierInterfaceSlice,
FigureType extends CertifierInterfaceSliceFigure> extends HasPortsInterfaceSliceEditPart<ModelType,FigureType> {

	public TacticalInterfaceSliceEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

/*	public List getModelSourceConnections() {
	     List r = super.getModelSourceConnections();	
		 	
	     HFacetInterfaceSlice s = (HFacetInterfaceSlice) this.getModel();
	     
	     r.add("PortOwnership.".concat(s.toString()).concat(s.toString()));
	     s.addPortOwner(s);
	     
	     return r;
	
	} */
}
