package hPE.frontend.kinds.base.model;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;

public abstract class HHasPortsInterfaceSlice extends HInterfaceSlice {

	static final long serialVersionUID = 1;

	public HHasPortsInterfaceSlice(String name, HInterface which_interface,
			HInterfaceSig interface_sig, int nestingFactor) {
		super(name, which_interface, interface_sig, nestingFactor);
		// TODO Auto-generated constructor stub
	}

}
