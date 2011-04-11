package hPE.frontend.kinds.environment;

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
import hPE.frontend.kinds.environment.edits.EnvironmentComponentEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentConfigurationEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentEntryEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentInterfaceEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentInterfaceSliceEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentUnitEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentUnitSliceEditPart;
import hPE.frontend.kinds.environment.figures.EnvironmentComponentFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentConfigurationFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentEntryFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentInterfaceFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentInterfaceSliceFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentUnitFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentUnitSliceFigure;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentInterface;
import hPE.frontend.kinds.environment.model.HEnvironmentInterfaceSlice;
import hPE.frontend.kinds.environment.model.HEnvironmentUnit;
import hPE.frontend.kinds.environment.model.HEnvironmentUnitSlice;
import hPE.frontend.kinds.environment.model.HEnvironmentUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = EnvironmentKindConfiguration.class)
public class EnvironmentKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HEnvironmentComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return true;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new EnvironmentComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new EnvironmentConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new EnvironmentEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new EnvironmentInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new EnvironmentInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new EnvironmentUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new EnvironmentUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new EnvironmentComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new EnvironmentConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new EnvironmentEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new EnvironmentInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new EnvironmentInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new EnvironmentUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new EnvironmentUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HEnvironmentComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HEnvironmentInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HEnvironmentInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HEnvironmentUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HEnvironmentUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HEnvironmentUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HEnvironmentUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HEnvironmentUnitStub(unit);
	}
}
