package hPE.frontend.base.edits;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HActionEntry;


public class EntryActionCombinatorEditPart extends AbstractGraphicalEditPart  implements PropertyChangeListener  {

	public EntryActionCombinatorEditPart() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public List getModelSourceConnections() {
		
		HActionEntry e = (HActionEntry) getModel();
		List c = new ArrayList();
		c.addAll(e.getEntryConnectionIDs());
		
		return c;
	}
	
    public void refreshVisuals() {
    	
  	    Rectangle parent_bounds = ((AbstractGraphicalEditPart) getParent()).getFigure().getBounds();
    	Ellipse e = (Ellipse) getFigure();
  	    
    	e.setLocation(parent_bounds.getTop());
    	
    }
	

	public void activate() {
        if (!isActive()) 
        	((HActionEntry) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HActionEntry) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		
		if (ev.getPropertyName().equals(HActionEntry.PROPERTY_LOCATION)) { 
			this.refreshVisuals();
			// this.refreshChildren();
		}
		
	}
	
}
