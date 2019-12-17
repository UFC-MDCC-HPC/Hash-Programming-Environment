package hPE.frontend.kinds.computation.model;

import org.eclipse.emf.common.util.URI;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.activate.model.HActivateComponent;
import hPE.frontend.kinds.certifier.model.HCertifierComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.platform.model.HPlatformComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.quantifier.model.HQuantifierComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;

public class HComputationComponent extends HActivateComponent {

	static final long serialVersionUID = -673692041250487494L;
	
	public static final String KIND = "Computation";
	
	
	public HComputationComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	public HUnit createUnit() {
	     HUnit new_unit = new HComputationUnit(null, this);
	     return new_unit;
	}
	
   public boolean accepts(IComponent c) {
	   	if (c instanceof HQualifierComponent) return true;
    	if (c instanceof HQuantifierComponent) return true;
	   	if (c instanceof HDataComponent) return true;
	   	if (c instanceof HPlatformComponent) return true;
	   	if (c instanceof HEnvironmentComponent) return true;
	   	if (c instanceof HSynchronizationComponent) return true;
	   	if (c instanceof HComputationComponent) return true;
	   	if (c instanceof HCertifierComponent) return true;
	   	return super.accepts(c);
   }
   
   public String kindString() {
   	return "Computation";    	
   }
}
