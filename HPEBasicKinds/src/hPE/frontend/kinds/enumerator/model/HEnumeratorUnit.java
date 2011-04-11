package hPE.frontend.kinds.enumerator.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;

import org.eclipse.draw2d.geometry.Point;

public class HEnumeratorUnit extends HUnit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2138865226134325836L;

	public HEnumeratorUnit(String name, HComponent configuration,
			HInterface which_interface) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HEnumeratorUnit(String name, HComponent configuration) {
		super(name, configuration);
	}

	@Override
	protected HInterface newInterface(HComponent c, HInterfaceSig s,
			IHPrimUnit unit, Point l) throws HPEAbortException {
		return new HEnumeratorInterface(c,s,unit,l);	
		
	}

	@Override
	public HUnitSlice newSlice(IHUnit the_source, Point where)
			throws HPEAbortException {
		return  new HEnumeratorUnitSlice(the_source, this, where);
	}

/*
    public HUnitStub createStub() {
    	return new HEnumeratorUnitStub(this);
    } */

}
