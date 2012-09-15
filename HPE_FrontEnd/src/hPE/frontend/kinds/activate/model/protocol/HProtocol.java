package hPE.frontend.kinds.activate.model.protocol;

import hPE.frontend.base.interfaces.IAction;
import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.interfaces.IProtocol;
import hPE.frontend.base.model.HVisualElement;
import hPE.frontend.kinds.activate.model.HActivateInterface;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class HProtocol extends HVisualElement implements Serializable, IProtocol {

	static final long serialVersionUID = 1;

	private static Dimension default_dimension = new Dimension(200,200); 
	
	/**
	 * @uml.property   name="action"
	 * @uml.associationEnd   readOnly="true" multiplicity="(1 1)" inverse="protocol:hPE.model.computation.protocol.HAction"
	 */
	private HAction action ;

	/** 
	 * Getter of the property <tt>action</tt>
	 * @return  Returns the action.
	 * @uml.property  name="action"
	 */
	public IAction getAction() {
		return action;
	}

	/**
	 * @uml.property   name="semaphores"
	 * @uml.associationEnd   readOnly="true" multiplicity="(0 -1)" inverse="protocol:hPE.model.computation.protocol.HSemaphore"
	 */
	private Collection semaphores;

	/** 
	 * Getter of the property <tt>semaphores</tt>
	 * @return  Returns the semaphores.
	 * @uml.property  name="semaphores"
	 */
	public Collection getSemaphores() {
		return semaphores;
	}

	
	/**
	 * @uml.property   name="which_interface"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="protocol:hPE.model.computation.HComputationInterface"
	 */
	private HActivateInterface which_interface = null;

	/** 
	 * Getter of the property <tt>which_interface</tt>
	 * @return  Returns the which_interface.
	 * @uml.property  name="which_interface"
	 */
	public IInterface getInterface() {
		return which_interface;
	}


	/** 
	 * Setter of the property <tt>which_interface</tt>
	 * @param which_interface  The which_interface to set.
	 * @uml.property  name="which_interface"
	 */
	public void setWhich_interface(HActivateInterface which_interface) {
		this.which_interface = which_interface;
	}

	public final static String PROPERTY_BOUNDS = "protocol_bounds";

	private PropertyChangeSupport listeners;

	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
	}
	
	public HProtocol(HActivateInterface which_interface) {
		super();
		listeners = new PropertyChangeSupport(this);
		this.which_interface = which_interface;
		//which_interface.setProtocol(this);
		
		// Default position and dimension
		Rectangle bounds = which_interface.getBounds().getCopy();
		bounds.setLocation(bounds.width/2, bounds.height/2);
		bounds.setSize(default_dimension);
		
		setBounds(bounds);
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

	public final static String PROPERTY_ACTION = "protocol_action";
	
	/**
	 */
	public void setAction(HAction action) {
		this.action = action;
		listeners.firePropertyChange(PROPERTY_ACTION,null,action);
	}


	/**
	 */
	public void addSemaphore(HSemaphore semaphore) {
		this.semaphores.add(semaphore);
	}

	
	
	
	
}
