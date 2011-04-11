package hPE.frontend.kinds.application.model;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.kinds.computation.model.HComputationInterfaceSlice;

public class HApplicationInterfaceSlice extends HComputationInterfaceSlice {

	static final long serialVersionUID = 1;

	public HApplicationInterfaceSlice(String name, HInterface which_interface,
			HInterfaceSig interface_sig, int nestingFactor) {
		super(name, which_interface, interface_sig, nestingFactor);
		// TODO Auto-generated constructor stub
	}

}
