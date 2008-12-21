package hPE.model.kinds.qualifier.architecture;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.exceptions.HPEAbortException;
import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HPrimUnit;
import hPE.model.base.HUnit;
import hPE.model.base.HUnitSlice;
import hPE.model.base.HUnitStub;
import hPE.model.base.IHPrimUnit;
import hPE.model.base.IHUnit;
import hPE.model.kinds.activate.computation.HComputationUnitSlice;
import hPE.model.kinds.activate.computation.application.HApplicationInterface;
import hPE.model.kinds.qualifier.HQualifierUnit;
import hPE.model.kinds.qualifier.IHQualifierUnit;

public class HArchitectureUnit extends HQualifierUnit implements IHQualifierUnit {

	static final long serialVersionUID = 1;
	
	public HArchitectureUnit(String name, HComponent configuration,
			HInterface which_interface) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HArchitectureUnit(String name, HComponent configuration) {
		super(name, configuration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected HInterface newInterface(HComponent c, HInterfaceSig s,
			IHPrimUnit unit, Point l) throws HPEAbortException {
		return new HArchitectureInterface(c,s,unit,l);	
	}

	public HUnitSlice newSlice(IHUnit the_unit, Point where) throws HPEAbortException{
		return new HArchitectureUnitSlice(the_unit, this, where);
	}
	
    public HUnitStub createStub() {
    	return new HArchitectureUnitStub(this);
    }
	
}
