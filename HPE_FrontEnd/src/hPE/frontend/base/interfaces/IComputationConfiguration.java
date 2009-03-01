package hPE.frontend.base.interfaces;

import java.util.Collection;
import java.util.List;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HReplicator;

public interface IComputationConfiguration extends IConfiguration {

	public Collection getComponents();
		
	public Collection getInterfaces();
	
	public List<HReplicator> getReplicators();

	public List<HComponent> getInnerComponents();
	
}
