package hPE.model.kinds.qualifier.environment;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.exceptions.HPEAbortException;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HUnitSlice;
import hPE.model.base.IHUnit;
import hPE.model.kinds.qualifier.HQualifierUnitSlice;

public class HEnvironmentUnitSlice extends HQualifierUnitSlice {

	static final long serialVersionUID = 1;

	public HEnvironmentUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HEnvironmentInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}
}
