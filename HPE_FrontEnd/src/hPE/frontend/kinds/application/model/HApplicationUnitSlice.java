package hPE.frontend.kinds.application.model;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.computation.model.HComputationUnitSlice;



public class HApplicationUnitSlice extends HComputationUnitSlice {

	static final long serialVersionUID = 1;

	public HApplicationUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HApplicationInterfaceSlice(name,(HInterface)this.getInterface(),s);
	}
}
