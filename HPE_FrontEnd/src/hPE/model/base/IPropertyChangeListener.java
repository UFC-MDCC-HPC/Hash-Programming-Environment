package hPE.model.base;

import java.beans.PropertyChangeListener;


public interface IPropertyChangeListener {

	/**
	 */
	public abstract void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 */
	public abstract void removePropertyChangeListener(PropertyChangeListener listener);

}
