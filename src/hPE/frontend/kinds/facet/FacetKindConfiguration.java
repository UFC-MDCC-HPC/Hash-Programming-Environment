package hPE.frontend.kinds.facet;

import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.edits.EntryEditPart;
import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.edits.InterfaceSliceEditPart;
import hPE.frontend.base.edits.UnitEditPart;
import hPE.frontend.base.edits.UnitSliceEditPart;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.figures.ComponentFigure;
import hPE.frontend.base.figures.ConfigurationFigure;
import hPE.frontend.base.figures.EntryFigure;
import hPE.frontend.base.figures.InterfaceFigure;
import hPE.frontend.base.figures.InterfaceSliceFigure;
import hPE.frontend.base.figures.UnitFigure;
import hPE.frontend.base.figures.UnitSliceFigure;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.Kind;
import hPE.frontend.kinds.KindConfiguration;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.base.model.HBaseKindInterface;
import hPE.frontend.kinds.facet.edits.FacetComponentEditPart;
import hPE.frontend.kinds.facet.edits.FacetConfigurationEditPart;
import hPE.frontend.kinds.facet.edits.FacetEntryEditPart;
import hPE.frontend.kinds.facet.edits.FacetInterfaceEditPart;
import hPE.frontend.kinds.facet.edits.FacetInterfaceSliceEditPart;
import hPE.frontend.kinds.facet.edits.FacetUnitEditPart;
import hPE.frontend.kinds.facet.edits.FacetUnitSliceEditPart;
import hPE.frontend.kinds.facet.figures.FacetComponentFigure;
import hPE.frontend.kinds.facet.figures.FacetConfigurationFigure;
import hPE.frontend.kinds.facet.figures.FacetEntryFigure;
import hPE.frontend.kinds.facet.figures.FacetInterfaceFigure;
import hPE.frontend.kinds.facet.figures.FacetInterfaceSliceFigure;
import hPE.frontend.kinds.facet.figures.FacetUnitFigure;
import hPE.frontend.kinds.facet.figures.FacetUnitSliceFigure;
import hPE.frontend.kinds.facet.model.HFacetComponent;
import hPE.frontend.kinds.facet.model.HFacetInterface;
import hPE.frontend.kinds.facet.model.HFacetInterfaceSlice;
import hPE.frontend.kinds.facet.model.HFacetUnit;
import hPE.frontend.kinds.facet.model.HFacetUnitSlice;
import hPE.frontend.kinds.facet.model.HFacetUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = FacetKindConfiguration.class)
public class FacetKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HFacetComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return false;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new FacetComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new FacetConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new FacetEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new FacetInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new FacetInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new FacetUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new FacetUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new FacetComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new FacetConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new FacetEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new FacetInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new FacetInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new FacetUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new FacetUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HFacetComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HFacetInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HFacetInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HFacetUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HFacetUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HFacetUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HFacetUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HFacetUnitStub(unit, enc);
	}
}
