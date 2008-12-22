package hPE.frontend.kinds.synchronization.model;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HSynchronizationUnitStub extends HUnitStub implements IHSynchronizationUnit{

	static final long serialVersionUID = 1892983250687456796L;
	
	public HSynchronizationUnitStub(IHUnit unit) {
		super(unit);
	}

	public HSynchronizationUnitStub(IHUnit unit, HComponent enc) {
		super(unit,enc);
	}

}
