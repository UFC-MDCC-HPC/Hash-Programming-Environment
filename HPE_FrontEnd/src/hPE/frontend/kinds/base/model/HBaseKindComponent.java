package hPE.frontend.kinds.base.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.kinds.certifier.model.HCertifierComponent;

public abstract class HBaseKindComponent extends HComponent {

	static final long serialVersionUID = -4285302639541705189L;
	
	public HBaseKindComponent(String name, IPackageLocation location, URI uri) {
		super(name, location,uri);
		// TODO Auto-generated constructor stub
	}

	public void loadComponent(HComponent c, Point where) {
		super.loadComponent(c,where);
	}

	public boolean accepts(IComponent c) {
		//if (c instanceof HFacetComponent) return true;
		return super.accepts(c);
	}
	
}
