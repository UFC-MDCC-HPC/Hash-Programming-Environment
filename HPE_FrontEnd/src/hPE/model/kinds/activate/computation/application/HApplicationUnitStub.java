package hPE.model.kinds.activate.computation.application;

import org.eclipse.draw2d.geometry.Rectangle;

import hPE.model.base.HComponent;
import hPE.model.base.HUnitStub;
import hPE.model.base.IHUnit;
import hPE.model.kinds.activate.computation.HComputationUnitStub;
import hPE.model.kinds.qualifier.architecture.HArchitectureUnit;

public class HApplicationUnitStub extends HComputationUnitStub implements IHApplicationUnit{


	public HApplicationUnitStub(IHUnit unit) {
		super(unit);
		// TODO Auto-generated constructor stub
	}
	
	public HArchitectureUnit getProcessor() {
	    return ((HApplicationUnit)this.getRealUnit()).getProcessor();	
	}
	

}
