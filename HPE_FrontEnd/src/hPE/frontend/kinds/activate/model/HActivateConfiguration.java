package hPE.frontend.kinds.activate.model;

import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.kinds.base.model.HHasPortsConfiguration;

import org.eclipse.emf.common.util.URI;

public abstract class HActivateConfiguration extends HHasPortsConfiguration {

	static final long serialVersionUID = 1;
	
	public HActivateConfiguration(String name,
			IPackageLocation location, URI uri) {
		super(name, location,uri);
	}


    

	
}
