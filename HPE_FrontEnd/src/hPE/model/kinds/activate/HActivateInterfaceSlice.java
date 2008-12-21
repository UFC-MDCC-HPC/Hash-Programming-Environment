package hPE.model.kinds.activate;

import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.kinds.base.HHasPortsInterfaceSlice;

public abstract class HActivateInterfaceSlice extends HHasPortsInterfaceSlice {

	static final long serialVersionUID = -5917447108478862338L;
	
	public HActivateInterfaceSlice(String name, HInterface which_interface,
			HInterfaceSig interface_sig, int nestingFactor) {
		super(name, which_interface, interface_sig, nestingFactor);
	}
	

	

}
