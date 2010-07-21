package hPE.frontend.kinds.domain.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.facet.model.HFacetComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;

import org.eclipse.emf.common.util.URI;

public class HDomainComponent extends HBaseKindComponent {

	static final long serialVersionUID = 1668311650924947931L;

	public static final String KIND = "Domain";

	public HDomainComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HDomainUnit(null, this);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HFacetComponent) return true;
    	if (c instanceof HQualifierComponent) return true;
    	return false;
    }

    public String kindString() {
    	return "Domain";
    }    
    
}
