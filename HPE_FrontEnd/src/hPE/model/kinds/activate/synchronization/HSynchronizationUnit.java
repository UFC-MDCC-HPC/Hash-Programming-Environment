package hPE.model.kinds.activate.synchronization;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HPrimUnit;
import hPE.model.base.HUnit;
import hPE.model.base.HUnitSlice;
import hPE.model.base.HUnitStub;
import hPE.model.base.IHPrimUnit;
import hPE.model.base.IHUnit;
import hPE.model.base.exceptions.HPEAbortException;
import hPE.model.kinds.activate.HActivateUnit;
import hPE.model.kinds.activate.computation.HComputationInterface;
import hPE.model.kinds.activate.computation.HComputationUnitSlice;
import hPE.model.kinds.activate.computation.application.HApplicationInterface;

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

    public HUnitStub createStub() {
    	return new HSynchronizationUnitStub(this);
    }
}
