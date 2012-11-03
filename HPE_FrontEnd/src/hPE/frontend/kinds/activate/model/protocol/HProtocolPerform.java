package hPE.frontend.kinds.activate.model.protocol;

import hPE.frontend.base.exceptions.HPEInvalidNameException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.connector.xml.component.GuardType;
import hPE.frontend.connector.xml.component.impl.ProtocolPerformTypeImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;


public class HProtocolPerform extends ProtocolPerformTypeImpl implements IProtocolPerform
{
	public HProtocolPerform()
	{
		super();
		listeners = new PropertyChangeSupport(this);
	}
	
	static final long serialVersionUID = 1;
	
	public final static String PROPERTY_BOUNDS = "action_bounds";
	
	protected PropertyChangeSupport listeners;
	
	protected static Dimension default_dimension = new Dimension(50,50); 
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}

	/**
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}
	

	protected void newListener() {
		listeners = new PropertyChangeSupport(this);
	}

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
		this.bounds = bounds;
	}

	public void setInterface(HInterface i) {
		this.i = i;
	}

	public HInterface getInterface() {
		return i;
	}

	private HInterface i = null;
	
	public void setActionName(String action_id) {
		this.action_id = action_id;
	}

	public String getActionName() {
		return action_id;
	}

	private String action_id = null;

	@Override
	public boolean isAction() {
		return action_id != null;
	}
	
	public void setProtocolChoice(HProtocolChoice protocol_choice) {
		this.protocol_choice = protocol_choice;
	}

	public HProtocolChoice getProtocolChoice() {
		return protocol_choice;
	}

	private HProtocolChoice protocol_choice = null;

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	private int order = -1;
	
	public void setParentCombinator(IProtocolCombinator parent_combinator) {
		this.parent_combinator = parent_combinator;
	}

	public IProtocolCombinator getParentCombinator() {
		return parent_combinator;
	}


	private IProtocolCombinator parent_combinator = null;

	
	
	@Override
	public void updateConnections() {
		listeners.firePropertyChange(PROPERTY_UPDATE_CONNECTIONS,null,bounds);		
	}
	
	@Override
	public void setName(String name) throws HPEInvalidNameException 
	{
		if (name == null) name = "";
		
		if (name.contains("?")) 
		{
			String[] parts = name.split("[?]");
			String cond_id = null;
			String slice_id = null;
			if (parts[0].contains("."))
			{
				String[] parts_ = parts[0].split("[.]");
			    slice_id = parts_[0];
			    cond_id = parts_[1];
			}
			else 
			{
				cond_id = parts[0];
			}
			
    		GuardType newGuard = (GuardType) hPE.frontend.connector.xml.component.ComponentFactory.eINSTANCE.createGuardType();
    		EList<hPE.frontend.connector.xml.component.ConditionType> cond_list = newGuard.getCondition();
    		hPE.frontend.connector.xml.component.ConditionType condition = (hPE.frontend.connector.xml.component.ConditionType) hPE.frontend.connector.xml.component.ComponentFactory.eINSTANCE.createConditionType();
    		cond_list.add(condition);
    		
    		if (cond_id != null && !cond_id.trim().equals(""))
    			condition.setCondId(cond_id);
    		if (slice_id != null && !slice_id.trim().equals(""))
    			condition.setSliceId(slice_id);
		
    		this.setGuard(newGuard);
			
			
			name = parts[1];
		}
		
		if (name.contains("."))
		{
			String[] parts = name.split("[.]");
			this.setActionId(parts[1]);
			if (parts[0].contains(":"))
			{
				String[] parts_ = parts[0].split("[:]");
				this.setId(parts_[0]);
				this.setSliceId(parts_[1]);
			} 
			else 
			{
				this.setSliceId(parts[0]);
			}
		}
		else if (name.contains(":")) 
		{
			String[] parts = name.split("[:]");
			this.setId(parts[0]);
			this.setActionId(parts[1]);
		}
		else {
			this.setId(name);
		}
		
		updateConnections();
		
	}

	@Override
	public boolean isNewNameValid(String name) {
		return true;
	}

	@Override
	public String getName2() 
	{
		String cond_id = null;
		String slice_id = null;
		String action_id = this.getId();
		
		GuardType theguard = this.getGuard();
		
		if (theguard != null) {
			EList<hPE.frontend.connector.xml.component.ConditionType> cond_list = theguard.getCondition();
			if (!cond_list.isEmpty())
		    { 
				hPE.frontend.connector.xml.component.ConditionType cond = cond_list.get(0);
				if (cond.getSliceId() != null)
					slice_id = cond.getSliceId();
				if (cond.getCondId() != null)
					cond_id = cond.getCondId();
		    }
		}
		
		
			return (slice_id != null ? slice_id + "." : "") +
					(cond_id != null ? cond_id + "?" : "") +
					(this.getId() != null ? this.getId() + ":" : "") + 
				    (this.getSliceId() != null ? this.getSliceId() + "." : "*.") + 
				    (this.getActionId() != null ? this.getActionId() : "*");  	
	}
	
	
}
