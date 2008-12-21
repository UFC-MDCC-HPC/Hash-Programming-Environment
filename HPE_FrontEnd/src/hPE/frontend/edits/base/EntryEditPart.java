package hPE.frontend.edits.base;


import hPE.frontend.edits.policies.base.LiftUnitEditPolicy;
import hPE.frontend.edits.policies.base.UnitFlowLayoutEditPolicy;
import hPE.frontend.figures.base.EntryFigure;
import hPE.model.base.HBinding;
import hPE.model.base.HInterface;
import hPE.model.base.HLinkToInterface;
import hPE.model.base.HPrimUnitStub;
import hPE.model.base.HReplicator;
import hPE.model.base.HUnitStub;
import hPE.model.base.IHPrimUnit;
import hPE.model.base.IHUnit;
import hPE.model.base.IReplicatedElement;

import org.eclipse.draw2d.ColorConstants;

import java.beans.PropertyChangeEvent;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;



import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.EditPart;

public class EntryEditPart<ModelType extends IHUnit,
                           FigureType extends EntryFigure> extends BindingEndsEditPart {

	public EntryEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new EntryFigure();
	}
	
	protected void createEditPolicies() {
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
		// this.installEditPolicy("OpenSliceEditPolicy", new OpenSliceEditPolicy());
		this.installEditPolicy("LiftUnitEditPolicy", new LiftUnitEditPolicy());
        super.createEditPolicies();
	}
	
	
	protected void refreshVisuals() {

  	    IHUnit entry = (IHUnit) getModel();
  	    
  	    FigureType entry_figure = (FigureType) getFigure();
  	    
  	    Rectangle u_bounds = ((AbstractGraphicalEditPart) getParent()).getFigure().getBounds();
  	    
        entry_figure.setBounds(entry.getBounds().getTranslated(u_bounds.getLocation()));
        if (entry.getInterface() != null) {
        	entry_figure.setBackgroundColor(((HInterface)entry.getInterface()).getColor());
        } else
            entry_figure.setBackgroundColor(ColorConstants.black);
        
        // entry_figure.setOpen(entry.isOpen());
        

	}
	
	public List getModelSourceConnections() {

		List r = new ArrayList();

		for (HBinding b : ((ModelType) getModel()).getBindings()) {
		    if (b != null && b.isVisible()) r.add(b); 
		}

		ModelType u = (ModelType) this.getModel();
		
  	    if  (! (u instanceof HUnitStub)) { // (!(u.getBinding() != null && b.getPort() instanceof HPrimUnitStub)) {			
			HLinkToInterface i = ((ModelType) getModel()).getLinkToInterface();
			if (i!=null)
			     if (i.visibleInterface() && !i.getWhich_interface().getHidden()) r.add(i);
	
			Collection j = ((IReplicatedElement) getModel()).getLinksToVisibleReplicators();
			if (j!=null) r.addAll(j);
  	    }	
		
		return r;
	} 

	public List getModelTargetConnections() {
		
		return new ArrayList();
	} 
	
	
	public void propertyChange(PropertyChangeEvent ev) {
		super.propertyChange(ev);
		if (ev.getPropertyName().equals(ModelType.PROPERTY_BOUNDS)) { 
			this.refreshVisuals();
		}
		if (ev.getPropertyName().equals(ModelType.PROPERTY_COLOR)) {
			this.refreshVisuals();
		}
		if (ev.getPropertyName().equals(ModelType.BINDING_CREATE_SOURCE)) this.refreshSourceConnections();
		if (ev.getPropertyName().equals(ModelType.INTERFACE_SHOW)) {
			this.refreshSourceConnections();
			EditPart parent_part = getParent();
			while (parent_part instanceof EntryEditPart) {
				parent_part = parent_part.getParent();
			}
			((ConfigurationEditPart)((ComponentEditPart) parent_part).getParent()).refresh();
		}
		if (ev.getPropertyName().equals(ModelType.INTERFACE_HIDE)) {
			this.refreshSourceConnections();
			EditPart parent_part = getParent();
			while (parent_part instanceof EntryEditPart) {
				parent_part = parent_part.getParent();
			}
			((ConfigurationEditPart)((ComponentEditPart) parent_part).getParent()).refresh();
		}
		if (ev.getPropertyName().equals(ModelType.REPLICATED)) {
			this.refreshSourceConnections();
			EditPart parent_part = getParent();
			while (parent_part instanceof EntryEditPart) {
				parent_part = parent_part.getParent();
			}
			((ConfigurationEditPart)((ComponentEditPart) parent_part).getParent()).refresh();
		}
		if (ev.getPropertyName().equals(ModelType.OPEN_SLICE)) { 
			this.refreshVisuals();
			this.refreshChildren();
		}
		
	}

	
	public List getModelChildren() {
		
		ModelType model = (ModelType) getModel();
		List children = new ArrayList();
		
		// if (model.isOpen()) children.addAll(model.getInnerEntries());
		
	    return children;		
	}	
		
	
		
	
}
