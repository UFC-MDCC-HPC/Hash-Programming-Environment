package hPE.frontend.kinds.certifier.model;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HCertifierUnitStub extends HUnitStub implements IHCertifierUnit {

	static final long serialVersionUID = 1;


	public HCertifierUnitStub(IHUnit unit) {
		super(unit);
	}

	public HCertifierUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
