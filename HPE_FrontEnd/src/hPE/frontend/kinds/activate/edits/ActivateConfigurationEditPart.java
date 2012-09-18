package hPE.frontend.kinds.activate.edits;

import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.kinds.activate.figures.ActivateConfigurationFigure;
import hPE.frontend.kinds.activate.model.HActivateComponent;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.activate.model.protocol.HProtocolCombinator;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.IFigure;




public class ActivateConfigurationEditPart<ModelType extends HActivateComponent,
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
		boolean isProtocolMode = false;

		Iterator the_interfaces = ((ModelType) getModel()).getInterfaces().iterator();	
		// Traverse interfaces, looking for opened protocols
		while (the_interfaces.hasNext()) {
			HInterface an_interface = (HInterface) the_interfaces.next();
			if (!(an_interface.getHidden())) {
				if (an_interface instanceof HActivateInterface) {
					if (((HActivateInterface)an_interface).protocolIsVisible()) {
						children.add(an_interface);
						isProtocolMode = true;
						
						Map<String, HProtocolChoice> actions = ((HActivateInterface)an_interface).getActions();
						for (Entry<String, HProtocolChoice> action : actions.entrySet())
						{
							HProtocolChoice protocol_choice = action.getValue();
							protocol_choice.setInterface((HActivateInterface)an_interface);
							IProtocol p = HProtocolCombinator.getProtocolOf(protocol_choice);
							if (p != null)
							{
								p.setInterface(an_interface);
								p.setActionName(action.getKey());
								p.setProtocolChoice(protocol_choice);
								children.add(p);
							}
							else
							{
								children.add(protocol_choice);
							}
						}
						
					}
				}
			} 
		}
		
		// If it is not in protocol mode;
		if (!isProtocolMode) {
			return super.getModelChildren();
		} else {
			return children;
		}
		
		
		
	}

}
