package hPE.frontend.kinds.application.model;

import java.util.Iterator;

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
import hPE.frontend.kinds.computation.model.HComputationUnit;
import hPE.frontend.kinds.platform.model.HPlatformComponent;
import hPE.frontend.kinds.platform.model.HPlatformUnit;
import hPE.frontend.kinds.platform.model.HPlatformUnitSlice;

public class HApplicationUnit extends HComputationUnit implements IHApplicationUnit {

	public HApplicationUnit(String name, HComponent configuration,
			HInterface which_interface, HUnit compliantunit) {
		super(name, configuration, which_interface, compliantunit);
		// TODO Auto-generated constructor stub
	}

	public HApplicationUnit(String name, HComponent configuration) {
		super(name, configuration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected HInterface newInterface(HComponent c, HInterfaceSig s,
			IHPrimUnit unit, Point l) throws HPEAbortException{
			return new HApplicationInterface(c,s,unit,l);	
	}

	public HUnitSlice newSlice(IHUnit the_source, Point where) throws HPEAbortException {
		return new HApplicationUnitSlice(this, the_source, where);
	}
	
	public HPlatformUnit getProcessor() {
    	Iterator<HUnitSlice> cs = getSlices().iterator();
    	while (cs.hasNext()) {
    		HUnitSlice c = cs.next();
    		if (c instanceof HPlatformUnitSlice) 
    			return (HPlatformUnit) c.getBinding().getEntry();
    	}
    	
    	return null;
	}
}
