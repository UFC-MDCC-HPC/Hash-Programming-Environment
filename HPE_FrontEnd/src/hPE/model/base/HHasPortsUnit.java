package hPE.model.base;

import java.util.ArrayList;
import java.util.List;

import hPE.model.base.exceptions.HPEAbortException;
import hPE.model.kinds.base.HHasPortsInterface;

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
