package hPE.frontend.kinds.synchronization.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.activate.model.HActivateComponent;
import hPE.frontend.kinds.binding.model.HBindingComponent;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.platform.model.HPlatformComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;

import org.eclipse.emf.common.util.URI;

public class HSynchronizationComponent extends HActivateComponent {

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
    	if (c instanceof HComputationComponent) return true;
    	if (c instanceof HDataComponent) return true;
    	if (c instanceof HPlatformComponent) return true;
    	if (c instanceof HEnvironmentComponent) return true;
    	if (c instanceof HBindingComponent) return true;
    	return super.accepts(c);
    }	

    public String kindString() {
    	return "Synchronizer";
    }    
    
}
