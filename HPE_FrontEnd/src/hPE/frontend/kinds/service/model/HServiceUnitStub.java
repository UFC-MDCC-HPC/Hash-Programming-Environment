package hPE.frontend.kinds.service.model;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HServiceUnitStub extends HUnitStub implements IHServiceUnit {

	static final long serialVersionUID = 1;


	public HServiceUnitStub(IHUnit unit) {
		super(unit);
	}

	public HServiceUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
