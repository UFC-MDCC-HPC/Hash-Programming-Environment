package hPE.frontend.kinds.topology.model;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HTopologyUnitStub extends HUnitStub implements IHTopologyUnit {

	static final long serialVersionUID = 1;


	public HTopologyUnitStub(IHUnit unit) {
		super(unit);
	}

	public HTopologyUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
