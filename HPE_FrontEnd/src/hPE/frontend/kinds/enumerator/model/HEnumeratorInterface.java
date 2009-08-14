package hPE.frontend.kinds.enumerator.model;

import hPE.frontend.base.exceptions.HPENotFusableSlicesException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.kinds.base.model.HBaseKindInterface;

import org.eclipse.draw2d.geometry.Point;

public class HEnumeratorInterface extends HBaseKindInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5260714356447497077L;

	public HEnumeratorInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where)
			throws HPENotFusableSlicesException {
		super(configuration, signature, unit, where);
		// TODO Auto-generated constructor stub
	}

/*	public List<HBEAbstractSynthesizer> getSupportedSynthesizers() {
		List<HBEAbstractSynthesizer> l = super.getSupportedSynthesizers();
		HComponent c = (HComponent) this.getConfiguration();
		if (c.isAbstractConfiguration()) {
			l.add(new hPE.frontend.base.codegen.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new hPE.frontend.base.codegen.c_sharp.HBESynthesizerCSharpConcrete());
		}
		return l;
	} */
	
}
