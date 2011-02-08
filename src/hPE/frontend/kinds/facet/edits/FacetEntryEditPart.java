package hPE.frontend.kinds.facet.edits;

import hPE.frontend.base.edits.EntryEditPart;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.facet.FacetKindConfiguration;
import hPE.frontend.kinds.facet.figures.FacetEntryFigure;
import hPE.frontend.kinds.facet.model.HFacetUnit;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class FacetEntryEditPart<ModelType extends HFacetUnit, FigureType extends FacetEntryFigure> extends
		EntryEditPart<ModelType, FigureType> {

	public FacetEntryEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
