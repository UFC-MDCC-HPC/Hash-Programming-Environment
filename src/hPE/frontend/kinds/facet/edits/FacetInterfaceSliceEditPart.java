package hPE.frontend.kinds.facet.edits;

import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.base.edits.HasPortsInterfaceSliceEditPart;
import hPE.frontend.kinds.facet.FacetKindConfiguration;
import hPE.frontend.kinds.facet.figures.FacetInterfaceSliceFigure;
import hPE.frontend.kinds.facet.model.HFacetInterfaceSlice;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class FacetInterfaceSliceEditPart<ModelType extends HFacetInterfaceSlice, FigureType extends FacetInterfaceSliceFigure>
		extends HasPortsInterfaceSliceEditPart<ModelType, FigureType> {

	public FacetInterfaceSliceEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public List getModelSourceConnections() { List r = super.getModelSourceConnections();
	 * 
	 * HFacetInterfaceSlice s = (HFacetInterfaceSlice) this.getModel();
	 * 
	 * r.add("PortOwnership.".concat(s.toString()).concat(s.toString())); s.addPortOwner(s);
	 * 
	 * return r;
	 * 
	 * }
	 */
}
