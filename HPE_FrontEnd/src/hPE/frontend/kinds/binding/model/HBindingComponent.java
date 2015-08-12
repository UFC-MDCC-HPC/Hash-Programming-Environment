package hPE.frontend.kinds.binding.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.facet.model.HFacetComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;

import org.eclipse.emf.common.util.URI;

public class HBindingComponent extends HBaseKindComponent {

	static final long serialVersionUID = 1668311650924947931L;

	public static final String KIND = "Binding";

	public HBindingComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HBindingUnit(null, this);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) 
    {
    	if (c instanceof HBindingComponent) return true;
    	if (c instanceof HQualifierComponent) return true;
    	return super.accepts(c);
    }

    public String kindString() {
    	return KIND;
    }    
    
}
