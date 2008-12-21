package hPE.model.kinds.base;

import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HUnitSlice;
import hPE.model.base.IHPrimUnit;
import hPE.model.exceptions.base.HPENotFusableSlicesException;

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
