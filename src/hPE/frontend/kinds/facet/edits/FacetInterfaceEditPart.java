package hPE.frontend.kinds.facet.edits;

import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.base.edits.HasPortsInterfaceEditPart;
import hPE.frontend.kinds.facet.FacetKindConfiguration;
import hPE.frontend.kinds.facet.figures.FacetInterfaceFigure;
import hPE.frontend.kinds.facet.model.HFacetInterface;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class FacetInterfaceEditPart<ModelType extends HFacetInterface, FigureType extends FacetInterfaceFigure> extends
		HasPortsInterfaceEditPart<ModelType, FigureType> {

	public FacetInterfaceEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
