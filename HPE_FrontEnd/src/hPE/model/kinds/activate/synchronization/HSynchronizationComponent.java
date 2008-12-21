package hPE.model.kinds.activate.synchronization;

import org.eclipse.emf.common.util.URI;

import hPE.model.base.HUnit;
import hPE.model.interfaces.IComponent;
import hPE.model.interfaces.IPackageLocation;
import hPE.model.kinds.activate.HActivateConfiguration;
import hPE.model.kinds.activate.computation.application.HApplicationUnit;
import hPE.model.kinds.activate.synchronization.HSynchronizationComponent;
import hPE.model.kinds.data.HDataComponent;
import hPE.model.kinds.qualifier.HQualifierComponent;
import hPE.model.kinds.qualifier.architecture.HArchitectureComponent;
import hPE.model.kinds.qualifier.environment.HEnvironmentComponent;

public class HSynchronizationComponent extends HActivateConfiguration {

	static final long serialVersionUID = 2293123178001029534L;

	public static final String KIND = "Synchronizer";

	public HSynchronizationComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HSynchronizationUnit(null, this);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HQualifierComponent) return true;
    	if (c instanceof HSynchronizationComponent) return true;
    	if (c instanceof HDataComponent) return true;
    	if (c instanceof HArchitectureComponent) return true;
    	if (c instanceof HEnvironmentComponent) return true;
    	return false;
    }	

    public String kindString() {
    	return "Synchronizer";
    }    
    
}
