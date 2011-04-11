package hPE.frontend.kinds.data.model;

import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;

public class HDataUnitStub extends HUnitStub implements IHDataUnit {

	static final long serialVersionUID = 3900075611765101349L;
	public HDataUnitStub(IHUnit unit) {
		super(unit);
	}
	
	public HDataUnitStub(IHUnit unit, HComponent enc) {
		super(unit,enc);
	}
	

}
