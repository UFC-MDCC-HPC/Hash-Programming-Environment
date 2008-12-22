package hPE.frontend.kinds.architecture.model;

import java.util.Iterator;
import java.util.List;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.kinds.qualifier.model.HQualifierInterfaceSlice;

public class HArchitectureInterfaceSlice extends HQualifierInterfaceSlice {

	public HArchitectureInterfaceSlice(String name, HInterface which_interface,
			HInterfaceSig interface_sig, int nestingFactor) {
		super(name, which_interface, interface_sig, nestingFactor);
				
	}
	
		
}
