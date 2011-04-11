package hPE.frontend.kinds.application.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.architecture.model.HArchitectureUnit;
import hPE.frontend.kinds.architecture.model.HArchitectureUnitSlice;
import hPE.frontend.kinds.computation.model.HComputationUnit;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Point;

public class HApplicationUnit extends HComputationUnit implements IHApplicationUnit {

	public HApplicationUnit(String name, HComponent configuration,
			HInterface which_interface) {
		super(name, configuration, which_interface);
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

	@Override
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
