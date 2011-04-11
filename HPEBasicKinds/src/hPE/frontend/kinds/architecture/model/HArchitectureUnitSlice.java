package hPE.frontend.kinds.architecture.model;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.qualifier.model.HQualifierUnitSlice;

public class HArchitectureUnitSlice extends HQualifierUnitSlice {

	public HArchitectureUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		super(unit, unitEntry, where);
	}
	
	public HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s) {
		return new HArchitectureInterfaceSlice(name,(HInterface)this.getInterface(),s,this.getNestingFactor());
	}
	

}
