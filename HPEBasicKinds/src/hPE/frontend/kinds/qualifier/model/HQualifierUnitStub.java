package hPE.frontend.kinds.qualifier.model;

import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HQualifierUnitStub extends HUnitStub implements IHQualifierUnit {

	static final long serialVersionUID = 1;


	public HQualifierUnitStub(IHUnit unit) {
		super(unit);
	}

	public HQualifierUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
