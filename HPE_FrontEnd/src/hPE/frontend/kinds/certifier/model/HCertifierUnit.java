package hPE.frontend.kinds.certifier.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.activate.model.HActivateUnit;

import org.eclipse.draw2d.geometry.Point;

public class HCertifierUnit extends HActivateUnit implements IHCertifierUnit {

	static final long serialVersionUID = 1;

	public HCertifierUnit(String name, HComponent configuration,
			HInterface which_interface) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HCertifierUnit(String name, HComponent configuration) {
		super(name, configuration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected HInterface newInterface(HComponent c, HInterfaceSig s,
			IHPrimUnit unit, Point l) throws HPEAbortException{
		return new HCertifierInterface(c,s,unit,l);	
	}

	public HUnitSlice newSlice(IHUnit the_unit, Point where) throws HPEAbortException{
		return new HCertifierUnitSlice(the_unit, this, where);
	}
	
  /*  public HUnitStub createStub() {
    	return new HQualifierUnitStub(this);
    } */
}
