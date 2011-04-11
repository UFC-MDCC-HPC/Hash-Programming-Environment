package hPE.frontend.kinds.computation.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.activate.model.HActivateConfiguration;
import hPE.frontend.kinds.architecture.model.HArchitectureComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.facet.model.HFacetComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;

import org.eclipse.emf.common.util.URI;

public class HComputationComponent extends HActivateConfiguration {

	static final long serialVersionUID = -673692041250487494L;

	public static final String KIND = "Computation";


	public HComputationComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HUnit createUnit() {
		HUnit new_unit = new HComputationUnit(null, this);
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
		return "Computation";
	}
}
