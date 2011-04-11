package hPE.frontend.kinds.data;

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
import hPE.frontend.kinds.data.edits.DataComponentEditPart;
import hPE.frontend.kinds.data.edits.DataConfigurationEditPart;
import hPE.frontend.kinds.data.edits.DataEntryEditPart;
import hPE.frontend.kinds.data.edits.DataInterfaceEditPart;
import hPE.frontend.kinds.data.edits.DataInterfaceSliceEditPart;
import hPE.frontend.kinds.data.edits.DataUnitEditPart;
import hPE.frontend.kinds.data.edits.DataUnitSliceEditPart;
import hPE.frontend.kinds.data.figures.DataComponentFigure;
import hPE.frontend.kinds.data.figures.DataConfigurationFigure;
import hPE.frontend.kinds.data.figures.DataEntryFigure;
import hPE.frontend.kinds.data.figures.DataInterfaceFigure;
import hPE.frontend.kinds.data.figures.DataInterfaceSliceFigure;
import hPE.frontend.kinds.data.figures.DataUnitFigure;
import hPE.frontend.kinds.data.figures.DataUnitSliceFigure;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.data.model.HDataInterface;
import hPE.frontend.kinds.data.model.HDataInterfaceSlice;
import hPE.frontend.kinds.data.model.HDataUnit;
import hPE.frontend.kinds.data.model.HDataUnitSlice;
import hPE.frontend.kinds.data.model.HDataUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = DataKindConfiguration.class)
public class DataKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HDataComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return true;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new DataComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new DataConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new DataEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new DataInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new DataInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new DataUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new DataUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new DataComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new DataConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new DataEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new DataInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new DataInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new DataUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new DataUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HDataComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HDataInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HDataInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HDataUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HDataUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HDataUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HDataUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HDataUnitStub(unit, enc);
	}
}
