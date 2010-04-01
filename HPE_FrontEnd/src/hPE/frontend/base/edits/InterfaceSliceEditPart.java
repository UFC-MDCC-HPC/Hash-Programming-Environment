package hPE.frontend.base.edits;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import hPE.frontend.base.figures.InterfaceSliceFigure;
import hPE.frontend.base.interfaces.IComponentEntry;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HLinkToInterface;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.model.IPropertyChangeListener;
import hPE.frontend.base.policies.SetSliceNameEditPolicy;
import hPE.frontend.base.policies.ShowInterfaceEditPolicy;

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
        String uRef;
        String cRef;
        try {
            IHUnit u = (IHUnit) ((HUnitSlice)slice_abstraction.getCompliantUnitSlices().get(0)).getComponentEntry();
            uRef = u.getName2();
            cRef = u.getConfiguration().getRef();
        } catch (NullPointerException e) {
            uRef = "?";
            cRef = "?";
        }
        
		Label ff = new Label(" slice " + slice_abstraction.getName() + " : " + cRef + "." + uRef + " ");
		Font font = new Font(null, "Arial", 10, SWT.ITALIC);
		ff.setFont(font); 

		slice_abstraction_figure.setToolTip(ff);
        
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
