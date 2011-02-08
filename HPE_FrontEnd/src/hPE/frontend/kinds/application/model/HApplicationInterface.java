package hPE.frontend.kinds.application.model;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.kinds.application.codegen.c_sharp.HBESynthesizerCSharpMain;
import hPE.frontend.kinds.computation.model.HComputationInterface;

public class HApplicationInterface extends HComputationInterface {

	static final long serialVersionUID = -3566150337970607928L;

	public HApplicationInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where) throws HPEAbortException{
		super(configuration, signature, unit, where);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<HBEAbstractSynthesizer> getSupportedSynthesizers() {
		List<HBEAbstractSynthesizer> l = super.getSupportedSynthesizers();
		l.clear();
		HComponent c = (HComponent) this.getConfiguration().getTopConfiguration();
		if (c.isAbstractConfiguration()) {
			l.add(new hPE.frontend.kinds.activate.codegen.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new HBESynthesizerCSharpMain());
		}
		return l;
	}

	@Override
	public HBESourceVersion<?> createSourceVersion(String sourceType) {
		if (sourceType.equals(hPE.frontend.kinds.application.codegen.c_sharp.HBESourceVersionCSharp.getType())) {
			return new hPE.frontend.kinds.application.codegen.c_sharp.HBESourceVersionCSharp();
		} else {
			return super.createSourceVersion(sourceType);
		}
	}
}
