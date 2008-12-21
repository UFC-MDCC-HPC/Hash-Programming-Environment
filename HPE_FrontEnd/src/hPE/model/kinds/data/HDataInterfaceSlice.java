package hPE.model.kinds.data;

import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HInterfaceSlice;
import hPE.model.kinds.base.HHasPortsInterfaceSlice;

public class HDataInterfaceSlice extends HHasPortsInterfaceSlice {

	static final long serialVersionUID = 1;
	
	public HDataInterfaceSlice(String name, HInterface which_interface,
			HInterfaceSig interface_sig, int nestingFactor) {
		super(name, which_interface, interface_sig, nestingFactor);
	}
	
	
}
