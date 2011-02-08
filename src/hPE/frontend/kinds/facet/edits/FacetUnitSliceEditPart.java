package hPE.frontend.kinds.facet.edits;

import hPE.frontend.base.edits.UnitSliceEditPart;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.facet.FacetKindConfiguration;
import hPE.frontend.kinds.facet.figures.FacetUnitSliceFigure;
import hPE.frontend.kinds.facet.model.HFacetUnitSlice;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class FacetUnitSliceEditPart<ModelType extends HFacetUnitSlice, FigureType extends FacetUnitSliceFigure> extends
		UnitSliceEditPart<ModelType, FigureType> {

	public FacetUnitSliceEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
