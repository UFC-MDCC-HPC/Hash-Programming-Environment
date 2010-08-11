package hPE.frontend.kinds.base.model;

import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.edits.EntryEditPart;
import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.edits.InterfaceSliceEditPart;
import hPE.frontend.base.edits.UnitEditPart;
import hPE.frontend.base.edits.UnitSliceEditPart;
import hPE.frontend.base.figures.ComponentFigure;
import hPE.frontend.base.figures.ConfigurationFigure;
import hPE.frontend.base.figures.EntryFigure;
import hPE.frontend.base.figures.InterfaceFigure;
import hPE.frontend.base.figures.InterfaceSliceFigure;
import hPE.frontend.base.figures.UnitFigure;
import hPE.frontend.base.figures.UnitSliceFigure;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.facet.model.HFacetComponent;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;

public abstract class HBaseKindComponent extends HComponent {

	static final long serialVersionUID = -4285302639541705189L;
	
	public HBaseKindComponent(String name, IPackageLocation location, URI uri) {
		super(name, location,uri);
		// TODO Auto-generated constructor stub
	}

	public void loadComponent(HComponent c, Point where) {
		super.loadComponent(c,where);
	}

	public boolean accepts(IComponent c) {
		if (c instanceof HFacetComponent) return true;
		return super.accepts(c);
	}
	
	public Class<? extends ComponentEditPart<?, ?>> getComponentEditPartClass() {
		return null;
	}
	
	public Class<? extends ConfigurationEditPart<?, ?>> getConfigurationEditPartClass() {
		return null;
	}
	
	public Class<? extends EntryEditPart<?, ?>> getEntryEditPartClass() {
		return null;
	}
	
	public Class<? extends InterfaceEditPart<?, ?>> getInterfaceEditPartClass() {
		return null;
	}
	
	public Class<? extends InterfaceSliceEditPart<?, ?>> getInterfaceSliceEditPartClass() {
		return null;
	}
	
	public Class<? extends UnitEditPart<?, ?>> getUnitEditPartClass() {
		return null;
	}
	
	public Class<? extends UnitSliceEditPart<?, ?>> getUnitSliceEditPartClass() {
		return null;
	}
	
	public Class<? extends ComponentFigure> getComponentFigureClass() {
		return null;
	}
	
	public Class<? extends ConfigurationFigure> getConfigurationFigureClass() {
		return null;
	}
	
	public Class<? extends EntryFigure> getEntryFigureClass() {
		return null;
	}
	
	public Class<? extends InterfaceFigure> getInterfaceFigureClass() {
		return null;
	}
	
	public Class<? extends InterfaceSliceFigure> getInterfaceSliceFigureClass() {
		return null;
	}
	
	public Class<? extends UnitFigure> getUnitFigureClass() {
		return null;
	}
	
	public Class<? extends UnitSliceFigure> getUnitSliceFigureClass() {
		return null;
	}
	
	public Class<? extends HBaseKindComponent> getHBaseKindComponentClass() {
		return null;
	}
	
	public Class<? extends HBaseKindInterface> getHBaseKindInterfaceClass() {
		return null;
	}
	
	public Class<? extends HInterfaceSlice> getHInterfaceSliceClass() {
		return null;
	}
	
	public Class<? extends HUnit> getHUnitClass() {
		return null;
	}
	
	public Class<? extends HUnitSlice> getHUnitSliceClass() {
		return null;
	}
	
	public Class<? extends HUnitStub> getHUnitStubClass() {
		return null;
	}
	
	public Class<? extends IHUnit> getIHUnitClass() {
		return null;
	}	
}
