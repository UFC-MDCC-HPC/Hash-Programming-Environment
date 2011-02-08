package hPE.frontend.kinds.enumerator;

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
import hPE.frontend.kinds.enumerator.edits.EnumeratorComponentEditPart;
import hPE.frontend.kinds.enumerator.edits.EnumeratorConfigurationEditPart;
import hPE.frontend.kinds.enumerator.edits.EnumeratorEntryEditPart;
import hPE.frontend.kinds.enumerator.edits.EnumeratorInterfaceEditPart;
import hPE.frontend.kinds.enumerator.edits.EnumeratorInterfaceSliceEditPart;
import hPE.frontend.kinds.enumerator.edits.EnumeratorUnitEditPart;
import hPE.frontend.kinds.enumerator.edits.EnumeratorUnitSliceEditPart;
import hPE.frontend.kinds.enumerator.figures.EnumeratorComponentFigure;
import hPE.frontend.kinds.enumerator.figures.EnumeratorConfigurationFigure;
import hPE.frontend.kinds.enumerator.figures.EnumeratorEntryFigure;
import hPE.frontend.kinds.enumerator.figures.EnumeratorInterfaceFigure;
import hPE.frontend.kinds.enumerator.figures.EnumeratorInterfaceSliceFigure;
import hPE.frontend.kinds.enumerator.figures.EnumeratorUnitFigure;
import hPE.frontend.kinds.enumerator.figures.EnumeratorUnitSliceFigure;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;
import hPE.frontend.kinds.enumerator.model.HEnumeratorInterface;
import hPE.frontend.kinds.enumerator.model.HEnumeratorInterfaceSlice;
import hPE.frontend.kinds.enumerator.model.HEnumeratorUnit;
import hPE.frontend.kinds.enumerator.model.HEnumeratorUnitSlice;
import hPE.frontend.kinds.enumerator.model.HEnumeratorUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = EnumeratorKindConfiguration.class)
public class EnumeratorKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HEnumeratorComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return true;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new EnumeratorComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new EnumeratorConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new EnumeratorEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new EnumeratorInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new EnumeratorInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new EnumeratorUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new EnumeratorUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new EnumeratorComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new EnumeratorConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new EnumeratorEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new EnumeratorInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new EnumeratorInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new EnumeratorUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new EnumeratorUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HEnumeratorComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HEnumeratorInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HEnumeratorInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HEnumeratorUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HEnumeratorUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HEnumeratorUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HEnumeratorUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HEnumeratorUnitStub(unit, enc);
	}
}
