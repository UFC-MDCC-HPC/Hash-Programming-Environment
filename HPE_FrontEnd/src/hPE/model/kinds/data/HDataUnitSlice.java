package hPE.model.kinds.data;

import org.eclipse.draw2d.geometry.Point;

import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HUnitSlice;
import hPE.model.base.IHUnit;
import hPE.model.base.exceptions.HPEAbortException;
import hPE.model.kinds.activate.computation.HComputationInterfaceSlice;

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
