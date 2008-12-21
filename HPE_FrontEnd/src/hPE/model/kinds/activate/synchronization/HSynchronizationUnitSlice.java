package hPE.model.kinds.activate.synchronization;

import org.eclipse.draw2d.geometry.Point;

import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HUnitSlice;
import hPE.model.base.IHUnit;
import hPE.model.exceptions.base.HPEAbortException;

public class HSynchronizationUnitSlice extends HUnitSlice {

	static final long serialVersionUID = -5778041458870308722L;
	
	public HSynchronizationUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HSynchronizationInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}
}
