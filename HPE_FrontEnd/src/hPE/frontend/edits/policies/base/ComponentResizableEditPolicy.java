package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;

import hPE.frontend.commands.base.ResizeCommand;
import hPE.model.base.HComponent;
import hPE.model.base.IHVisualElement;

import org.eclipse.draw2d.geometry.Rectangle;



public class ComponentResizableEditPolicy extends ResizableEditPolicy {

	public static String COMPONENT_RESIZABLE = "COMPONENT_RESIZABLE";
	
	public ComponentResizableEditPolicy() {
		super();
		// TODO Auto-generated constructor stub
		
		
	}
	
	public Command getCommand(Request request) {

    if (REQ_RESIZE.equals(request.getType()) || REQ_MOVE.equals(request.getType())) {
        	 
        	 Rectangle s = new Rectangle();
        	 Rectangle r = ((HComponent) this.getHost().getModel()).getBounds();
        	 
        	 s = ((ChangeBoundsRequest) request).getTransformedRectangle(r);        	 
        	 return new ResizeCommand((IHVisualElement) this.getHost().getModel(),s);
        	 
         } else
        	 return super.getCommand(request);
	
	}		

}
