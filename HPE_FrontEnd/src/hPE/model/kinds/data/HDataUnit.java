package hPE.model.kinds.data;


import hPE.model.base.HComponent;
import hPE.model.base.HHasPortsUnit;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HUnitSlice;
import hPE.model.base.HUnitStub;
import hPE.model.base.IHPrimUnit;
import hPE.model.base.IHUnit;
import hPE.model.exceptions.base.HPEAbortException;

import org.eclipse.draw2d.geometry.Point;

public class HDataUnit extends HHasPortsUnit implements IHDataUnit {
	
	static final long serialVersionUID = 1;

	public HDataUnit(String name, HComponent configuration, HDataInterface which_interface) {
		super(name, configuration, which_interface);
	}
	
	public HDataUnit(String name, HComponent configuration) {
		super(name,configuration);		
	}	

	protected HInterface newInterface(HComponent c, HInterfaceSig s, IHPrimUnit u, Point l) throws HPEAbortException{
		return new HDataInterface(c,s,u,l);		
	}	

	public HUnitSlice newSlice(IHUnit the_unit, Point where) throws HPEAbortException {
		return new HDataUnitSlice(the_unit, this, where);
	}
	
    public HUnitStub createStub() {
    	return new HDataUnitStub(this);
    }
	
}
