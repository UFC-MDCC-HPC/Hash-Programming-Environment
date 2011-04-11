package hPE.frontend.kinds.synchronization;

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
import hPE.frontend.kinds.synchronization.edits.SynchronizationComponentEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationConfigurationEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationEntryEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationInterfaceEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationInterfaceSliceEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationUnitEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationUnitSliceEditPart;
import hPE.frontend.kinds.synchronization.figures.SynchronizationComponentFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationConfigurationFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationEntryFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationInterfaceFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationInterfaceSliceFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationUnitFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationUnitSliceFigure;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationInterface;
import hPE.frontend.kinds.synchronization.model.HSynchronizationInterfaceSlice;
import hPE.frontend.kinds.synchronization.model.HSynchronizationUnit;
import hPE.frontend.kinds.synchronization.model.HSynchronizationUnitSlice;
import hPE.frontend.kinds.synchronization.model.HSynchronizationUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = SynchronizationKindConfiguration.class)
public class SynchronizationKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HSynchronizationComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return true;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new SynchronizationComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new SynchronizationConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new SynchronizationEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new SynchronizationInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new SynchronizationInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new SynchronizationUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new SynchronizationUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new SynchronizationComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new SynchronizationConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new SynchronizationEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new SynchronizationInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new SynchronizationInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new SynchronizationUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new SynchronizationUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HSynchronizationComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HSynchronizationInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HSynchronizationInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HSynchronizationUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HSynchronizationUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HSynchronizationUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HSynchronizationUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HSynchronizationUnitStub(unit, enc);
	}
}
