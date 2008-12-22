package hPE.frontend.base.edits;

import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HActionExit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class ExitActionCombinatorEditPart extends AbstractGraphicalEditPart  implements PropertyChangeListener  {

	public ExitActionCombinatorEditPart() {
		super();
	}

	protected IFigure createFigure() {
		Ellipse e = new Ellipse();
		e.setBackgroundColor(ColorConstants.black);
		e.setSize(10,10);		
		e.setLocation((Point) getModel());
		return e;
	}

	protected void createEditPolicies() {

		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
	}
	
	public List getModelTargetConnections() {
		
		HActionExit e = (HActionExit) getModel();
		List c = new ArrayList();
		c.addAll(e.getExitConnectionIDs());
		
		return c;
	} 
	
    public void refreshVisuals() {
    	
  	    Rectangle parent_bounds = ((AbstractGraphicalEditPart) getParent()).getFigure().getBounds();
    	Ellipse e = (Ellipse) getFigure();
  	    
    	e.setLocation(parent_bounds.getBottom());
    	
    }


	public void activate() {
        if (!isActive()) 
        	((HActionExit) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HActionExit) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		
		if (ev.getPropertyName().equals(HActionExit.PROPERTY_LOCATION)) { 
			this.refreshVisuals();
			// this.refreshChildren();
		}
			
		
		
		
	}
}
