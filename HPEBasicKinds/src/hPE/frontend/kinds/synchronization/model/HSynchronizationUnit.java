package hPE.frontend.kinds.synchronization.model;

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
import hPE.frontend.kinds.activate.model.HActivateUnit;
import hPE.frontend.kinds.application.model.HApplicationInterface;
import hPE.frontend.kinds.computation.model.HComputationInterface;
import hPE.frontend.kinds.computation.model.HComputationUnitSlice;

public class HSynchronizationUnit extends HActivateUnit implements IHSynchronizationUnit {

	static final long serialVersionUID = -5675690923731358079L;
	
	public HSynchronizationUnit(String name, HComponent configuration,
			HInterface which_interface) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HSynchronizationUnit(String name, HComponent configuration) {
		super(name, configuration);
	}

	@Override
	protected HInterface newInterface(HComponent c, HInterfaceSig s,
			IHPrimUnit unit, Point l) throws HPEAbortException{
		return new HSynchronizationInterface(c,s,unit,l);	
	}

	public HInterface createInterface(Point location) throws HPEAbortException{
		HSynchronizationInterface i = (HSynchronizationInterface) super.createInterface(location);
		if (this.getSlices().size() > 0) 
			i.buildDefaultProtocol();			
        return i;
	}
	

    public HUnitSlice newSlice(IHUnit the_unit, Point where) throws HPEAbortException{
		return new HSynchronizationUnitSlice(the_unit, this, where);
	}

    /*
    public HUnitStub createStub() {
    	return new HSynchronizationUnitStub(this);
    } */
}
