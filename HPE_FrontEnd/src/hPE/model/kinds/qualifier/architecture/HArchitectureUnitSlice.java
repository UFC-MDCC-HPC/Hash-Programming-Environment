package hPE.model.kinds.qualifier.architecture;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.exceptions.HPEAbortException;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HUnitSlice;
import hPE.model.base.IHUnit;
import hPE.model.kinds.qualifier.HQualifierUnitSlice;

public class HArchitectureUnitSlice extends HQualifierUnitSlice {

	public HArchitectureUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
	}
	
	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HArchitectureInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}
	

}
