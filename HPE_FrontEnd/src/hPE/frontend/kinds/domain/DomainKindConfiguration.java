package hPE.frontend.kinds.domain;

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
import hPE.frontend.kinds.domain.edits.DomainComponentEditPart;
import hPE.frontend.kinds.domain.edits.DomainConfigurationEditPart;
import hPE.frontend.kinds.domain.edits.DomainEntryEditPart;
import hPE.frontend.kinds.domain.edits.DomainInterfaceEditPart;
import hPE.frontend.kinds.domain.edits.DomainInterfaceSliceEditPart;
import hPE.frontend.kinds.domain.edits.DomainUnitEditPart;
import hPE.frontend.kinds.domain.edits.DomainUnitSliceEditPart;
import hPE.frontend.kinds.domain.figures.DomainComponentFigure;
import hPE.frontend.kinds.domain.figures.DomainConfigurationFigure;
import hPE.frontend.kinds.domain.figures.DomainEntryFigure;
import hPE.frontend.kinds.domain.figures.DomainInterfaceFigure;
import hPE.frontend.kinds.domain.figures.DomainInterfaceSliceFigure;
import hPE.frontend.kinds.domain.figures.DomainUnitFigure;
import hPE.frontend.kinds.domain.figures.DomainUnitSliceFigure;
import hPE.frontend.kinds.domain.model.HDomainComponent;
import hPE.frontend.kinds.domain.model.HDomainInterface;
import hPE.frontend.kinds.domain.model.HDomainInterfaceSlice;
import hPE.frontend.kinds.domain.model.HDomainUnit;
import hPE.frontend.kinds.domain.model.HDomainUnitSlice;
import hPE.frontend.kinds.domain.model.HDomainUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = DomainKindConfiguration.class)
public class DomainKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HDomainComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return true;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new DomainComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new DomainConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new DomainEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new DomainInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new DomainInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new DomainUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new DomainUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new DomainComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new DomainConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new DomainEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new DomainInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new DomainInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new DomainUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new DomainUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HDomainComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HDomainInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HDomainInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HDomainUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HDomainUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HDomainUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HDomainUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HDomainUnitStub(unit, enc);
	}
}
