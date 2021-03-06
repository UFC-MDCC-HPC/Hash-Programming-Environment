package hPE.frontend.kinds.data.model;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.kinds.base.model.HHasPortsInterfaceSlice;

public class HDataInterfaceSlice extends HHasPortsInterfaceSlice {

	static final long serialVersionUID = 1;
	
	public HDataInterfaceSlice(String name, HInterface which_interface,
			HInterfaceSig interface_sig) {
		super(name, which_interface, interface_sig);
	}
	
	
}
