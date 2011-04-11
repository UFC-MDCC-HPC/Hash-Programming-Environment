package hPE.frontend.kinds.environment.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;
import hPE.frontend.kinds.facet.model.HFacetComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;

import org.eclipse.emf.common.util.URI;

public class HEnvironmentComponent extends HQualifierComponent {

	static final long serialVersionUID = -6791198852352754920L;

	public static final String KIND = "Environment";

	public HEnvironmentComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
		HUnit new_unit = new HEnvironmentUnit(null, this);
		return new_unit;
	}

	@Override
	public boolean accepts(IComponent c) {
		if (c instanceof HFacetComponent) return true;
		if (c instanceof HQualifierComponent) return true;
		if (c instanceof HEnvironmentComponent) return true;
		if (c instanceof HEnumeratorComponent) return true;
		return super.accepts(c);
	}

	@Override
	public String kindString() {
		return "Environment";
	}

}
