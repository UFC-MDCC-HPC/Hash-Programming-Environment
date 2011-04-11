package hPE.frontend.kinds.application;

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
import hPE.frontend.kinds.application.edits.ApplicationComponentEditPart;
import hPE.frontend.kinds.application.edits.ApplicationConfigurationEditPart;
import hPE.frontend.kinds.application.edits.ApplicationEntryEditPart;
import hPE.frontend.kinds.application.edits.ApplicationInterfaceEditPart;
import hPE.frontend.kinds.application.edits.ApplicationInterfaceSliceEditPart;
import hPE.frontend.kinds.application.edits.ApplicationUnitEditPart;
import hPE.frontend.kinds.application.edits.ApplicationUnitSliceEditPart;
import hPE.frontend.kinds.application.figures.ApplicationComponentFigure;
import hPE.frontend.kinds.application.figures.ApplicationConfigurationFigure;
import hPE.frontend.kinds.application.figures.ApplicationEntryFigure;
import hPE.frontend.kinds.application.figures.ApplicationInterfaceFigure;
import hPE.frontend.kinds.application.figures.ApplicationInterfaceSliceFigure;
import hPE.frontend.kinds.application.figures.ApplicationUnitFigure;
import hPE.frontend.kinds.application.figures.ApplicationUnitSliceFigure;
import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.frontend.kinds.application.model.HApplicationInterface;
import hPE.frontend.kinds.application.model.HApplicationInterfaceSlice;
import hPE.frontend.kinds.application.model.HApplicationUnit;
import hPE.frontend.kinds.application.model.HApplicationUnitSlice;
import hPE.frontend.kinds.application.model.HApplicationUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = ApplicationKindConfiguration.class)
public class ApplicationKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HApplicationComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return true;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new ApplicationComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new ApplicationConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new ApplicationEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new ApplicationInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new ApplicationInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new ApplicationUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new ApplicationUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new ApplicationComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new ApplicationConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new ApplicationEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new ApplicationInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new ApplicationInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new ApplicationUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new ApplicationUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HApplicationComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HApplicationInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HApplicationInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HApplicationUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HApplicationUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HApplicationUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HApplicationUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HApplicationUnitStub(unit);
	}
}
