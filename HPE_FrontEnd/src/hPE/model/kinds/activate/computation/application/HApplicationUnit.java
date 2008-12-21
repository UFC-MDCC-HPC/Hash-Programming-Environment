package hPE.model.kinds.activate.computation.application;

import java.util.Iterator;

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
import hPE.model.kinds.activate.computation.HComputationUnit;
import hPE.model.kinds.qualifier.architecture.HArchitectureComponent;
import hPE.model.kinds.qualifier.architecture.HArchitectureUnit;
import hPE.model.kinds.qualifier.architecture.HArchitectureUnitSlice;

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
	
	public HArchitectureUnit getProcessor() {
    	Iterator<HUnitSlice> cs = getSlices().iterator();
    	while (cs.hasNext()) {
    		HUnitSlice c = cs.next();
    		if (c instanceof HArchitectureUnitSlice) 
    			return (HArchitectureUnit) c.getBinding().getEntry();
    	}
    	
    	return null;
	}
}
