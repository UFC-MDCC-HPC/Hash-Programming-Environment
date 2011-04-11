package hPE.frontend.kinds.enumerator.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;

import org.eclipse.draw2d.geometry.Point;

public class HEnumeratorUnitSlice extends HUnitSlice {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6826791074330297823L;

	public HEnumeratorUnitSlice(IHUnit unit, IHUnit unitEntry, Point where)
			throws HPEAbortException {
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HEnumeratorInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}
	
	public void setMappedReplicator(HReplicator mappedReplicator) {
		this.mappedReplicator = mappedReplicator;
	}

	public HReplicator getMappedReplicator() {
		return mappedReplicator;
	}

	public void setAssocSlice(HUnitSlice assocSlice) {
		this.assocSlice = assocSlice;
	}

	public HUnitSlice getAssocSlice() {
		return assocSlice;
	}

	private HReplicator mappedReplicator = null;

	private HUnitSlice assocSlice = null;
	
	
}
