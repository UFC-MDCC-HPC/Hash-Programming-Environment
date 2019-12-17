package hPE.frontend.kinds.topology.model;

import org.eclipse.emf.common.util.URI;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.frontend.kinds.application.model.HApplicationUnit;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.quantifier.model.HQuantifierComponent;

public class HTopologyComponent extends HBaseKindComponent {

	static final long serialVersionUID = 1668311650924947931L;

	public static final String KIND = "Topology";

	public HTopologyComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
	}

	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HTopologyUnit(null, this);
	     new_unit.setMultiple(true);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HTopologyComponent) return true;
    	if (c instanceof HQualifierComponent) return true;
    	if (c instanceof HQuantifierComponent) return true;
   	return super.accepts(c);
    }

    public String kindString() {
    	return KIND;
    }    
    
}
