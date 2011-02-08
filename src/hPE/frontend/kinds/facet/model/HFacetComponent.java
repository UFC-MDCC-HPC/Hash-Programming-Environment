package hPE.frontend.kinds.facet.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.facet.FacetKindConfiguration;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;

import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class HFacetComponent extends HBaseKindComponent {

	static final long serialVersionUID = 1668311650924947931L;

	public static final String KIND = "Facet";

	public HFacetComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
		HUnit new_unit = new HFacetUnit(null, this);
		return new_unit;
	}

	@Override
	public boolean accepts(IComponent c) {
		if (c instanceof HQualifierComponent)
			return super.accepts(c);
		if (c instanceof HFacetComponent)
			return true;
		return false;
	}

	@Override
	public String kindString() {
		return "Facet";
	}

}
