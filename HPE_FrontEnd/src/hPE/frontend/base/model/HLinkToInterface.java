package hPE.frontend.base.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import java.util.Collection;



public class HLinkToInterface implements Serializable, Cloneable {

	static final long serialVersionUID = 1;
	
	PropertyChangeSupport listeners;

	public final static String SHOW_INTERFACE = "show_interface";
	public final static String HIDE_INTERFACE = "hide_interface";
	
	private IHasInterface linked;
	
	public IHasInterface getLinked() {
		return linked;
	}
	
	public HLinkToInterface(IHasInterface linked_to_interface) {
		super();
		
		listeners = new PropertyChangeSupport(this);
		this.linked = linked_to_interface;
	}

	/**
	 * @uml.property   name="which_interface"
	 * @uml.associationEnd   inverse="linksToTheInterface:hPE.base.model.HInterface"
	 */
	private HInterface link_to_interface;

	/** 
	 * Getter of the property <tt>which_interface</tt>
	 * @return  Returns the link_to_interface.
	 * @uml.property  name="which_interface"
	 */
	public HInterface getWhich_interface() {
	
		/*		HConfiguration c = (HConfiguration) this.link_to_interface.getConfiguration();
		 HConfiguration topC = (HConfiguration) c.getTopConfiguration();
		 return topC.getInterface(this.link_to_interface.toString()); */
	
		return link_to_interface;
	}

	/** 
	 * Setter of the property <tt>which_interface</tt>
	 * @param which_interface  The link_to_interface to set.
	 * @uml.property  name="which_interface"
	 */
	public void setWhich_interface(HInterface which_interface) {
		link_to_interface = which_interface;
		which_interface.addLinkToInterface(this);
	}

	private boolean visible_interface = false;
	
	public boolean visibleInterface() {
		return visible_interface;
	}
	
	public void show_interface()
	{
       visible_interface = true;
       this.getWhich_interface().show();
       listeners.firePropertyChange(SHOW_INTERFACE,null,this.getWhich_interface());
       
	}
	
	public void hide_interface()	
	{
	       visible_interface = false;
	       this.getWhich_interface().hide();
   		   listeners.firePropertyChange(HIDE_INTERFACE,null,this.getWhich_interface());
	}
	
	public final static String PROPERTY_COLOR = "linktointerface_color";
	
    public void notify_new_color() {
		listeners.firePropertyChange(PROPERTY_COLOR,null,this.getWhich_interface().getColor());
    }
	
    
    public void removeMe() {
    	
    	HInterface i = this.getWhich_interface(); 
    	Collection ls = i.getLinksToTheInterface();    	   	
    	ls.remove(this);
    	if (ls.size() == 0) {
    		// ((HConfiguration)((HConfiguration)i.getConfiguration()).getTopConfiguration()).removeInterface(i);
    		i.removeMe();
    	}
    	
    	
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
	
	public HLinkToInterface replicateMe(IHasInterface s) {
        try {
			HLinkToInterface r = (HLinkToInterface) this.clone();
		    r.linked = s;	
		    r.setWhich_interface((HInterface)s.getInterface());
			return r;
        }
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	
	
}
