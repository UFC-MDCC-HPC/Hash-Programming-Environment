package hPE.frontend.edits.base;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import hPE.frontend.edits.policies.base.SetSliceNameEditPolicy;
import hPE.frontend.edits.policies.base.ShowInterfaceEditPolicy;
import hPE.frontend.figures.base.InterfaceSliceFigure;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HLinkToInterface;
import hPE.model.base.IPropertyChangeListener;

public class InterfaceSliceEditPart<ModelType extends HInterfaceSlice, FigureType extends InterfaceSliceFigure> extends AbstractGraphicalEditPart 
                                      implements PropertyChangeListener{

	public InterfaceSliceEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {
		// TODO Auto-generated method stub
		return new InterfaceSliceFigure();
	}

	protected void createEditPolicies() {
		this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new ShowInterfaceEditPolicy());
		this.installEditPolicy("Set Slice Name", new SetSliceNameEditPolicy());

	}

	protected void refreshVisuals() {

  	    ModelType slice_abstraction = (ModelType) getModel();
  	    FigureType slice_abstraction_figure = (FigureType) getFigure();
  	    
  	    Rectangle u_bounds = ((AbstractGraphicalEditPart) getParent()).getFigure().getBounds();
        slice_abstraction_figure.setBounds(slice_abstraction.getBounds().getTranslated(u_bounds.getLocation()));
        
        if (slice_abstraction.getInterface() != null) { 
            slice_abstraction_figure.setBackgroundColor(((HInterface)slice_abstraction.getInterface()).getColor());
        }
        
	}
	
	
	public List getModelSourceConnections() {
		
		List r = new ArrayList();
		
		ModelType sliceAbstraction = (ModelType) getModel();
		
		HLinkToInterface i = sliceAbstraction.getLinkToInterface();
		if (i.visibleInterface() && !i.getWhich_interface().getHidden()) r.add(i);

			
		return r;
		
	}
	
	public void activate() {
        if (!isActive()) 
        	((IPropertyChangeListener) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((IPropertyChangeListener) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		if (ev.getPropertyName().equals(ModelType.PROPERTY_BOUNDS)) this.refreshVisuals();
		if (ev.getPropertyName().equals(ModelType.PROPERTY_COLOR)) {
			this.refreshVisuals();
		}
		if (ev.getPropertyName().equals(ModelType.INTERFACE_SHOW)) { 
			this.refreshSourceConnections();
			((ConfigurationEditPart)((InterfaceEditPart)this.getParent()).getParent()).refresh();

		}
		if (ev.getPropertyName().equals(ModelType.INTERFACE_HIDE)) { 
			this.refreshSourceConnections();
			((ConfigurationEditPart)((InterfaceEditPart)this.getParent()).getParent()).refresh();
		}
		if (ev.getPropertyName().equals(ModelType.RELOAD_PORTS)) {
			this.refreshChildren();
			this.refresh();
		}
	}
	
}
