package hPE.frontend.kinds.activate.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.kinds.base.model.HHasPortsConfiguration;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.platform.model.HPlatformComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;
import hPE.frontend.kinds.topology.model.HTopologyComponent;

import org.eclipse.emf.common.util.URI;

public abstract class HActivateComponent extends HHasPortsConfiguration {

	static final long serialVersionUID = 1;
	
	public HActivateComponent(String name,
			IPackageLocation location, URI uri) {
		super(name, location,uri);
	}


	public boolean accepts(IComponent c) 
	{
		   	if (c instanceof HTopologyComponent) return true;
		   	return super.accepts(c);
	}
    

	
}
