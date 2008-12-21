package hPE.model.kinds.activate.computation;

import org.eclipse.draw2d.geometry.Point;

import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HUnitSlice;
import hPE.model.base.IHUnit;
import hPE.model.base.exceptions.HPEAbortException;

public class HComputationUnitSlice extends HUnitSlice {

	static final long serialVersionUID = 5724874541574295657L;

	public HComputationUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HComputationInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}
}
