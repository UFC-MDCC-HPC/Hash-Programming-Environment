package hPE.frontend.kinds.computation.model;

import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HComputationUnitStub extends HUnitStub implements IHComputationUnit {

	static final long serialVersionUID = 8915111643675847664L;

	public HComputationUnitStub(IHUnit unit) {
		super(unit);
		// TODO Auto-generated constructor stub
	}

	public HComputationUnitStub(IHUnit unit, HComponent enc) {
		super(unit,enc);
		// TODO Auto-generated constructor stub
	}
}
