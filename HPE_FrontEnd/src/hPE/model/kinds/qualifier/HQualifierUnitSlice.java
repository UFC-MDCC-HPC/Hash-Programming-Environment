package hPE.model.kinds.qualifier;

import org.eclipse.draw2d.geometry.Point;

import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HUnitSlice;
import hPE.model.base.IHUnit;
import hPE.model.exceptions.base.HPEAbortException;

public class HQualifierUnitSlice extends HUnitSlice {

	static final long serialVersionUID = 3985366735601846628L;
	
	public HQualifierUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HQualifierInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}
}
