package hPE.frontend.kinds.application.model;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.application.codegen.c_sharp.HBESynthesizerCSharpMain;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.codegen.HBEAbstractSynthesizer;
import hPE.frontend.kinds.computation.model.HComputationInterface;

public class HApplicationInterface extends HComputationInterface {

	static final long serialVersionUID = -3566150337970607928L;
	
	public HApplicationInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where) throws HPEAbortException{
		super(configuration, signature, unit, where);
		// TODO Auto-generated constructor stub
	}

	public List<HBEAbstractSynthesizer> getSupportedSynthesizers() {
		List<HBEAbstractSynthesizer> l = super.getSupportedSynthesizers();
		l.clear();
		HComponent c = (HComponent) this.getConfiguration().getTopConfiguration();
		if (c.isAbstractConfiguration()) {
			l.add(new hPE.frontend.activate.codegen.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new HBESynthesizerCSharpMain());
		}
		return l;
	}

}
