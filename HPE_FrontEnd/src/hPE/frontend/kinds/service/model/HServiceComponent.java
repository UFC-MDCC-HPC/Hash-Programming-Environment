package hPE.frontend.kinds.service.model;

import org.eclipse.emf.common.util.URI;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.frontend.kinds.application.model.HApplicationUnit;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

public class HServiceComponent extends HBaseKindComponent {

	static final long serialVersionUID = 1668311650924947931L;

	public static final String KIND = "Service";

	public HServiceComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
	}

	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HServiceUnit(null, this);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HApplicationComponent) return true;
    	return false;
    }

    public String kindString() {
    	return KIND;
    }    
    
}
