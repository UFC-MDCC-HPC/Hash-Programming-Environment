package hPE.frontend.base.model;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.beans.PropertyChangeSupport;


public class HBinding implements Serializable {

	public final static String BINDING_CREATE = "create_binding";
	
	static final long serialVersionUID = 1;

	
	/**
	 * @uml.property   name="port"
	 */
	private IBindingTarget port = null;

	/**
	 * Getter of the property <tt>port</tt>
	 * @return  Returns the port.
	 * @uml.property  name="port"
	 */
	public IBindingTarget getPort() {
		return port;
	}

	/**
	 * Setter of the property <tt>port</tt>
	 * @param port  The port to set.
	 * @uml.property  name="port"
	 */
	public void setPort(IBindingTarget port) {
		this.port = port;
	}

	/**
	 * @uml.property  name="entry"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="binding:hPE.model.HComponentEntry"
	 */
	private IHUnit entry = null;

	/**
	 * Getter of the property <tt>entry</tt>
	 * @return  Returns the entry.
	 * @uml.property  name="entry"
	 */
	public IHUnit getEntry() {
		return entry;
	}

	/**
	 * Setter of the property <tt>entry</tt>
	 * @param entry  The entry to set.
	 * @uml.property  name="entry"
	 */
	public void setEntry(IHUnit entry) {
		this.entry = entry;
	}

	/**
	 * @uml.property   name="configuration"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="bindings:hPE.base.model.HComponent"
	 */
	private HComponent configuration = null;

	/**
	 * Getter of the property <tt>configuration</tt>
	 * @return  Returns the configuration.
	 * @uml.property  name="configuration"
	 */
	public HComponent getConfiguration() {
		return configuration;
	}

	/**
	 * Setter of the property <tt>configuration</tt>
	 * @param configuration  The configuration to set.
	 * @uml.property  name="configuration"
	 */
	public void setConfiguration(HComponent configuration) {
		this.configuration = configuration;
	}

	String name;
	
	/**
	 */
	public HBinding(HComponent c, IBindingTarget port, IHUnit entry) {
		super();
		listeners = new PropertyChangeSupport(this);
		
		this.setConfiguration(c);
		c.newBinding(this);
		this.entry = entry;
		entry.addBinding(this); //TODO: setBinding
		this.port = port;
		port.setBinding(this);

	}
	
	private PropertyChangeSupport listeners;

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

	public boolean isVisible() {
		
		boolean hiddenPort = false;
		boolean hiddenEntry = false;
		
		if (port instanceof HUnitSlice) {
			HUnitSlice us = (HUnitSlice) this.getPort();
			hiddenPort = hiddenPort || us.getHiddenSlice();			
		}
		
		if (entry instanceof IHUnit) {
			IHUnit u = this.getEntry();
			HComponent c = (HComponent)u.getConfiguration();
			hiddenEntry = hiddenEntry || (!c.isDirectSonOfTheTopConfiguration() && !c.isTopConfiguration());
		}
			
		return !hiddenPort && !hiddenEntry;
			
	}

	private int shift = -1;
	
	public void setCloneId(int shift) {	
	    this.shift = shift; 			
	}
	
	public int getCloneId() {
		return shift;
	}
	
}
