package hPE.frontend.kinds.data.model;

import org.eclipse.emf.common.util.URI;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.architecture.model.HArchitectureComponent;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.base.model.HHasPortsConfiguration;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;

public class HDataComponent extends HHasPortsConfiguration {

	static final long serialVersionUID = -3656926440084994312L;

	public static final String KIND = "Data";

	public HDataComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
	}

	public HUnit createUnit() {
	     HUnit new_unit = new HDataUnit(null, this);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HQualifierComponent) return true;
    	if (c instanceof HDataComponent) return true;
    	if (c instanceof HEnvironmentComponent) return true;
    	if (c instanceof HArchitectureComponent) return true;
    	if (c instanceof HEnumeratorComponent) return true;
    	return super.accepts(c);
    }	
	
    public String kindString() {
    	return "Data Structure";
    }
}
