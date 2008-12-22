package hPE.frontend.kinds.data.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.interfaces.IPortType;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.codegen.HBEAbstractSynthesizer;
import hPE.frontend.kinds.base.model.HHasPortsInterface;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;

public class HDataInterface extends HHasPortsInterface implements IPortType {

	static final long serialVersionUID = 1;

	public HDataInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit u, Point where) throws HPEAbortException {
		super(configuration, signature,u, where);
	}

	public String getId() {
		return getName2();
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
	
	

	
}
