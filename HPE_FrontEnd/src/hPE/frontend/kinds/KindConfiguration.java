package hPE.frontend.kinds;

import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.edits.EntryEditPart;
import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.edits.InterfaceSliceEditPart;
import hPE.frontend.base.edits.UnitEditPart;
import hPE.frontend.base.edits.UnitSliceEditPart;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.exceptions.HPENotFusableSlicesException;
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
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.base.model.HBaseKindInterface;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

/**
 * Base class of a kind configuration.
 * Every kind must have only one KindConfiguration subclass.
 * 
 * @author Rafael Sales - rafaelcds@gmail.com
 */
public abstract class KindConfiguration {

	public abstract String getName();
	
	public abstract ComponentEditPart<?, ?> newComponentEditPart();

	public abstract ConfigurationEditPart<?, ?> newConfigurationEditPart();

	public abstract EntryEditPart<?, ?> newEntryEditPart();

	public abstract InterfaceEditPart<?, ?> newInterfaceEditPart();

	public abstract InterfaceSliceEditPart<?, ?> newInterfaceSliceEditPart();

	public abstract UnitEditPart<?, ?> newUnitEditPart();

	public abstract UnitSliceEditPart<?, ?> newUnitSliceEditPart();

	public abstract ComponentFigure newComponentFigure();

	public abstract ConfigurationFigure newConfigurationFigure();

	public abstract EntryFigure newEntryFigure();

	public abstract InterfaceFigure newInterfaceFigure();

	public abstract InterfaceSliceFigure newInterfaceSliceFigure();

	public abstract UnitFigure newUnitFigure();

	public abstract UnitSliceFigure newUnitSliceFigure();

	public abstract HBaseKindComponent newHBaseKindComponent(String name, IPackageLocation location, URI uri);

	public abstract HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where) throws HPENotFusableSlicesException;

	public abstract HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor);

	public abstract HUnit newHUnit(String name, HComponent configuration, HInterface which_interface);
	
	public abstract HUnit newHUnit(String name, HComponent configuration);

	public abstract HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException;

	public abstract HUnitStub newHUnitStub(IHUnit unit);
	
	public abstract HUnitStub newHUnitStub(IHUnit unit, HComponent enc);
}
