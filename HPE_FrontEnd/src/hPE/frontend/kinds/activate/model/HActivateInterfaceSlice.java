package hPE.frontend.kinds.activate.model;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.kinds.base.model.HHasPortsInterfaceSlice;

public abstract class HActivateInterfaceSlice extends HHasPortsInterfaceSlice {

	static final long serialVersionUID = -5917447108478862338L;
	
	public HActivateInterfaceSlice(String name, HInterface which_interface,
			HInterfaceSig interface_sig, int nestingFactor) {
		super(name, which_interface, interface_sig, nestingFactor);
	}
	

	

}
