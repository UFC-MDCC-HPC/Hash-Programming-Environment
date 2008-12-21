package hPE.model.interfaces;

import java.util.List;

import hPE.model.base.HReplicator;

public interface ICanReplicate {

	public boolean isReplicated();
	public boolean isReplicatedBy(IReplicator which_replicator);
	public List<HReplicator> getReplicators();

}
