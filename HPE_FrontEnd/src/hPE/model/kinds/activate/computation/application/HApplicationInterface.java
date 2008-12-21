package hPE.model.kinds.activate.computation.application;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;

import hPE.backend.cluster.synthesizer.HBEAbstractSynthesizer;
import hPE.backend.cluster.synthesizer.base.activate.computation.application.c_sharp.HBESynthesizerCSharpMain;
import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.IHPrimUnit;
import hPE.model.exceptions.base.HPEAbortException;
import hPE.model.kinds.activate.computation.HComputationInterface;

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
			l.add(new hPE.backend.cluster.synthesizer.base.activate.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new HBESynthesizerCSharpMain());
		}
		return l;
	}

}
