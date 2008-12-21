package hPE.model.kinds.qualifier.architecture;

import org.eclipse.draw2d.geometry.Point;

import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.IHPrimUnit;
import hPE.model.exceptions.base.HPEAbortException;
import hPE.model.kinds.base.HBaseKindInterface;
import hPE.model.kinds.qualifier.HQualifierInterface;

public class HArchitectureInterface extends HQualifierInterface {

	public HArchitectureInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where) throws HPEAbortException {
		super(configuration, signature, unit, where);
		// TODO Auto-generated constructor stub
	}


}
