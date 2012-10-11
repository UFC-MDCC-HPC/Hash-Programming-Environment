package hPE.frontend.kinds.activate.model.protocol;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HNamed;
import hPE.frontend.base.model.IHVisualElement;
import hPE.frontend.base.model.IPropertyChangeListener;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;

import java.io.Serializable;

import org.eclipse.draw2d.geometry.Rectangle;

public interface IProtocol 
	extends IHVisualElement, 
			 Serializable, 
			 Cloneable, 
			 IPropertyChangeListener,
			 HNamed {

	HInterface getInterface();
	void setInterface(HInterface i);
	void setActionName(String action_id);
	String getActionName();
	boolean isAction();
	void setProtocolChoice(HProtocolChoice protocol_choice);
	HProtocolChoice getProtocolChoice();
	void setOrder(int i);
	int getOrder();
	void setParentCombinator(IProtocolCombinator protocol_combinator);
	public IProtocolCombinator getParentCombinator();
	void setBoundsNoUpdate(Rectangle copy);
	boolean isRepeat();
	void updateConnections();
	public final static String PROPERTY_UPDATE_CONNECTIONS = "action_update_connections";
	String getId();
	void setRepeat(boolean b);
	
}
