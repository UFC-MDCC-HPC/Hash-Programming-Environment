package hPE.frontend.kinds.computation.model;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;

public class HComputationUnitSlice extends HUnitSlice {

	static final long serialVersionUID = 5724874541574295657L;

	public HComputationUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HComputationInterfaceSlice(name,(HInterface)this.getInterface(),s);
	}
}
