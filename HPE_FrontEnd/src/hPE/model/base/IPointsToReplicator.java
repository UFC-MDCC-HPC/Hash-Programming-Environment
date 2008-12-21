package hPE.model.base;

import java.util.List;

import hPE.model.exceptions.base.HPEUnmatchingEnumeratorsException;
import hPE.model.interfaces.IConfiguration;
import hPE.model.interfaces.IReplicator;

public interface IPointsToReplicator {

	public List<HReplicator> getReplicators();

	/**
	 */
	public void setReplicator(HReplicator which_replicator) 
	      throws HPEUnmatchingEnumeratorsException;
	
	public void setReplicator(HReplicator which_replicator, boolean permament)
	      throws HPEUnmatchingEnumeratorsException;
	
	public List<HLinkToReplicator> getLinksToVisibleReplicators();
	
	public List<HLinkToReplicator> getLinksToReplicators();
	/**
	 */
	public void unSetReplicator(HReplicator which_replicator);
	
	public IConfiguration getConfiguration();
	
	public HReplicator getReplicatorByVarId(String v);
	
	public boolean isReplicatedBy(IReplicator r);

	public void addLinkToReplicator(HLinkToReplicator linkToReplicator);

	public void removeLinkToReplicator(HLinkToReplicator linkToReplicator);
	
}