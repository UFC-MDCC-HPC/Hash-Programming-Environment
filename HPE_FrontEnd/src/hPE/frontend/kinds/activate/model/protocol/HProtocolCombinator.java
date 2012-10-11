package hPE.frontend.kinds.activate.model.protocol;

import hPE.frontend.base.exceptions.HPEInvalidNameException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.connector.xml.component.GuardType;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.connector.xml.component.impl.ProtocolCombinatorTypeImpl;
import hPE.xml.component.ComponentFactory;
import hPE.xml.component.ConditionType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;


public class HProtocolCombinator extends ProtocolCombinatorTypeImpl implements IProtocolCombinator
{
	
	public HProtocolCombinator()
	{
		super();
		
		listeners = new PropertyChangeSupport(this);		
	}
	
	static final long serialVersionUID = 1;
	
	
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

	private int combinator = -1;
	
	@Override
	public int getCombinator() 
	{
		return combinator;
	}

	@Override
	public void setCombinator(int combinator) {
		this.combinator = combinator;		
	}
	
	@Override
	public List<IProtocol> getActions() {
		
		List<IProtocol> action_list = new ArrayList<IProtocol>();
		
		int i = 0;
		for (ProtocolChoiceType p : this.getAction()) 
		{	
			IProtocol pp = null;
			if (p.getPar() != null) 
			{
				pp = (IProtocol) p.getPar();
				action_list.add(pp);
			}
			else if (p.getSeq() != null)
			{
				pp = (IProtocol) p.getSeq();
				action_list.add(pp);
			}
			else if (p.getAlt() != null)
			{
				pp = (IProtocol) p.getAlt();
				action_list.add(pp);
			}
			if (p.getPerform() != null)
			{
				pp = (IProtocol) p.getPerform();
				action_list.add(pp);
			}
			//pp.setOrder(i++);
		}
		
		return action_list;
	}

	public void setInterface(HInterface i) {
		this.i = i;
	}

	public HInterface getInterface() {
		return i;
	}

	private HInterface i = null;

	public static IProtocol getProtocolOf(ProtocolChoiceType protocol_choice) 
	{
		IProtocol p = null;
		if (protocol_choice.getPar() != null)
		{
			p = (HProtocolCombinator) protocol_choice.getPar();
			((HProtocolCombinator)p).setCombinator(IProtocolCombinator.PAR_COMBINATOR);
		}
		else if (protocol_choice.getSeq() != null)
		{
			p = (HProtocolCombinator) protocol_choice.getSeq();
			((HProtocolCombinator)p).setCombinator(IProtocolCombinator.SEQ_COMBINATOR);
		} 
		else if (protocol_choice.getAlt() != null)
		{
			p = (HProtocolCombinator) protocol_choice.getAlt();
			((HProtocolCombinator)p).setCombinator(IProtocolCombinator.ALT_COMBINATOR);
		}
		else if (protocol_choice.getPerform() != null)
		{
			p = (HProtocolPerform) protocol_choice.getPerform();
		}
		return p;
	}

	public void setActionName(String action_id) {
		this.action_id = action_id;
	}

	public String getActionName() {
		return action_id;
	}

	private String action_id;
	
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

	@Override
	public List<String> getEntryConnectionIDs() 
	{
		List<String> ids = new ArrayList<String>();
		List<IProtocol> actions = this.getActions();
		
		// takes the minimal.
		Integer min_order = Integer.MAX_VALUE;		
		for (IProtocol a : actions) 
		{
			if (min_order > a.getOrder()) 
				min_order = a.getOrder();
		}
		
		if (actions != null && !actions.isEmpty())
		{
			if (this.getCombinator() == IProtocolCombinator.SEQ_COMBINATOR)
			{
			   //Integer key = actions.get(0).hashCode();
			   Integer key = this.hashCode();
	           String id = key.toString() + "_" + min_order;
	           ids.add("protocol." + id);           
			} 
			else 
			{
				for (IProtocol p : actions)
		        {
					Integer key = p.hashCode();				
		            String id = key.toString() + "_entry";
		            ids.add("protocol." + id);
		        }
			}
		}
		
		return ids;
	}

	@Override
	public List<String> getExitConnectionIDs() 
	{
		List<String> ids = new ArrayList<String>();
		if (this.getCombinator() == IProtocolCombinator.SEQ_COMBINATOR)
		{
			if (!this.getActions().isEmpty()) 
			{
				Integer key = this.hashCode();
				String id = key.toString() + "_exit";
				ids.add("protocol." + id);
			}
		}
		else 
		{
			for (IProtocol p : this.getActions())
			{
				Integer key = p.hashCode();
				String id = key.toString() + "_exit";
				ids.add("protocol." + id);
			}
		}
		return ids;
	}

	public final static String PROPERTY_UPDATE_CHILDREN = "action_update_children";

	@Override
	public void updateChildren() {
		listeners.firePropertyChange(PROPERTY_UPDATE_CHILDREN,null,bounds);
	}

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
	
	public void updateEntryExitConnections() {
		entry.updateConnections();
		exit.updateConnections();
	}

	private HActionEntry entry = null;
	private HActionExit exit = null;
	
	@Override
	public void setEntryExit(HActionEntry entry, HActionExit exit) {
		this.entry = entry;
		this.exit = exit;
	}

	@Override
	public String getName2() 
	{
		String name="";
		
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
		if (slice_id != null) 
		{
			name += slice_id + ".";
		}
		if (cond_id != null) 
		{
			name += cond_id + "?";
		}
		if (action_id != null) 
		{
			name += action_id;
		}
		
		return name;
	}

	@Override
	public void setName(String name) throws HPEInvalidNameException 
	{
        if (name.contains("?"))
        {
    		String cond_id = null;
    		String slice_id = null;
    		String[] name_parts = name.split("[?]");
    		
    		if (name_parts.length==2 && !name_parts[1].trim().equals(""))
    		{
    			this.setId(name_parts[1]);
    		}
    		
    		if (!name_parts[0].trim().equals(""))
    		{
    			if (name_parts[0].contains(".")) 
    			{
    				String[] name_parts_slice = name_parts[0].split("[.]");
    				slice_id = name_parts_slice[0];
    				cond_id = name_parts_slice[1];
    			}
    			else
    			{
    				cond_id = name_parts[0];
    			}
    			
    			if (!cond_id.trim().equals("") || !slice_id.trim().equals("")) 
    			{
		    		GuardType newGuard = (GuardType) hPE.frontend.connector.xml.component.ComponentFactory.eINSTANCE.createGuardType();
		    		EList<hPE.frontend.connector.xml.component.ConditionType> cond_list = newGuard.getCondition();
		    		hPE.frontend.connector.xml.component.ConditionType condition = (hPE.frontend.connector.xml.component.ConditionType) hPE.frontend.connector.xml.component.ComponentFactory.eINSTANCE.createConditionType();
		    		cond_list.add(condition);
		    		
		    		if (!cond_id.trim().equals(""))
		    			condition.setCondId(cond_id);
		    		if (!slice_id.trim().equals(""))
		    			condition.setSliceId(slice_id);
	    		
		    		this.setGuard(newGuard);
    			}
    		}
    		
        }
        else
        {
    		this.setId(name);
        }
        
		updateConnections();
	}

	@Override
	public boolean isNewNameValid(String name) {
		return true;
	}
	
}
