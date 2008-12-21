package hPE.model.kinds.activate.computation.application;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;

import hPE.model.base.HComponent;
import hPE.model.base.HUnit;
import hPE.model.interfaces.IComponent;
import hPE.model.interfaces.IPackageLocation;
import hPE.model.kinds.activate.computation.HComputationComponent;
import hPE.model.kinds.activate.computation.HComputationUnit;
import hPE.model.kinds.activate.synchronization.HSynchronizationComponent;
import hPE.model.kinds.data.HDataComponent;
import hPE.model.kinds.qualifier.HQualifierComponent;
import hPE.model.kinds.qualifier.architecture.HArchitectureComponent;
import hPE.model.kinds.qualifier.environment.HEnvironmentComponent;

public class HApplicationComponent extends HComputationComponent {

	static final long serialVersionUID = 1;

	public static final String KIND = "Application";
	
	public HApplicationComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HApplicationUnit(null, this);
	     return new_unit;
	}

    public boolean accepts(IComponent c) {
    	if (c instanceof HQualifierComponent) return true;
    	if (c instanceof HDataComponent) return true;
    	if (c instanceof HArchitectureComponent) return true;
    	if (c instanceof HEnvironmentComponent) return true;
    	if (c instanceof HSynchronizationComponent) return true;
    	if (c instanceof HComputationComponent) return true;
    	return false;
    }
    
    public String kindString() {
    	return "Application";
    }
    
    public HArchitectureComponent getArchitecture() {
    	Iterator<HComponent> cs = getComponents().iterator();
    	while (cs.hasNext()) {
    		HComponent c = cs.next();
    		if (c instanceof HArchitectureComponent) return (HArchitectureComponent) c;
    	}
    	
    	return null;
    }
    
    public HEnvironmentComponent getEnvironment() {
    	Iterator<HComponent> cs = getComponents().iterator();
    	while (cs.hasNext()) {
    		HComponent c = cs.next();
    		if (c instanceof HEnvironmentComponent) return (HEnvironmentComponent) c;
    	}
    	
    	return null;
    }
    
    
}
