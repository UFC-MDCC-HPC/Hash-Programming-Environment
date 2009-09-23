package hPE.frontend.kinds.enumerator.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.architecture.model.HArchitectureComponent;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;

import org.eclipse.draw2d.geometry.Rectangle;
import java.util.List;

import org.eclipse.emf.common.util.URI;

public class HEnumeratorComponent extends HBaseKindComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2515274189846041617L;

	public static final String KIND = "Enumerator";

	private HLinkToReplicator linkToReplicator = null;

	public HEnumeratorComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		if (this.isAbstract()) {
			this.createUnit();
		}
	}

	@Override
	public HUnit createUnit() {
		List<IHUnit> us = this.getUnits();
		if (us.size() == 0) {
		 String cname = this.getComponentName();
	     HUnit new_unit = new HEnumeratorUnit(null, this);
	     new_unit.setName(cname.toLowerCase());
	     Rectangle box = new_unit.getBounds().getTranslated(0, -50);
	     try {
			HInterface new_interface = new_unit.createInterface(box.getTopLeft());
			new_interface.setName("I" + cname);
			
		} catch (HPEAbortException e) {
			e.printStackTrace();
		}
	     return new_unit;
		} else {
			return null;
		}
	     
	}
	
	public void setLinkToReplicator(HLinkToReplicator link) {
		this.linkToReplicator  = link;
	}
	
	public HLinkToReplicator getLinkToReplicator() {
		return this.linkToReplicator;
	}
	
    public boolean accepts(IComponent c) {  
	   	if (c instanceof HQualifierComponent) return true;
	   	if (c instanceof HEnumeratorComponent) return true;
    	return false;
    }

    public String kindString() {
    	return "Enumerator";
    }    

}
