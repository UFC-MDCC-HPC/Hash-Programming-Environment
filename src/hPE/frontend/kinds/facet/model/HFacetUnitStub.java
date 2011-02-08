package hPE.frontend.kinds.facet.model;

import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.facet.FacetKindConfiguration;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class HFacetUnitStub extends HUnitStub implements IHFacetUnit {

	static final long serialVersionUID = 1;

	public HFacetUnitStub(IHUnit unit) {
		super(unit);
	}

	public HFacetUnitStub(IHUnit unit, HComponent enc) {
		super(unit, enc);
	}
}
