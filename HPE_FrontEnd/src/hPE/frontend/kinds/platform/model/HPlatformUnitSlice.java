package hPE.frontend.kinds.platform.model;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.qualifier.model.HQualifierUnitSlice;

public class HPlatformUnitSlice extends HQualifierUnitSlice {

	public HPlatformUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
	}
	
	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HPlatformInterfaceSlice(name,(HInterface)this.getInterface(),s);
	}
	

}
