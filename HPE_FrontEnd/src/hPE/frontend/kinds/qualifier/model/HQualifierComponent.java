package hPE.frontend.kinds.qualifier.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;
import hPE.frontend.kinds.facet.model.HFacetComponent;

import org.eclipse.emf.common.util.URI;

public class HQualifierComponent extends HBaseKindComponent {

	static final long serialVersionUID = 1668311650924947931L;

	public static final String KIND = "Qualifier";

	public HQualifierComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
		HUnit new_unit = new HQualifierUnit(null, this);
		return new_unit;
	}

	@Override
	public boolean accepts(IComponent c) {
		if (c instanceof HQualifierComponent) return true;
		if (c instanceof HEnumeratorComponent) return true;
		if (c instanceof HFacetComponent) return false;
		return super.accepts(c);
	}

	@Override
	public String kindString() {
		return "Qualifier";
	}

}
