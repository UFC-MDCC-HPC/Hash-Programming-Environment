package hPE.model.kinds.base;

import hPE.frontend.exceptions.HPEAbortException;
import hPE.model.base.HInterface;
import hPE.model.base.IBindingTarget;
import hPE.model.base.IHUnit;
import hPE.model.interfaces.IPackageLocation;

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
