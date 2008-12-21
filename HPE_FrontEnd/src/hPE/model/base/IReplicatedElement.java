package hPE.model.base;

import hPE.model.interfaces.IReplicator;

import java.util.Collection;
import java.util.List;


public interface IReplicatedElement extends IPointsToReplicator {


	/**
	 */
	public boolean isReplicated();

	/**
	 */
	public int getReplicationFactor(HReplicator which_replicator);

	/**
	 */
	public boolean isReplicatorFactorDetermined(HReplicator which_replicator);

	/**
	 */
	public boolean isReplicatedBy(IReplicator which_replicator);

		
}
