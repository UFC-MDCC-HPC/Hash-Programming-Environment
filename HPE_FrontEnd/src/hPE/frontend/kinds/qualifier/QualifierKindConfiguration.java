package hPE.frontend.kinds.qualifier;

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
import hPE.frontend.kinds.qualifier.edits.QualifierComponentEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierConfigurationEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierEntryEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierInterfaceEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierInterfaceSliceEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierUnitEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierUnitSliceEditPart;
import hPE.frontend.kinds.qualifier.figures.QualifierComponentFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierConfigurationFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierEntryFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierInterfaceFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierInterfaceSliceFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierUnitFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierUnitSliceFigure;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierInterface;
import hPE.frontend.kinds.qualifier.model.HQualifierInterfaceSlice;
import hPE.frontend.kinds.qualifier.model.HQualifierUnit;
import hPE.frontend.kinds.qualifier.model.HQualifierUnitSlice;
import hPE.frontend.kinds.qualifier.model.HQualifierUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = QualifierKindConfiguration.class)
public class QualifierKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HQualifierComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return false;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new QualifierComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new QualifierConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new QualifierEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new QualifierInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new QualifierInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new QualifierUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new QualifierUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new QualifierComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new QualifierConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new QualifierEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new QualifierInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new QualifierInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new QualifierUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new QualifierUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HQualifierComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HQualifierInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HQualifierInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HQualifierUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HQualifierUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HQualifierUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HQualifierUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HQualifierUnitStub(unit, enc);
	}
}
