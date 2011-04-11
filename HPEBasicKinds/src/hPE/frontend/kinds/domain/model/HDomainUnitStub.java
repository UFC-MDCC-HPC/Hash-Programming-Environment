package hPE.frontend.kinds.domain.model;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HDomainUnitStub extends HUnitStub implements IHDomainUnit {

	static final long serialVersionUID = 1;


	public HDomainUnitStub(IHUnit unit) {
		super(unit);
	}

	public HDomainUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
