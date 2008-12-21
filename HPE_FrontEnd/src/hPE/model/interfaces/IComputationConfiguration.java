package hPE.model.interfaces;

import java.util.Collection;
import java.util.List;

import hPE.model.base.HReplicator;

public interface IComputationConfiguration extends IConfiguration {

	public Collection getComponents();
		
	public Collection getInterfaces();
	
	public List<HReplicator> getReplicators();
	
}
