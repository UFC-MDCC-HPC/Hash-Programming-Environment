package hPE.frontend.kinds.data.model;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.computation.model.HComputationInterfaceSlice;

public class HDataUnitSlice extends HUnitSlice {

	static final long serialVersionUID = 9040319108481387138L;
	
	public HDataUnitSlice(IHUnit unit, IHUnit unitEntry, Point where)throws HPEAbortException{
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}
	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HDataInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}

}
