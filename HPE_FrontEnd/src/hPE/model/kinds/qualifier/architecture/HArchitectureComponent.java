package hPE.model.kinds.qualifier.architecture;

import org.eclipse.emf.common.util.URI;

import hPE.model.base.HComponent;
import hPE.model.base.HUnit;
import hPE.model.interfaces.IComponent;
import hPE.model.interfaces.IPackageLocation;
import hPE.model.kinds.activate.computation.application.HApplicationUnit;
import hPE.model.kinds.base.HBaseKindComponent;
import hPE.model.kinds.qualifier.HQualifierComponent;
import hPE.model.kinds.qualifier.environment.HEnvironmentComponent;

public class HArchitectureComponent extends HQualifierComponent {

	static final long serialVersionUID = -7558041779453648336L;

	public static final String KIND = "Architecture";

	public HArchitectureComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HArchitectureUnit(null, this);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HQualifierComponent) return true;
    	if (c instanceof HArchitectureComponent) return true;
    	if (c instanceof HEnvironmentComponent) return true;
    	return false;
    }
    
    public String kindString() {
    	return "Architecture";
    }

}
