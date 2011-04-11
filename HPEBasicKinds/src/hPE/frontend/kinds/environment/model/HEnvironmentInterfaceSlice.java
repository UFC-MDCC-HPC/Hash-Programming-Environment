package hPE.frontend.kinds.environment.model;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.kinds.qualifier.model.HQualifierInterfaceSlice;

public class HEnvironmentInterfaceSlice extends HQualifierInterfaceSlice {

	static final long serialVersionUID = 1;

	public HEnvironmentInterfaceSlice(String name, HInterface which_interface,
			HInterfaceSig interface_sig, int nestingFactor) {
		super(name, which_interface, interface_sig, nestingFactor);
		// TODO Auto-generated constructor stub
	}

}
