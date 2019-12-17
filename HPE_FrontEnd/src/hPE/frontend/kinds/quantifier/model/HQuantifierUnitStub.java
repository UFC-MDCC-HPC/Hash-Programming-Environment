package hPE.frontend.kinds.quantifier.model;

import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HQuantifierUnitStub extends HUnitStub implements IHQuantifierUnit {

	static final long serialVersionUID = 1;


	public HQuantifierUnitStub(IHUnit unit) {
		super(unit);
	}

	public HQuantifierUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
