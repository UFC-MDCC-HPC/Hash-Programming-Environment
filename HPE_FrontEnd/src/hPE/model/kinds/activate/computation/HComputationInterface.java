package hPE.model.kinds.activate.computation;

import hPE.frontend.codegen.HBEAbstractSynthesizer;
import hPE.frontend.exceptions.HPEAbortException;
import hPE.model.base.HComponent;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.IHPrimUnit;
import hPE.model.kinds.activate.HActivateInterface;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;

public class HComputationInterface extends HActivateInterface {

	static final long serialVersionUID = -1978871722986750233L;
	
	public HComputationInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit u, Point where)throws HPEAbortException {
		super(configuration, signature, u, where);
	}

	public List<HBEAbstractSynthesizer> getSupportedSynthesizers() {
		List<HBEAbstractSynthesizer> l = super.getSupportedSynthesizers();
		HComponent c = (HComponent) this.getConfiguration().getTopConfiguration();
		if (c.isAbstractConfiguration()) {
			l.add(new hPE.frontend.codegen.base.activate.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new hPE.frontend.codegen.base.activate.c_sharp.HBESynthesizerCSharpConcrete());
		}
		return l;
	}
	
	public String getActivateMethodName() {
		return "compute";
	}	
}
