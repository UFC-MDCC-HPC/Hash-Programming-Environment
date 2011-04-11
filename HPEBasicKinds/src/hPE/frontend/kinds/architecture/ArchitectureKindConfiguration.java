package hPE.frontend.kinds.architecture;

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
import hPE.frontend.kinds.architecture.edits.ArchitectureComponentEditPart;
import hPE.frontend.kinds.architecture.edits.ArchitectureConfigurationEditPart;
import hPE.frontend.kinds.architecture.edits.ArchitectureEntryEditPart;
import hPE.frontend.kinds.architecture.edits.ArchitectureInterfaceEditPart;
import hPE.frontend.kinds.architecture.edits.ArchitectureInterfaceSliceEditPart;
import hPE.frontend.kinds.architecture.edits.ArchitectureUnitEditPart;
import hPE.frontend.kinds.architecture.edits.ArchitectureUnitSliceEditPart;
import hPE.frontend.kinds.architecture.figures.ArchitectureComponentFigure;
import hPE.frontend.kinds.architecture.figures.ArchitectureConfigurationFigure;
import hPE.frontend.kinds.architecture.figures.ArchitectureEntryFigure;
import hPE.frontend.kinds.architecture.figures.ArchitectureInterfaceFigure;
import hPE.frontend.kinds.architecture.figures.ArchitectureInterfaceSliceFigure;
import hPE.frontend.kinds.architecture.figures.ArchitectureUnitFigure;
import hPE.frontend.kinds.architecture.figures.ArchitectureUnitSliceFigure;
import hPE.frontend.kinds.architecture.model.HArchitectureComponent;
import hPE.frontend.kinds.architecture.model.HArchitectureInterface;
import hPE.frontend.kinds.architecture.model.HArchitectureInterfaceSlice;
import hPE.frontend.kinds.architecture.model.HArchitectureUnit;
import hPE.frontend.kinds.architecture.model.HArchitectureUnitSlice;
import hPE.frontend.kinds.architecture.model.HArchitectureUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = ArchitectureKindConfiguration.class)
public class ArchitectureKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HArchitectureComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return true;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new ArchitectureComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new ArchitectureConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new ArchitectureEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new ArchitectureInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new ArchitectureInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new ArchitectureUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new ArchitectureUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new ArchitectureComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new ArchitectureConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new ArchitectureEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new ArchitectureInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new ArchitectureInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new ArchitectureUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new ArchitectureUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HArchitectureComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HArchitectureInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HArchitectureInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HArchitectureUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HArchitectureUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HArchitectureUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HArchitectureUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HArchitectureUnitStub(unit);
	}
}
