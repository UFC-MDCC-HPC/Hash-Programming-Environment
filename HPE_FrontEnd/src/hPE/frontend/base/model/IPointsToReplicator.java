package hPE.frontend.base.model;

import java.util.List;

import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IReplicator;

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