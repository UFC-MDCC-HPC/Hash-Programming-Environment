package hPE.frontend.base.interfaces;

import java.util.Collection;


public interface IReplicator {

	public IConfiguration getConfiguration();
	
	public int getFactor();
	
	public String getName2();
	
	public Collection replicatedItems();
}
