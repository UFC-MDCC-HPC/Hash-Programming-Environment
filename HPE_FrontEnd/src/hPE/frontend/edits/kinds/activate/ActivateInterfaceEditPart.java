package hPE.frontend.edits.kinds.activate;

import hPE.frontend.edits.kinds.base.HasPortsInterfaceEditPart;
import hPE.frontend.edits.policies.kinds.activate.EditProtocolEditPolicy;
import hPE.frontend.figures.kinds.activate.ActivateInterfaceFigure;
import hPE.model.kinds.activate.HActivateInterface;

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
