package hPE.frontend.kinds.platform.model;

import org.eclipse.emf.common.util.URI;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.application.model.HApplicationUnit;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;

public class HPlatformComponent extends HQualifierComponent {

	static final long serialVersionUID = -7558041779453648336L;

	public static final String KIND = "Architecture";

	public HPlatformComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HPlatformUnit(null, this);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HQualifierComponent) return true;
    	if (c instanceof HPlatformComponent) return true;
    	if (c instanceof HEnvironmentComponent) return true;
    	return super.accepts(c);
    }
    
    public String kindString() {
    	return "Platform";
    }

}
