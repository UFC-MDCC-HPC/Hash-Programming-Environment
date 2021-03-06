package hPE.frontend.kinds.certifier.model;

import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.base.model.HHasPortsInterface;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;

public class HCertifierInterface extends HActivateInterface  {

	static final long serialVersionUID = 1;

	public HCertifierInterface(HComponent configuration,
			HInterfaceSig signature, IHPrimUnit unit, Point where)  throws HPEAbortException {
		super(configuration, signature, unit, where);
		// TODO Auto-generated constructor stub
	}

	public List<HBEAbstractSynthesizer> getSupportedSynthesizers() {
		List<HBEAbstractSynthesizer> l = super.getSupportedSynthesizers();
		HComponent c = (HComponent) this.getConfiguration();
		if (c.isAbstractConfiguration()) {
			l.add(new hPE.frontend.base.codegen.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new hPE.frontend.base.codegen.c_sharp.HBESynthesizerCSharpConcrete());
		}
		return l;
	}

	@Override
	public String getActivateMethodName() {
		// TODO Auto-generated method stub
		return "certify";
	}

}
