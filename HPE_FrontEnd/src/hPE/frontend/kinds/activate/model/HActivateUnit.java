package hPE.frontend.kinds.activate.model;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasPortsUnit;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HUnit;

public abstract class HActivateUnit extends HHasPortsUnit {

	static final long serialVersionUID = 8652846277034490406L;
	
	public HActivateUnit(String name, HComponent configuration,
			HInterface which_interface) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HActivateUnit(String name, HComponent configuration) {
		super(name, configuration);
		// TODO Auto-generated constructor stub
	}

}
