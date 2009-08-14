package hPE.frontend.kinds.architecture.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HPrimUnit;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.application.model.HApplicationInterface;
import hPE.frontend.kinds.computation.model.HComputationUnitSlice;
import hPE.frontend.kinds.qualifier.model.HQualifierUnit;
import hPE.frontend.kinds.qualifier.model.IHQualifierUnit;

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
	
	/*
    public HUnitStub createStub() {
    	return new HArchitectureUnitStub(this);
    }*/
	
}
