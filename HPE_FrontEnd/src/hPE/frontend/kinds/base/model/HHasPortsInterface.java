package hPE.frontend.kinds.base.model;

import hPE.frontend.base.exceptions.HPENotFusableSlicesException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.IHPrimUnit;

import org.eclipse.draw2d.geometry.Point;

public abstract class HHasPortsInterface extends HBaseKindInterface {

	static final long serialVersionUID = 1170720482159503042L;
	
	public HHasPortsInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where)
			throws HPENotFusableSlicesException {
		super(configuration, signature, unit, where);
		// TODO Auto-generated constructor stub
	}

	// Traverse the interface signature, looking for ports (non-hidden data slices).
	
	
}
