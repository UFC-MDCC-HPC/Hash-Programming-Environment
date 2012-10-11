package hPE.frontend.kinds.activate.model.protocol;

import hPE.frontend.base.exceptions.HPEInvalidNameException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HNamed;
import hPE.frontend.base.model.IHVisualElement;
import hPE.frontend.base.model.IPropertyChangeListener;
import hPE.frontend.connector.xml.component.impl.ProtocolChoiceTypeImpl;
import hPE.frontend.kinds.activate.model.HActivateInterface;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class HProtocolChoice extends ProtocolChoiceTypeImpl implements IHVisualElement, Serializable, Cloneable, IPropertyChangeListener, HNamed  {

	public HProtocolChoice(String action_name)
	{
		super();
		listeners = new PropertyChangeSupport(this);
		this.action_name = action_name;
		//setBounds(new Rectangle());
	}
	
	public HProtocolChoice()
	{
		super();
		listeners = new PropertyChangeSupport(this);
		//setBounds(new Rectangle());
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2331672359008340080L;

	protected PropertyChangeSupport listeners;
	
	protected static Dimension default_dimension = new Dimension(50,50); 
	
	public void addPropertyChangeListener(PropertyChangeListener listener) 
	{
		listeners.addPropertyChangeListener(listener); 
	}

	/**
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}

	public final static String PROPERTY_BOUNDS = "action_bounds";
	
	private Rectangle bounds = null;
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return bounds;
	}

	@Override
	public void setBounds(Rectangle bounds) 
	{
		this.setBoundsNoUpdate(bounds);
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
	}
	
	public void setBoundsNoUpdate(Rectangle bounds) 
	{
		if (bounds.x < 0) { bounds.x = 0; }
		if (bounds.y < 0) { bounds.y = 0; }
		if (bounds.height <= 0) { bounds.height = this.bounds.height < 0 ? 2 : this.bounds.height; }
		if (bounds.width <= 0) { bounds.width = this.bounds.width < 0 ? 2 : this.bounds.width; }
				
		this.bounds = bounds;
	}
	
	public final static String PROPERTY_UPDATE_CHILDREN = "action_update_children";

	public void updateChildren() 
	{
		listeners.firePropertyChange(PROPERTY_UPDATE_CHILDREN,null,bounds);
	}

	public void setInterface(HActivateInterface i) {
		this.i = i;
	}

	public HActivateInterface getInterface() {
		return i;
	}

	private HActivateInterface i = null;

	private String action_name = null;
	
	public String getActionName() {		
		return action_name;
	}

	public void setActionName(String actionName) {		
		if (i != null)
		{
			i.getActions().remove(this.action_name);
		}
		 this.action_name = actionName;
		 if (i != null) {
			i.newAction(actionName, this);		 
			updateChildren();
		 }
	}

	@Override
	public String getName2() {
		if (this.getActionName() == null) return "?";
		return this.getActionName();
	}

	@Override
	public void setName(String name) throws HPEInvalidNameException 
	{
		this.setActionName(name);
	}

	@Override
	public boolean isNewNameValid(String name) {
		// TODO Auto-generated method stub
		return true;
	}

	public IProtocol getProtocol() 
	{
		if (this.getPar() != null) return (IProtocol) this.getPar();
		if (this.getSeq() != null) return (IProtocol) this.getSeq();
		if (this.getAlt() != null) return (IProtocol) this.getAlt();
		if (this.getPerform() != null) return (IProtocol) this.getPerform();
		return null;
	}
}
