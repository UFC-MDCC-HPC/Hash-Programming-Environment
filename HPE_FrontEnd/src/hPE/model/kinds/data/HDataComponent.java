package hPE.model.kinds.data;

import org.eclipse.emf.common.util.URI;

import hPE.model.base.HComponent;
import hPE.model.base.HUnit;
import hPE.model.interfaces.IComponent;
import hPE.model.interfaces.IPackageLocation;
import hPE.model.kinds.activate.synchronization.HSynchronizationComponent;
import hPE.model.kinds.base.HBaseKindComponent;
import hPE.model.kinds.base.HHasPortsConfiguration;
import hPE.model.kinds.qualifier.HQualifierComponent;
import hPE.model.kinds.qualifier.architecture.HArchitectureComponent;
import hPE.model.kinds.qualifier.environment.HEnvironmentComponent;

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
    	return false;
    }	
	
    public String kindString() {
    	return "Data Structure";
    }
}
