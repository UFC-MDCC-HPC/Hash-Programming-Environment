package hPE.frontend.kinds.tactical.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasPortsUnit;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HPrimUnit;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.activate.model.HActivateUnit;
import hPE.frontend.kinds.application.model.HApplicationInterface;
import hPE.frontend.kinds.computation.model.HComputationUnitSlice;

public class HTacticalUnit extends HActivateUnit implements IHTacticalUnit {

	static final long serialVersionUID = 1;

	public HTacticalUnit(String name, HComponent configuration,
			HInterface which_interface) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HTacticalUnit(String name, HComponent configuration) {
		super(name, configuration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected HInterface newInterface(HComponent c, HInterfaceSig s,
			IHPrimUnit unit, Point l) throws HPEAbortException{
		return new HTacticalInterface(c,s,unit,l);	
	}

	public HUnitSlice newSlice(IHUnit the_unit, Point where) throws HPEAbortException{
		return new HTacticalUnitSlice(the_unit, this, where);
	}
	
  /*  public HUnitStub createStub() {
    	return new HQualifierUnitStub(this);
    } */
}
