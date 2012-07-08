package hPE.frontend.base.edits;

import hPE.frontend.base.figures.UnitSliceFigure;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HLinkToInterface;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.kinds.activate.policies.SetNestingFactorEditPolicy;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.*;
import org.eclipse.draw2d.ColorConstants;


import org.eclipse.gef.editparts.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class UnitSliceEditPart<ModelType extends HUnitSlice, FigureType extends UnitSliceFigure> extends BindingEndsEditPart  {

	
	public UnitSliceEditPart() {
		super();
	}
	
	protected IFigure createFigure() {
		return new UnitSliceFigure();
	}
	
	protected void createEditPolicies() {
        super.createEditPolicies();
		this.installEditPolicy("Change Nesting Factor", new SetNestingFactorEditPolicy());
	}	
	
	
	protected void refreshVisuals() {

  	    ModelType slice_abstraction = (ModelType) getModel();
  	    FigureType slice_abstraction_figure = (FigureType) getFigure();
  	    
  	    Rectangle u_bounds = ((AbstractGraphicalEditPart) getParent()).getFigure().getBounds();
  	    
        slice_abstraction_figure.setBounds(slice_abstraction.getBounds().getTranslated(u_bounds.getLocation()));
        if (slice_abstraction.getInterface() != null) { 
            slice_abstraction_figure.setBackgroundColor(((HInterface)slice_abstraction.getInterface()).getColor());
            // slice_abstraction_figure.setForegroundColor(ColorConstants.black);
        }

        if (slice_abstraction.getNestingFactor() > 0)
            slice_abstraction_figure.setLabelText((new Integer(slice_abstraction.getNestingFactor())).toString());
        else
        	slice_abstraction_figure.setLabelText("");

        try{
	        Label ff = new Label(" slice " + (slice_abstraction.getName() == null ? "" : slice_abstraction.getName() ) + " ");
			Font font = new Font(null, "Arial", 10, SWT.ITALIC);
			ff.setFont(font);
			slice_abstraction_figure.setToolTip(ff);
        } catch (Exception e) {}
		
        
	}
	
	public List getModelTargetConnections() {

		List r = new ArrayList();

		HBinding b = ((ModelType) getModel()).getBinding();
		
		if (b != null && (!((HComponent) b.getEntry().getConfiguration()).isHiddenInnerComponent())) 
			r.add(b); 

		return r;
	}

	public void propertyChange(PropertyChangeEvent ev) {
		super.propertyChange(ev);
		if (ev.getPropertyName().equals(ModelType.PROPERTY_BOUNDS)) this.refreshVisuals();
		if (ev.getPropertyName().equals(ModelType.PROPERTY_COLOR)) {
			this.refreshVisuals();
		}
		if (ev.getPropertyName().equals(ModelType.NESTING_FACTOR_PROPERTY)) {
			this.refreshVisuals();
		}
		if (ev.getPropertyName().equals(ModelType.BINDING_CREATE_TARGET)) this.refreshTargetConnections();
		if (ev.getPropertyName().equals(ModelType.INTERFACE_SHOW)) {
			this.refreshSourceConnections();
			((ConfigurationEditPart)((UnitEditPart)this.getParent()).getParent()).refresh();
		}
		if (ev.getPropertyName().equals(ModelType.INTERFACE_HIDE)) {
			this.refreshSourceConnections();
			((ConfigurationEditPart)((UnitEditPart)this.getParent()).getParent()).refresh();
		}
	}
	
	public List getModelSourceConnections() {
		
		List r = new ArrayList();
		
		HLinkToInterface i = ((ModelType) getModel()).getLinkToInterface();
		if (i.visibleInterface() && !i.getWhich_interface().getHidden()) r.add(i);
				
		return r;
	}
	

	
		
}
