package hPE.model.protocol.kinds.activate;

import org.eclipse.draw2d.geometry.Point;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class HActionEntry extends Point {

	static final long serialVersionUID = 1;

	private HCombinatorAction action;
	
	public void setActionCombinator(HCombinatorAction action) {
		this.action = action;
		
		if (!action.isRepeat()) this.setLocation(new Point(action.getBounds().width/2,1));
		                   else this.setLocation(new Point(action.getBounds().width/2,3));
	}
	
	public HActionEntry(HCombinatorAction action) {
		super();
		listeners = new PropertyChangeSupport(this);
		this.setActionCombinator(action);
	}
	
    public List getEntryConnectionIDs() {

		return action.getEntryConnectionIDs();
		
	}

	public final static String PROPERTY_LOCATION = "entry_location";
	
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
	
}
