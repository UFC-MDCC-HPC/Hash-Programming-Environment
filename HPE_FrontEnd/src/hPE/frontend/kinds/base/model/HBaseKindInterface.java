package hPE.frontend.kinds.base.model;

import hPE.frontend.base.exceptions.HPENotFusableSlicesException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHPrimUnit;

import org.eclipse.draw2d.geometry.Point;

public abstract class HBaseKindInterface extends HInterface {

	static final long serialVersionUID = 1;
	
	public HBaseKindInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where) throws HPENotFusableSlicesException {
		super(configuration, signature, unit, where);
        
		
	}
	
	

	
	public HInterfaceSlice addInterfaceSlice(HUnitSlice uSlice, String name) throws HPENotFusableSlicesException{
		
		HInterfaceSlice s = super.addInterfaceSlice(uSlice,name);
				
		return s;
	}

}
