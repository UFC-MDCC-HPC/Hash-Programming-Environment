package hPE.frontend.kinds.computation;

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
import hPE.frontend.kinds.computation.edits.ComputationComponentEditPart;
import hPE.frontend.kinds.computation.edits.ComputationConfigurationEditPart;
import hPE.frontend.kinds.computation.edits.ComputationEntryEditPart;
import hPE.frontend.kinds.computation.edits.ComputationInterfaceEditPart;
import hPE.frontend.kinds.computation.edits.ComputationInterfaceSliceEditPart;
import hPE.frontend.kinds.computation.edits.ComputationUnitEditPart;
import hPE.frontend.kinds.computation.edits.ComputationUnitSliceEditPart;
import hPE.frontend.kinds.computation.figures.ComputationComponentFigure;
import hPE.frontend.kinds.computation.figures.ComputationConfigurationFigure;
import hPE.frontend.kinds.computation.figures.ComputationEntryFigure;
import hPE.frontend.kinds.computation.figures.ComputationInterfaceFigure;
import hPE.frontend.kinds.computation.figures.ComputationInterfaceSliceFigure;
import hPE.frontend.kinds.computation.figures.ComputationUnitFigure;
import hPE.frontend.kinds.computation.figures.ComputationUnitSliceFigure;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.computation.model.HComputationInterface;
import hPE.frontend.kinds.computation.model.HComputationInterfaceSlice;
import hPE.frontend.kinds.computation.model.HComputationUnit;
import hPE.frontend.kinds.computation.model.HComputationUnitSlice;
import hPE.frontend.kinds.computation.model.HComputationUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = ComputationKindConfiguration.class)
public class ComputationKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HComputationComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return true;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new ComputationComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new ComputationConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new ComputationEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new ComputationInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new ComputationInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new ComputationUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new ComputationUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new ComputationComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new ComputationConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new ComputationEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new ComputationInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new ComputationInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new ComputationUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new ComputationUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HComputationComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HComputationInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HComputationInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HComputationUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HComputationUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HComputationUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HComputationUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HComputationUnitStub(unit, enc);
	}
}
