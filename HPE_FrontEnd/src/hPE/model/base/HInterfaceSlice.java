package hPE.model.base;

import java.beans.PropertyChangeListener;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Point;

import hPE.model.base.exceptions.HPENotFusableSlicesException;
import hPE.model.interfaces.IInterface;
import hPE.model.interfaces.IConfiguration;
import hPE.model.interfaces.IInterfaceSlice;
import hPE.model.kinds.data.*;
import hPE.util.Pair;
import hPE.util.Triple;



public abstract class HInterfaceSlice extends hPE.model.base.HVisualElement implements Serializable, IPropertyChangeListener, IHasInterface, IInterfaceSlice, INamed {

	static final long serialVersionUID = 1;
	public static int raio = 5;
	public static int diameter = raio*2;

	/**
	 * @uml.property   name="name" readOnly="true"
	 */
	private String name = "";

	/** 
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	private String defaultName_ = null;
	
	public void setName(String name) {
		if (defaultName_ == null && !this.name.equals(name)) 
			this.defaultName_ = this.name; 
		else if (defaultName_ != null && name.equals(this.defaultName_)) 
			    this.defaultName_ = null;
		
		this.name = name;
		
	}
	
	public boolean IsDefaultName() {
		return this.defaultName_ == null;
	}
	
	public String getDefaultName() {
		return this.defaultName_ == null ? this.name : this.defaultName_;
	}
	
	public void resetDefaultName() {
		this.defaultName_ = null;
	}
	
	/**
	 */
	public HInterfaceSlice(String name, HInterface which_interface, HInterfaceSig interface_sig, int nestingFactor) {
		super();
		listeners = new PropertyChangeSupport(this);
		this.setInterface(which_interface);
		this.interface_sig = interface_sig;
		interface_sig.addSlice(this);
		this.name = name;
		this.nestingFactor = nestingFactor;
		Rectangle r = new Rectangle(); // unit.getBounds().getCopy();
		r.setSize(diameter,diameter);
		r.setLocation(new Point(0,0));
		this.setBounds(r);
	}

	private List compliantUnitSlices = new ArrayList();
	
    public void addCompliantUnitSlice(HUnitSlice unit) {
	   	if (!compliantUnitSlices.contains(unit)) compliantUnitSlices.add(unit);
	}
	    
	public void removeCompliantUnitSlice(HUnitSlice unit) {
	  	compliantUnitSlices.remove(unit);
	}
	    
	public List getCompliantUnitSlices () {
	   	return this.compliantUnitSlices;
	}	
	
	
	public final static String PROPERTY_COLOR = "Change Color";
	
	public void notifyColorChange() {
		listeners.firePropertyChange(PROPERTY_COLOR,null,name);
    }

	public final static String PROPERTY_BOUNDS = "slice_bounds";
	
	private PropertyChangeSupport listeners;
	
	protected PropertyChangeSupport getListeners() {
		return listeners;
	}
	
	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);		
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

	public final static String INTERFACE_SHOW = "show_interface";
	public final static String INTERFACE_HIDE = "hide_interface";
	
	public void showInterface()
	{
		this.getLinkToInterface().show_interface();
		listeners.firePropertyChange(INTERFACE_SHOW,null,name);
	}
	
	public void hideInterface()	
	{
		this.getLinkToInterface().hide_interface();
		listeners.firePropertyChange(INTERFACE_HIDE,null,name);
	}
	
	private int nestingFactor = 0;
		
	public int getNestingFactor() {
		return nestingFactor;
	}


	/**
	 * @uml.property   name="interface_sig"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="slices:hPE.base.model.HInterfaceSig"
	 */
	private HInterfaceSig interface_sig = null;

	/**
	 * Getter of the property <tt>interface_sig</tt>
	 * @return  Returns the interface_sig.
	 * @uml.property  name="interface_sig"
	 */
	public HInterfaceSig getInterfaceSig() {
		return interface_sig;
	}

	/**
	 * Setter of the property <tt>interface_sig</tt>
	 * @param interface_sig  The interface_sig to set.
	 * @uml.property  name="interface_sig"
	 */
	public void setInterface_sig(HInterfaceSig interface_sig) {
		this.interface_sig = interface_sig;
	}


	/**
	 * @uml.property   name="linkToInterface"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="hSliceAbstraction:hPE.base.model.HLinkToInterface"
	 */
	private HLinkToInterface linkToInterface = null;

	/**
	 * Getter of the property <tt>linkToInterface</tt>
	 * @return  Returns the linkToInterface.
	 * @uml.property  name="linkToInterface"
	 */
	public HLinkToInterface getLinkToInterface() {
		return linkToInterface;
	}

	/**
	 * Setter of the property <tt>linkToInterface</tt>
	 * @param linkToInterface  The linkToInterface to set.
	 * @uml.property  name="linkToInterface"
	 */
	public void setLinkToInterface(HLinkToInterface linkToInterface) {
		this.linkToInterface = linkToInterface;
	}
	
	public void setInterface(HInterface which_interface) {
		
		if (this.getLinkToInterface() != null) {
			this.getLinkToInterface().removeMe();
		}
		
		
		HLinkToInterface li = new HLinkToInterface(this);
		li.setWhich_interface(which_interface);
		this.setLinkToInterface(li);
		
	}
	
	public final static String RELOAD_PORTS = "RELOAD_PORTS";
	
		
	public IInterface getInterface() {
		return this.getLinkToInterface().getWhich_interface();
	}

	public boolean visibleInterface() {
		return this.getLinkToInterface().visibleInterface();
	}

	
	public IConfiguration getConfiguration() {
		
		List<HUnitSlice> ls = this.getCompliantUnitSlices();
		if (!ls.isEmpty())
		    return ((HUnitSlice)this.getCompliantUnitSlices().get(0)).getConfiguration();
		else 
			return null;
		 
	}
	
	public void setInerited(boolean isInerited) {
		this.isInerited = isInerited;
	}

	public boolean isInerited() {
		return isInerited;
	}

	private boolean isInerited = false;
	
	private List<HPort> portsOwnedByThisSlice = new ArrayList<HPort>();
	
	public void setPorts(List<HPort> ports) {
		if (ports == null) ports = new ArrayList();
		this.portsOwnedByThisSlice = ports;
	}
	
	public List<HPort> getPorts() {
		if (portsOwnedByThisSlice == null) portsOwnedByThisSlice = new ArrayList();
		return this.portsOwnedByThisSlice;
	}
	
	public void setMyPort(HPort myPort) {
		this.myPort = myPort;
	}

	public HPort getMyPort() {
		return myPort;
	}

	private HPort myPort = null;

	public HPort getPortByName(String ref) {
		for (HPort port : this.getPorts()) {
		   if (port.getName().equals(ref)) {
			   return port;
		   } 
		}
		return null;		
	}

	public boolean hasSlice(HInterfaceSlice s) {
		
		if (s == this) return true;
		
		HInterface i = (HInterface) this.getInterface();
		for (HInterfaceSlice s_ : i.getSlices()) {
			if (s_.hasSlice(s)) {
				return true;
			} 
		}
		
		return false;
	}
	

	
}
