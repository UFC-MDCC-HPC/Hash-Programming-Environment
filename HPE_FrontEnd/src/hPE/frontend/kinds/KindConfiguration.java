package hPE.frontend.kinds;

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
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.base.model.HBaseKindInterface;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.ui.actions.SelectionAction;

/**
 * Base class of a kind configuration.
 * Every kind must have only one KindConfiguration subclass.
 * 
 * @author Rafael Sales - rafaelcds@gmail.com
 */
public abstract class KindConfiguration implements Comparable<KindConfiguration> {

	public abstract String getName();

	public abstract boolean isConcretizable();

	@Override
	public int compareTo(KindConfiguration kind) {
		return this.getName().compareTo(kind.getName());
	}

	/**
	 * Gets the list of implementing HComponent classes of the kinds that should
	 * accept this kind's components as inner components.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Class<? extends HComponent>[] getSupportedSuperComponents() {
		return new Class[0];
	}

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

	public abstract HBaseKindInterface newHBaseKindInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where) throws HPEAbortException;

	public abstract HInterfaceSlice newHInterfaceSlice(String name, HInterface whichInterface, HInterfaceSig interfaceSig, int nestingFactor);

	public abstract HUnit newHUnit(String name, HComponent configuration, HInterface which_interface);

	public abstract HUnit newHUnit(String name, HComponent configuration);

	public abstract HUnitSlice newHUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException;

	public abstract HUnitStub newHUnitStub(IHUnit unit);

	public abstract HUnitStub newHUnitStub(IHUnit unit, HComponent enc);

	public List<SelectionAction> createActionsForConfiguration(HComponent configuration) {
		return new ArrayList<SelectionAction>();
	}
}
