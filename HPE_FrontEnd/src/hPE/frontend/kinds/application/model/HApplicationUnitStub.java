package hPE.frontend.kinds.application.model;

import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.computation.model.HComputationUnitStub;
import hPE.frontend.kinds.platform.model.HPlatformUnit;

public class HApplicationUnitStub extends HComputationUnitStub implements IHApplicationUnit{


	public HApplicationUnitStub(IHUnit unit) {
		super(unit);
		// TODO Auto-generated constructor stub
	}
	
	public HPlatformUnit getProcessor() {
	    return ((HApplicationUnit)this.getActualUnit()).getProcessor();	
	}
	

}
