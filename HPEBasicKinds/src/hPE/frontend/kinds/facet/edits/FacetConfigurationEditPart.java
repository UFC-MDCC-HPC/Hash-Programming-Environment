package hPE.frontend.kinds.facet.edits;

import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.facet.FacetKindConfiguration;
import hPE.frontend.kinds.facet.figures.FacetConfigurationFigure;
import hPE.frontend.kinds.facet.model.HFacetComponent;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class FacetConfigurationEditPart<ModelType extends HFacetComponent, FigureType extends FacetConfigurationFigure> extends
		ConfigurationEditPart<ModelType, FigureType> {

	public FacetConfigurationEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
