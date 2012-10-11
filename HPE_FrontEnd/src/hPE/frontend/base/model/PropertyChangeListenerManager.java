package hPE.frontend.base.model;

import java.beans.PropertyChangeListener;

public interface PropertyChangeListenerManager {

	public void addPropertyChangeListener(PropertyChangeListener listener);
	
	public void removePropertyChangeListener(PropertyChangeListener listener);
	
}
