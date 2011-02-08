package hPE.frontend.kinds.application.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.architecture.model.HArchitectureComponent;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.facet.model.HFacetComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

public class HApplicationComponent extends HComputationComponent {

	static final long serialVersionUID = 1;

	public static final String KIND = "Application";

	public HApplicationComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
		HUnit new_unit = new HApplicationUnit(null, this);
		return new_unit;
	}

	@Override
	public boolean accepts(IComponent c) {
		if (c instanceof HFacetComponent) return true;
		if (c instanceof HQualifierComponent) return true;
		if (c instanceof HDataComponent) return true;
		if (c instanceof HArchitectureComponent) return true;
		if (c instanceof HEnvironmentComponent) return true;
		if (c instanceof HSynchronizationComponent) return true;
		if (c instanceof HComputationComponent) return true;
		if (c instanceof HEnumeratorComponent) return true;
		return super.accepts(c);
	}

	@Override
	public String kindString() {
		return "Application";
	}

	public HArchitectureComponent getArchitecture() {
		Iterator<HComponent> cs = getComponents().iterator();
		while (cs.hasNext()) {
			HComponent c = cs.next();
			if (c instanceof HArchitectureComponent) return (HArchitectureComponent) c;
		}

		return null;
	}

	public HEnvironmentComponent getEnvironment() {
		Iterator<HComponent> cs = getComponents().iterator();
		while (cs.hasNext()) {
			HComponent c = cs.next();
			if (c instanceof HEnvironmentComponent) return (HEnvironmentComponent) c;
		}

		return null;
	}

	@Override
	public void loadComponent(HComponent c, Point where) {
		super.loadComponent(c, where);

		c.setExposed(false);
		for (HComponent cc : c.getExposedComponents()) {
			cc.setExposed(false);
		}
	}

}
