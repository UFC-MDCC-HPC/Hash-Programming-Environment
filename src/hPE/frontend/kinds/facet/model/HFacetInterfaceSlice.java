package hPE.frontend.kinds.facet.model;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.base.model.HHasPortsInterfaceSlice;
import hPE.frontend.kinds.facet.FacetKindConfiguration;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class HFacetInterfaceSlice extends HHasPortsInterfaceSlice {

	static final long serialVersionUID = 1;

	public HFacetInterfaceSlice(String name, HInterface which_interface, HInterfaceSig interface_sig, int nestingFactor) {
		super(name, which_interface, interface_sig, nestingFactor);

	}

}
