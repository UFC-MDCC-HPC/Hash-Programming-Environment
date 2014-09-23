package hPE.frontend.kinds.environment.model;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.qualifier.model.HQualifierUnitSlice;

public class HEnvironmentUnitSlice extends HQualifierUnitSlice {

	static final long serialVersionUID = 1;

	public HEnvironmentUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
		// TODO Auto-generated constructor stub
	}

	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HEnvironmentInterfaceSlice(name,(HInterface)this.getInterface(),s);
	}
}
