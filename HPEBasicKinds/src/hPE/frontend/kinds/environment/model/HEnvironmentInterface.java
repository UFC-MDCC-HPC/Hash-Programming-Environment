package hPE.frontend.kinds.environment.model;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.kinds.base.model.HBaseKindInterface;
import hPE.frontend.kinds.qualifier.model.HQualifierInterface;

public class HEnvironmentInterface extends HQualifierInterface {

	static final long serialVersionUID = 1;
		
	public HEnvironmentInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where) throws HPEAbortException{
		super(configuration, signature, unit, where);
		// TODO Auto-generated constructor stub
	}


}
