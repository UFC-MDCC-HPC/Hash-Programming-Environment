package hPE.frontend.kinds.activate.edits;

import hPE.frontend.kinds.activate.figures.ActivateInterfaceFigure;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.policies.EditProtocolEditPolicy;
import hPE.frontend.kinds.base.edits.HasPortsInterfaceEditPart;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;

public class ActivateInterfaceEditPart<ModelType extends HActivateInterface,
                                       FigureType extends ActivateInterfaceFigure> 
                  extends HasPortsInterfaceEditPart<ModelType,FigureType> {

	public ActivateInterfaceEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new ActivateInterfaceFigure();
	}
	
	protected void createEditPolicies() {
		
	   super.createEditPolicies();	   
       this.installEditPolicy("Edit Protocol", new EditProtocolEditPolicy());
	
	}
	
	public List getModelTargetConnections() {

		ModelType i = (ModelType) getModel();		
		
		if (!i.protocolIsVisible()) {
			return super.getModelTargetConnections();
		} else {
			return new ArrayList();
		}
		
	}
	    
}
