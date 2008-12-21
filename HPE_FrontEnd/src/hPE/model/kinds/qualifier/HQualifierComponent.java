package hPE.model.kinds.qualifier;

import org.eclipse.emf.common.util.URI;

import hPE.model.base.HComponent;
import hPE.model.base.HUnit;
import hPE.model.interfaces.IComponent;
import hPE.model.interfaces.IPackageLocation;
import hPE.model.kinds.activate.computation.application.HApplicationUnit;
import hPE.model.kinds.base.HBaseKindComponent;

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
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HQualifierComponent) return true;
    	return false;
    }

    public String kindString() {
    	return "Qualifier";
    }    
    
}
