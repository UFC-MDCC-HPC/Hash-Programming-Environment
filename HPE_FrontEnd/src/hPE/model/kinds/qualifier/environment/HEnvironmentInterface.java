package hPE.model.kinds.qualifier.environment;

import org.eclipse.draw2d.geometry.Point;

import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.IHPrimUnit;
import hPE.model.base.exceptions.HPEAbortException;
import hPE.model.kinds.base.HBaseKindInterface;
import hPE.model.kinds.qualifier.HQualifierInterface;

public class HEnvironmentInterface extends HQualifierInterface {

	static final long serialVersionUID = 1;
		
	public HEnvironmentInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where) throws HPEAbortException{
		super(configuration, signature, unit, where);
		// TODO Auto-generated constructor stub
	}


}
