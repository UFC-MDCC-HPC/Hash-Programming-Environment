package hPE.frontend.base.policies;

import hPE.frontend.base.commands.ResizeCommand;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.model.IHVisualElement;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;

public class UnitResizableEditPolicy extends ResizableEditPolicy {

	public static String UNIT_RESIZABLE = "UNIT_RESIZABLE";
	
	public UnitResizableEditPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Command getCommand(Request request) {

      if (REQ_RESIZE.equals(request.getType()) || REQ_MOVE.equals(request.getType())) {
       	 
       	 Rectangle s = new Rectangle();
       	 Rectangle r = ((IHUnit) this.getHost().getModel()).getBounds();
       	 
       	 s = ((ChangeBoundsRequest) request).getTransformedRectangle(r);        	 
       	 return new ResizeCommand((IHVisualElement) this.getHost().getModel(),s);
       	 
        } else
       	 return super.getCommand(request);
	
      
	}		


	

}
