package hPE.frontend.kinds.service;

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
import hPE.frontend.kinds.service.edits.ServiceComponentEditPart;
import hPE.frontend.kinds.service.edits.ServiceConfigurationEditPart;
import hPE.frontend.kinds.service.edits.ServiceEntryEditPart;
import hPE.frontend.kinds.service.edits.ServiceInterfaceEditPart;
import hPE.frontend.kinds.service.edits.ServiceInterfaceSliceEditPart;
import hPE.frontend.kinds.service.edits.ServiceUnitEditPart;
import hPE.frontend.kinds.service.edits.ServiceUnitSliceEditPart;
import hPE.frontend.kinds.service.figures.ServiceComponentFigure;
import hPE.frontend.kinds.service.figures.ServiceConfigurationFigure;
import hPE.frontend.kinds.service.figures.ServiceEntryFigure;
import hPE.frontend.kinds.service.figures.ServiceInterfaceFigure;
import hPE.frontend.kinds.service.figures.ServiceInterfaceSliceFigure;
import hPE.frontend.kinds.service.figures.ServiceUnitFigure;
import hPE.frontend.kinds.service.figures.ServiceUnitSliceFigure;
import hPE.frontend.kinds.service.model.HServiceComponent;
import hPE.frontend.kinds.service.model.HServiceInterface;
import hPE.frontend.kinds.service.model.HServiceInterfaceSlice;
import hPE.frontend.kinds.service.model.HServiceUnit;
import hPE.frontend.kinds.service.model.HServiceUnitSlice;
import hPE.frontend.kinds.service.model.HServiceUnitStub;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

@Kind(kindConfigurationClass = ServiceKindConfiguration.class)
public class ServiceKindConfiguration extends KindConfiguration {

	@Override
	public String getName() {
		return HServiceComponent.KIND;
	}

	@Override
	public boolean isConcretizable() {
		return true;
	}

	@Override
	public ComponentEditPart<?, ?> newComponentEditPart() {
		return new ServiceComponentEditPart();
	}

	@Override
	public ConfigurationEditPart<?, ?> newConfigurationEditPart() {
		return new ServiceConfigurationEditPart();
	}

	@Override
	public EntryEditPart<?, ?> newEntryEditPart() {
		return new ServiceEntryEditPart();
	}

	@Override
	public InterfaceEditPart<?, ?> newInterfaceEditPart() {
		return new ServiceInterfaceEditPart();
	}

	@Override
	public InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart() {
		return new ServiceInterfaceSliceEditPart();
	}

	@Override
	public UnitEditPart<?, ?> newUnitEditPart() {
		return new ServiceUnitEditPart();
	}

	@Override
	public UnitSliceEditPart<?, ?> newUnitSliceEditPart() {
		return new ServiceUnitSliceEditPart();
	}

	@Override
	public ComponentFigure newComponentFigure() {
		return new ServiceComponentFigure();
	}

	@Override
	public ConfigurationFigure newConfigurationFigure() {
		return new ServiceConfigurationFigure();
	}

	@Override
	public EntryFigure newEntryFigure() {
		return new ServiceEntryFigure();
	}

	@Override
	public InterfaceFigure newInterfaceFigure() {
		return new ServiceInterfaceFigure();
	}

	@Override
	public InterfaceSliceFigure newInterfaceSliceFigure() {
		return new ServiceInterfaceSliceFigure();
	}

	@Override
	public UnitFigure newUnitFigure() {
		return new ServiceUnitFigure();
	}

	@Override
	public UnitSliceFigure newUnitSliceFigure() {
		return new ServiceUnitSliceFigure();
	}

	@Override
	public HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri) {
		return new HServiceComponent(name, location, uri);
	}

	@Override
	public HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where)
	throws HPEAbortException {
		return new HServiceInterface(configuration, signature, unit, where);
	}

	@Override
	public HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor) {
		return new HServiceInterfaceSlice(name, whichInterface, interfaceSig, nestingFactor);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration, HInterface which_interface) {
		return new HServiceUnit(name, configuration, which_interface);
	}

	@Override
	public HUnit newHUnit(String name, HComponent configuration) {
		return new HServiceUnit(name, configuration);
	}

	@Override
	public HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		return new HServiceUnitSlice(unit, unitEntry, where);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit) {
		return new HServiceUnitStub(unit);
	}

	@Override
	public HUnitStub newHUnitStub(IHUnit unit, HComponent enc) {
		return new HServiceUnitStub(unit, enc);
	}
}
