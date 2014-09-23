package hPE.frontend.kinds.synchronization.model;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;

public class HSynchronizationUnitSlice extends HUnitSlice {

	static final long serialVersionUID = -5778041458870308722L;
	
	public HSynchronizationUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HSynchronizationInterfaceSlice(name,(HInterface)this.getInterface(),s);
	}
}
