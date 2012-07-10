package hPE.frontend.kinds.topology.model;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;

public class HTopologyUnitSlice extends HUnitSlice {

	static final long serialVersionUID = 3985366735601846628L;
	
	public HTopologyUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HTopologyInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}
}
