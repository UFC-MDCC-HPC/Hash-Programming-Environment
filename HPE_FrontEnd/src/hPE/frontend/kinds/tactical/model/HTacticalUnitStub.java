package hPE.frontend.kinds.tactical.model;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HTacticalUnitStub extends HUnitStub implements IHTacticalUnit {

	static final long serialVersionUID = 1;


	public HTacticalUnitStub(IHUnit unit) {
		super(unit);
	}

	public HTacticalUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
