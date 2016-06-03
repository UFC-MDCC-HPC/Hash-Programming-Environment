package hPE.frontend.kinds.binding.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasPortsUnit;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;

import org.eclipse.draw2d.geometry.Point;

public class HBindingUnit extends HHasPortsUnit implements IHBindingUnit {

	static final long serialVersionUID = 1;

	public HBindingUnit(String name, HComponent configuration,
			HInterface which_interface) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HBindingUnit(String name, HComponent configuration) {
		super(name, configuration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected HInterface newInterface(HComponent c, HInterfaceSig s,
			IHPrimUnit unit, Point l) throws HPEAbortException{
		return new HBindingInterface(c,s,unit,l);	
	}

	public HUnitSlice newSlice(IHUnit the_unit, Point where) throws HPEAbortException{
		return new HBindingUnitSlice(the_unit, this, where);
	}
	
}
