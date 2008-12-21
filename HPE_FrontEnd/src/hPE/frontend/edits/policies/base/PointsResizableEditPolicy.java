package hPE.frontend.edits.policies.base;


import hPE.frontend.commands.base.ResizeCommand;
import hPE.frontend.commands.base.ResizePortCommand;
import hPE.frontend.edits.base.PortEditPart;
import hPE.model.base.HPort;
import hPE.model.base.IHVisualElement;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;

public class PointsResizableEditPolicy extends
		ResizableEditPolicy {

	public PointsResizableEditPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Command getCommand(Request request) {

	    if (REQ_RESIZE.equals(request.getType()) || REQ_MOVE.equals(request.getType())) {
	        	 
	    	     if (this.getHost() instanceof PortEditPart) {
		        	 Rectangle s = new Rectangle();
		        	 Rectangle r = ((HPort) this.getHost().getModel()).getBounds();
		        	 
		        	 s = ((ChangeBoundsRequest) request).getTransformedRectangle(r);        	 
		        	 return new ResizePortCommand((HPort) this.getHost().getModel(),s);	    	    	 
	    	     } else {	    	
		        	 Rectangle s = new Rectangle();
		        	 Rectangle r = ((IHVisualElement) this.getHost().getModel()).getBounds();
		        	 
		        	 s = ((ChangeBoundsRequest) request).getTransformedRectangle(r);        	 
		        	 return new ResizeCommand((IHVisualElement) this.getHost().getModel(),s);
	    	     }
	        	 
	         } else
	        	 return super.getCommand(request);
		
		}		
	
	/**
	 * Returns the layer used for displaying feedback.
	 *  
	 * @return the feedback layer
	 */
	protected IFigure getFeedbackLayer() {
		return getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#initialFeedbackRectangle()
	 */
	protected Rectangle getInitialFeedbackBounds() {
		return getHostFigure().getBounds();
	}
	
}
