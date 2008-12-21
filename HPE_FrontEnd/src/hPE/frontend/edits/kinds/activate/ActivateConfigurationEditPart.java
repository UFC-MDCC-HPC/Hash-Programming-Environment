package hPE.frontend.edits.kinds.activate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.edits.base.ConfigurationEditPart;
import hPE.frontend.figures.base.ConfigurationFigure;
import hPE.frontend.figures.kinds.activate.ActivateConfigurationFigure;


import hPE.model.base.HInterface;
import hPE.model.base.HReplicator;
import hPE.model.kinds.activate.HActivateConfiguration;
import hPE.model.kinds.activate.HActivateInterface;
import hPE.model.kinds.activate.computation.HComputationInterface;


public class ActivateConfigurationEditPart<ModelType extends HActivateConfiguration,
			                                  FigureType extends ActivateConfigurationFigure> 
               extends ConfigurationEditPart<ModelType, FigureType> {

	public ActivateConfigurationEditPart() {
		super();
	}
	
	protected IFigure createFigure() {
		
		return new ActivateConfigurationFigure();
		
	}
	
	public List getModelChildren() {
		
		List children = new ArrayList();

		Iterator the_interfaces = ((ModelType) getModel()).getInterfaces().iterator();	
		// Traverse interfaces, looking for opened protocols
		while (the_interfaces.hasNext()) {
			HInterface an_interface = (HInterface) the_interfaces.next();
			if (!(an_interface.getHidden())) {
				if (an_interface instanceof HActivateInterface) {
					if (((HActivateInterface)an_interface).protocolIsVisible()) {
						children.add(an_interface);
						children.add(((HActivateInterface)an_interface).getProtocol());
					}
				}
			} 
		}
		
		// If it is not in protocol mode;
		if (children.isEmpty()) {
			return super.getModelChildren();
		} else {
			return children;
		}
		
		
		
	}

}
