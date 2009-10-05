package hPE.frontend.kinds.enumerator.model;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;

public class HEnumeratorInterfaceSlice extends HInterfaceSlice {

	/**
	 * 
	 */
	private static final long serialVersionUID = -836939298300677499L;

	public HEnumeratorInterfaceSlice(String name, HInterface which_interface,
			HInterfaceSig interface_sig, int nestingFactor) {
		super(name, which_interface, interface_sig, nestingFactor);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		HEnumeratorUnitSlice eus = (HEnumeratorUnitSlice) this.getCompliantUnitSlices().get(0);
		return super.getName() + "_for_" + eus.getAssocSlice().getName();
	}
	
	public String getReplicatorID() {
		HEnumeratorUnitSlice eus = (HEnumeratorUnitSlice) this.getCompliantUnitSlices().get(0);
		return eus.getMappedReplicator().getRef();
	}

}
