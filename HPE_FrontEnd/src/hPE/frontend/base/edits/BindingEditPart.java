package hPE.frontend.base.edits;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import hPE.frontend.base.figures.BindingFigure;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HUnitSlice;

public class BindingEditPart extends AbstractConnectionEditPart implements PropertyChangeListener {

	protected void createEditPolicies() {
		
		// Selection handle edit policy. 
		// Makes the connection show a feedback, when selected by the user.
		this.installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		this.installEditPolicy("UnbindEditPolicy", new UnbindEditPolicy());
		

	}
	
	protected IFigure createFigure() {
		
		return new BindingFigure();
		
	}
	
	public void activate() {
        if (!isActive()) 
        	((HBinding) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HBinding) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		if (ev.getPropertyName().equals(HBinding.BINDING_CREATE)) getParent().refresh();
	}
	
	protected void refreshVisuals() {

	/*	HBinding binding = (HBinding) getModel();
		BindingFigure binding_figure = (BindingFigure) getFigure();
		
		HComponentEntry entry = binding.getEntry();
		HUnitSliceAbstraction port = binding.getPort(); */
			
		/* this.setTarget(); */
		/* this.setSource(); */
	
	}

}
