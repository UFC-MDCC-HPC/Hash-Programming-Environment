package hPE.frontend.kinds.activate.model.protocol;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;


import org.eclipse.draw2d.geometry.Point;

public class HActionExit extends Point {
	
	static final long serialVersionUID = 1;	
	
	private IProtocolCombinator action;
	
	public void setActionCombinator(IProtocolCombinator action) {
		this.action = action;
		if (!action.isRepeat()) this.setLocation(new Point(action.getBounds().width/2,action.getBounds().height - 11));
		                   else this.setLocation(new Point(action.getBounds().width/2,action.getBounds().height - 13));
	}
	
	public HActionExit(IProtocolCombinator action) {
		super();
		listeners = new PropertyChangeSupport(this);
		this.setActionCombinator(action);
	}

	
    public List getExitConnectionIDs() {

		return action.getExitConnectionIDs();
		
	}
    
	public final static String PROPERTY_LOCATION = "exit_location";
	
	protected PropertyChangeSupport listeners;
	
	public Point setLocation(Point location) {
		Point p = super.setLocation(location);
		listeners.firePropertyChange(PROPERTY_LOCATION,null,location);
		return p;
		
	}
	
	/**
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}

	/**
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}

	public final static String PROPERTY_UPDATE_CONNECTIONS = "exit_property_update_connections";
	
	public void updateConnections() 
	{
		listeners.firePropertyChange(PROPERTY_UPDATE_CONNECTIONS,null,null);
	}
	
}
