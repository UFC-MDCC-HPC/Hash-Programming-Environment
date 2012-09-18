package hPE.frontend.kinds.activate.edits;

import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;
import hPE.frontend.kinds.activate.model.protocol.HActionExit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Triangle;
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
		Triangle e = new Triangle();
		e.setDirection(PositionConstants.SOUTH);
		e.setBackgroundColor(ColorConstants.red);
		e.setSize(20,20);		
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
    	Triangle e = (Triangle) getFigure();
  	    
    	e.setLocation(parent_bounds.getBottom().translate(0, -20));
    	
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
		
		if (ev.getPropertyName().equals(HActionExit.PROPERTY_LOCATION)) 
		{ 
			this.refreshVisuals();
		} 
		else if (ev.getPropertyName().equals(HActionExit.PROPERTY_UPDATE_CONNECTIONS)) 
		{ 
			this.refresh();
		}
			
		
		
		
	}
}
