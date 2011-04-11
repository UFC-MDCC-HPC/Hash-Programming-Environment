package hPE.frontend.kinds.facet.edits;

import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.facet.FacetKindConfiguration;
import hPE.frontend.kinds.facet.figures.FacetComponentFigure;
import hPE.frontend.kinds.facet.model.HFacetComponent;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class FacetComponentEditPart<ModelType extends HFacetComponent, FigureType extends FacetComponentFigure> extends
		ComponentEditPart<ModelType, FigureType> {

	public FacetComponentEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
