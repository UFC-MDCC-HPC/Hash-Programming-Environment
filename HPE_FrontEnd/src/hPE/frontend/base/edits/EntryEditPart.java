package hPE.frontend.base.edits;


import hPE.frontend.base.figures.EntryFigure;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HLinkToInterface;
import hPE.frontend.base.model.HPrimUnitStub;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.policies.LiftUnitEditPolicy;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;

import java.beans.PropertyChangeEvent;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;



import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

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
        entry_figure.setMultiple(entry.isMultiple());
        if (entry.getInterface() != null) {
        	entry_figure.setBackgroundColor(((HInterface)entry.getInterface()).getColor());
        } else
            entry_figure.setBackgroundColor(ColorConstants.black);
        
        Integer facet = entry.getFacet();
        Integer facet_instance = entry.getFacetInstance();
        entry_figure.setLabelText(facet.toString() + ":" + facet_instance.toString());
        
		Label ff = new Label(" unit " + entry.getName2() + (entry.isClone() || entry.isCloned() ? "." + entry.getSliceReplicaIndex() + " " : " "));
		Font font = new Font(null, "Arial", 10, SWT.ITALIC);
		ff.setFont(font);
		
		entry_figure.setToolTip(ff);

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
