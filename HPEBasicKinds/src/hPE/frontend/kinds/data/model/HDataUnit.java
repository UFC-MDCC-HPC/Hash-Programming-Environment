package hPE.frontend.kinds.data.model;


import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasPortsUnit;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;

import org.eclipse.draw2d.geometry.Point;

public class HDataUnit extends HHasPortsUnit implements IHDataUnit {

	static final long serialVersionUID = 1;

	public HDataUnit(String name, HComponent configuration, HInterface which_interface) {
		super(name, configuration, which_interface);
	}

	public HDataUnit(String name, HComponent configuration) {
		super(name,configuration);
	}

	@Override
	protected HInterface newInterface(HComponent c, HInterfaceSig s, IHPrimUnit u, Point l) throws HPEAbortException{
		return new HDataInterface(c,s,u,l);
	}

	@Override
	public HUnitSlice newSlice(IHUnit the_unit, Point where) throws HPEAbortException {
		return new HDataUnitSlice(the_unit, this, where);
	}

	/*
    public HUnitStub createStub() {
    	return new HDataUnitStub(this);
    }*/

}
