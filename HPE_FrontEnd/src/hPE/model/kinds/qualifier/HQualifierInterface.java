package hPE.model.kinds.qualifier;

import hPE.frontend.codegen.HBEAbstractSynthesizer;
import hPE.model.base.HComponent;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.IHPrimUnit;
import hPE.model.base.exceptions.HPEAbortException;
import hPE.model.kinds.base.HHasPortsInterface;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;

public class HQualifierInterface extends HHasPortsInterface  {

	static final long serialVersionUID = 1;

	public HQualifierInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where)  throws HPEAbortException {
		super(configuration, signature, unit, where);
		// TODO Auto-generated constructor stub
	}

	public List<HBEAbstractSynthesizer> getSupportedSynthesizers() {
		List<HBEAbstractSynthesizer> l = super.getSupportedSynthesizers();
		HComponent c = (HComponent) this.getConfiguration();
		if (c.isAbstractConfiguration()) {
			l.add(new hPE.frontend.codegen.base.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new hPE.frontend.codegen.base.c_sharp.HBESynthesizerCSharpConcrete());
		}
		return l;
	}

}
