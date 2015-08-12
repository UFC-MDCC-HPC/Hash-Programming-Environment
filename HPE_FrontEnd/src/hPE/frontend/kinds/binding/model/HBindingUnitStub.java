package hPE.frontend.kinds.binding.model;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HBindingUnitStub extends HUnitStub implements IHBindingUnit {

	static final long serialVersionUID = 1;


	public HBindingUnitStub(IHUnit unit) {
		super(unit);
	}

	public HBindingUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
