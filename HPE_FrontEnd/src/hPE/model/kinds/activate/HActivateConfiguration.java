package hPE.model.kinds.activate;

import hPE.model.interfaces.IPackageLocation;
import hPE.model.kinds.base.HHasPortsConfiguration;

import org.eclipse.emf.common.util.URI;

public abstract class HActivateConfiguration extends HHasPortsConfiguration {

	static final long serialVersionUID = 1;
	
	public HActivateConfiguration(String name,
			IPackageLocation location, URI uri) {
		super(name, location,uri);
	}


    

	
}
