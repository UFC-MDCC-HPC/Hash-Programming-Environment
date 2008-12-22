package hPE.frontend.kinds.activate.edits;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.figures.ConfigurationFigure;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.kinds.activate.figures.ActivateConfigurationFigure;
import hPE.frontend.kinds.activate.model.HActivateConfiguration;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.computation.model.HComputationInterface;




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
