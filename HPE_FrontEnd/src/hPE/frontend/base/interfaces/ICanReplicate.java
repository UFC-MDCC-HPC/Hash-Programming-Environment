package hPE.frontend.base.interfaces;

import java.util.List;

import hPE.frontend.base.model.HReplicator;

public interface ICanReplicate {

	public boolean isReplicated();
	public boolean isReplicatedBy(IReplicator which_replicator);
	public List<HReplicator> getReplicators();

}
