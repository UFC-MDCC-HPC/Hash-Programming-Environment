package hPE.frontend.kinds.certifier.edits;

import hPE.frontend.kinds.base.edits.HasPortsInterfaceSliceEditPart;
import hPE.frontend.kinds.certifier.figures.CertifierInterfaceSliceFigure;
import hPE.frontend.kinds.certifier.model.HCertifierInterfaceSlice;

public class CertifierInterfaceSliceEditPart<ModelType extends HCertifierInterfaceSlice,
FigureType extends CertifierInterfaceSliceFigure> extends HasPortsInterfaceSliceEditPart<ModelType,FigureType> {

	public CertifierInterfaceSliceEditPart() {
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
