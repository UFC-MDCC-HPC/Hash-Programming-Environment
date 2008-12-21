package hPE.model.kinds.qualifier;

import org.eclipse.draw2d.geometry.Rectangle;

import hPE.model.base.HComponent;
import hPE.model.base.HUnitStub;
import hPE.model.base.IHUnit;

public class HQualifierUnitStub extends HUnitStub implements IHQualifierUnit {

	static final long serialVersionUID = 1;


	public HQualifierUnitStub(IHUnit unit) {
		super(unit);
	}

	public HQualifierUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
