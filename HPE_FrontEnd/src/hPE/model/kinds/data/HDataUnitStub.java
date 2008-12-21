package hPE.model.kinds.data;

import org.eclipse.draw2d.geometry.Rectangle;

import hPE.model.base.HComponent;
import hPE.model.base.HUnitStub;
import hPE.model.base.IHUnit;

public class HDataUnitStub extends HUnitStub implements IHDataUnit {

	static final long serialVersionUID = 3900075611765101349L;
	public HDataUnitStub(IHUnit unit) {
		super(unit);
	}
	
	public HDataUnitStub(IHUnit unit, HComponent enc) {
		super(unit,enc);
	}
	

}
