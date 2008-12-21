package hPE.model.kinds.activate;

import hPE.model.base.HComponent;
import hPE.model.base.HHasPortsUnit;
import hPE.model.base.HInterface;
import hPE.model.base.HUnit;

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
