package hPE.model.kinds.data;

import hPE.backend.cluster.synthesizer.HBEAbstractSynthesizer;
import hPE.model.base.HComponent;
import hPE.model.base.HInterfaceSig;
import hPE.model.base.IHPrimUnit;
import hPE.model.base.exceptions.HPEAbortException;
import hPE.model.interfaces.IPortType;
import hPE.model.kinds.base.HHasPortsInterface;

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
			l.add(new hPE.backend.cluster.synthesizer.base.c_sharp.HBESynthesizerCSharpAbstract());
		}
		else {
			l.add(new hPE.backend.cluster.synthesizer.base.c_sharp.HBESynthesizerCSharpConcrete());
		}
		return l;
	}
	
	

	
}
