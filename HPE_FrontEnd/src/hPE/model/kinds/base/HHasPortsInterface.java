package hPE.model.kinds.base;

import hPE.model.base.HComponent;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.IHPrimUnit;
import hPE.model.exceptions.base.HPENotFusableSlicesException;

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
