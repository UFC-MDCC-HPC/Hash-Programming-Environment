package hPE.frontend.kinds.facet.edits;

import hPE.frontend.base.edits.UnitEditPart;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.facet.FacetKindConfiguration;
import hPE.frontend.kinds.facet.figures.FacetUnitFigure;
import hPE.frontend.kinds.facet.model.HFacetUnit;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class FacetUnitEditPart<ModelType extends HFacetUnit, FigureType extends FacetUnitFigure> extends
		UnitEditPart<ModelType, FigureType> {

	public FacetUnitEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
