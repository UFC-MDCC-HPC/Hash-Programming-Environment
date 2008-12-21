package hPE.model.kinds.activate.computation.application;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.exceptions.HPEAbortException;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.IHUnit;
import hPE.model.kinds.activate.computation.HComputationUnitSlice;



public class HApplicationUnitSlice extends HComputationUnitSlice {

	static final long serialVersionUID = 1;

	public HApplicationUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HApplicationInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}
}
