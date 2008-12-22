package hPE.frontend.kinds.base.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.IBindingTarget;
import hPE.frontend.base.model.IHUnit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

public abstract class HHasPortsConfiguration extends HBaseKindComponent {

	static final long serialVersionUID = -4285302639541705189L;
	
	public HHasPortsConfiguration(String name, IPackageLocation location,
			URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	public IBindingTarget createBinding(IHUnit the_source, IHUnit the_unit, Point where) throws HPEAbortException {
    
		return super.createBinding(the_source, the_unit, where);
	}
	
}
