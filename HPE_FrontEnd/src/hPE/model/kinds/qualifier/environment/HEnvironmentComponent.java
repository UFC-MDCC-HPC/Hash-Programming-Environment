package hPE.model.kinds.qualifier.environment;

import org.eclipse.emf.common.util.URI;

import hPE.model.base.HComponent;
import hPE.model.base.HUnit;
import hPE.model.interfaces.IComponent;
import hPE.model.interfaces.IPackageLocation;
import hPE.model.kinds.activate.computation.application.HApplicationUnit;
import hPE.model.kinds.base.HBaseKindComponent;
import hPE.model.kinds.qualifier.HQualifierComponent;

public class HEnvironmentComponent extends HQualifierComponent {

	static final long serialVersionUID = -6791198852352754920L;
	
	public static final String KIND = "Environment";

	public HEnvironmentComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HEnvironmentUnit(null, this);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HQualifierComponent) return true;
    	if (c instanceof HEnvironmentComponent) return true;
    	return false;
    }

    public String kindString() {
    	return "Environment";
    }    
    
}
