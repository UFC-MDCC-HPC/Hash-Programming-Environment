package hPE.model.kinds.activate.computation;

import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HUnit;
import hPE.model.base.HUnitSlice;
import hPE.model.base.HUnitStub;
import hPE.model.base.IHPrimUnit;
import hPE.model.base.IHUnit;
import hPE.model.base.exceptions.HPEAbortException;
import hPE.model.kinds.activate.HActivateUnit;

import org.eclipse.draw2d.geometry.Point;

public class HComputationUnit extends HActivateUnit implements IHComputationUnit {

	static final long serialVersionUID = 1;
	
	public HComputationUnit(String name, HComponent configuration,
			HInterface which_interface, HUnit compliantunit) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HComputationUnit(String name, HComponent configuration) {
		super(name, configuration);
		// TODO Auto-generated constructor stub
	}

	public HInterface createInterface(Point location) throws HPEAbortException{
		HComputationInterface i = (HComputationInterface) super.createInterface(location);
		i.buildDefaultProtocol();			
        return i;
	}
	
	protected HInterface newInterface(HComponent c, HInterfaceSig s, IHPrimUnit unit, Point l) throws HPEAbortException{
		return new HComputationInterface(c,s,unit,l);		
	}
	
	public HUnitSlice newSlice(IHUnit the_unit, Point where) throws HPEAbortException{
		return new HComputationUnitSlice(the_unit, this, where);
	}
	
    public HUnitStub createStub() {
    	return new HComputationUnitStub(this);
    }

}

