package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.kinds.base.model.HHasPortsInterface;

import org.eclipse.draw2d.geometry.Point;

public abstract class HHasPortsUnit extends HUnit {

	static final long serialVersionUID = -1;
	
	public HHasPortsUnit(String name, HComponent configuration,
			HInterface which_interface) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HHasPortsUnit(String name, HComponent configuration) {
		super(name, configuration);
		// TODO Auto-generated constructor stub
	}

	protected HInterface createInterfaceFromSlices(Point location) throws HPEAbortException {
		
		HHasPortsInterface i = (HHasPortsInterface) super.createInterfaceFromSlices(location);
				
		return i;
	}

}
