package hPE.model.kinds.activate.synchronization;

import hPE.frontend.codegen.HBEAbstractSynthesizer;
import hPE.frontend.exceptions.HPEAbortException;
import hPE.model.base.HComponent;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.IHPrimUnit;
import hPE.model.kinds.activate.HActivateInterface;

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
			l.add(new hPE.frontend.codegen.base.activate.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new hPE.frontend.codegen.base.activate.c_sharp.HBESynthesizerCSharpConcrete());
		}
		return l;
	}

	public String getActivateMethodName() {
		return "synchronize";
	}

}
