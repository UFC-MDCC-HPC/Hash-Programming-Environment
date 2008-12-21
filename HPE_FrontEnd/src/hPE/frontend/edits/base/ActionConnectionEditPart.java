package hPE.frontend.edits.base;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Dimension;

import hPE.frontend.figures.base.*;

import org.eclipse.draw2d.geometry.*;
import org.eclipse.draw2d.RelativeBendpoint;

public class ActionConnectionEditPart extends AbstractConnectionEditPart {

	protected void createEditPolicies() {
		
		// Selection handle edit policy. 
		// Makes the connection show a feedback, when selected by the user.
	//	this.installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
	//	this.installEditPolicy("UnbindEditPolicy", new UnbindEditPolicy());
		

	}
	
	protected IFigure createFigure() {
		
		PolylineConnection link = new PolylineConnection();
		
		PolygonDecoration d = new PolygonDecoration();
		link.setTargetDecoration(d);
		
		
		return link;
		
	}

	public void refreshVisuals () {
		
		
		if (((String)this.getModel()).startsWith("REPEAT")) {
			
			List figureConstraint = new ArrayList();
			
			
			
			// WireBendpoint wbp1 = new WireBendpoint();
			// WireBendpoint wbp2 = new WireBendpoint();
			
			RelativeBendpoint abp1 = new RelativeBendpoint(this.getConnectionFigure());  
			RelativeBendpoint abp2 = new RelativeBendpoint(this.getConnectionFigure());
			
			abp1.setRelativeDimensions(new Dimension(0,20),new Dimension(-30,0));
			abp2.setRelativeDimensions(new Dimension(0,-20),new Dimension(-20,0));
			
			figureConstraint.add(abp1);
			figureConstraint.add(abp2);
			
			
			this.getConnectionFigure().setRoutingConstraint(figureConstraint);
			
		    
		    
		} 
		
	}
	

}
