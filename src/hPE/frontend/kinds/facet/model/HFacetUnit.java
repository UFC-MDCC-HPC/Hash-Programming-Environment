package hPE.frontend.kinds.facet.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasPortsUnit;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.facet.FacetKindConfiguration;

import org.eclipse.draw2d.geometry.Point;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class HFacetUnit extends HHasPortsUnit implements IHFacetUnit {

	static final long serialVersionUID = 1;

	public HFacetUnit(String name, HComponent configuration, HInterface which_interface) {
		super(name, configuration, which_interface);
		// TODO Auto-generated constructor stub
	}

	public HFacetUnit(String name, HComponent configuration) {
		super(name, configuration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected HInterface newInterface(HComponent c, HInterfaceSig s, IHPrimUnit unit, Point l) throws HPEAbortException {
		return new HFacetInterface(c, s, unit, l);
	}

	@Override
	public HUnitSlice newSlice(IHUnit the_unit, Point where) throws HPEAbortException {
		return new HFacetUnitSlice(the_unit, this, where);
	}

	/*
	 * public HUnitStub createStub() { return new HQualifierUnitStub(this); }
	 */
}
