package hPE.frontend.kinds.synchronization.model;

import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.kinds.activate.model.HActivateInterface;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;

public class HSynchronizationInterface extends HActivateInterface {

	
	static final long serialVersionUID = -7332210994077731731L;

	
	public HSynchronizationInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where) throws HPEAbortException{
		super(configuration, signature, unit, where);
	}

	public List<HBEAbstractSynthesizer> getSupportedSynthesizers() {
		List<HBEAbstractSynthesizer> l = super.getSupportedSynthesizers();
		HComponent c = (HComponent) this.getConfiguration();
		if (c.isAbstractConfiguration()) {
			l.add(new hPE.frontend.kinds.activate.codegen.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new hPE.frontend.kinds.activate.codegen.c_sharp.HBESynthesizerCSharpConcrete());
		}
		return l;
	}

	public String getActivateMethodName() {
		return "synchronize";
	}

}
